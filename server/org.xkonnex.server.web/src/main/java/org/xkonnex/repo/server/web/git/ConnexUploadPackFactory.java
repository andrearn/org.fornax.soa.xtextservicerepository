package org.xkonnex.repo.server.web.git;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jgit.http.server.resolver.DefaultUploadPackFactory;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.Config.SectionParser;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.UploadPack;
import org.eclipse.jgit.transport.resolver.ServiceNotAuthorizedException;
import org.eclipse.jgit.transport.resolver.ServiceNotEnabledException;
import org.eclipse.jgit.transport.resolver.UploadPackFactory;
import org.xkonnex.repo.server.core.config.RepositoryDescription;
import org.xkonnex.repo.server.core.config.RepositoryType;

public class ConnexUploadPackFactory<C> extends DefaultUploadPackFactory {

	private static final SectionParser<ServiceConfig> CONFIG = new SectionParser<ServiceConfig>() {
		public ServiceConfig parse(final Config cfg) {
			return new ServiceConfig(cfg);
		}
	};

	private static class ServiceConfig {
		final boolean enabled;

		ServiceConfig(final Config cfg) {
			enabled = cfg.getBoolean("http", "uploadpack", true);
		}
	}
	
	private RepositoryDescription repositoryDescription;

	public ConnexUploadPackFactory(RepositoryDescription repoDesc) {
		repositoryDescription = repoDesc;
	}

	public UploadPack create(final HttpServletRequest req, final Repository db)
			throws ServiceNotEnabledException, ServiceNotAuthorizedException {
		if (db.getConfig().get(CONFIG).enabled)
			return new ConnexUploadPack(db, repositoryDescription);
		else
			throw new ServiceNotEnabledException();
	}
	

}
