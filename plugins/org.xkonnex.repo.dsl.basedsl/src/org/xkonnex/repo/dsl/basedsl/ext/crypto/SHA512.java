package org.xkonnex.repo.dsl.basedsl.ext.crypto;

public class SHA512 implements IHashAlgorithm, ISigningAlgorithm {
	
	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
