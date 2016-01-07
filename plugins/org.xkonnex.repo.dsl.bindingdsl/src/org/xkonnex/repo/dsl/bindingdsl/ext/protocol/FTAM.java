package org.xkonnex.repo.dsl.bindingdsl.ext.protocol;

import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ExtensibleImportBindingProtocol;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ImportBindingProtocol;

public class FTAM implements IProtocol {
	
	private String folder;

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	@Override
	public boolean supportsModuleImportBindingProtocol(
			ImportBindingProtocol importBindingProtocol) {
		if (importBindingProtocol instanceof ExtensibleImportBindingProtocol) {
			ExtensibleImportBindingProtocol extProt = (ExtensibleImportBindingProtocol)importBindingProtocol;
			if (extProt.getType().getQualifiedName().equals(org.xkonnex.repo.dsl.moduledsl.ext.protocol.FTAM.class.getCanonicalName()))
				return true;
		}
		return false;
	}

}
