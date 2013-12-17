package org.fornax.soa.xsr.connex.web.git;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jgit.http.server.resolver.DefaultReceivePackFactory;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.Config.SectionParser;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.ReceivePack;
import org.eclipse.jgit.transport.UploadPack;
import org.eclipse.jgit.transport.resolver.ReceivePackFactory;
import org.eclipse.jgit.transport.resolver.ServiceNotAuthorizedException;
import org.eclipse.jgit.transport.resolver.ServiceNotEnabledException;
import org.fornax.soa.xsr.connex.core.config.RepositoryDescription;
import org.fornax.soa.xsr.connex.core.config.RepositoryType;

public class ConnexReceivePackFactory<C> extends DefaultReceivePackFactory {

	private static final SectionParser<ServiceConfig> CONFIG = new SectionParser<ServiceConfig>() {
		public ServiceConfig parse(final Config cfg) {
			return new ServiceConfig(cfg);
		}
	};

	private static class ServiceConfig {
		final boolean set;

		final boolean enabled;

		ServiceConfig(final Config cfg) {
			set = cfg.getString("http", null, "receivepack") != null;
			enabled = cfg.getBoolean("http", "receivepack", false);
		}
	}
	
	private RepositoryDescription repositoryDescription;

	public ConnexReceivePackFactory(RepositoryDescription repoDesc) {
		repositoryDescription = repoDesc;
	}

	public ReceivePack create(final HttpServletRequest req, final Repository db)
			throws ServiceNotEnabledException, ServiceNotAuthorizedException {
		final ServiceConfig cfg = db.getConfig().get(CONFIG);
		String user = req.getRemoteUser();

		if (cfg.set) {
			if (cfg.enabled) {
				if (user == null || "".equals(user))
					user = "anonymous";
				return createFor(req, db, user);
			}
			throw new ServiceNotEnabledException();
		}

		if (user != null && !"".equals(user))
			return createFor(req, db, user);
		throw new ServiceNotAuthorizedException();
	}

	private ReceivePack createFor(final HttpServletRequest req,
			final Repository db, final String user) {
		final ConnexReceivePack rp = new ConnexReceivePack(db, repositoryDescription);
		rp.setRefLogIdent(toPersonIdent(req, user));
		return rp;
	}

	private static PersonIdent toPersonIdent(HttpServletRequest req, String user) {
		return new PersonIdent(user, user + "@" + req.getRemoteHost());
	}
}
