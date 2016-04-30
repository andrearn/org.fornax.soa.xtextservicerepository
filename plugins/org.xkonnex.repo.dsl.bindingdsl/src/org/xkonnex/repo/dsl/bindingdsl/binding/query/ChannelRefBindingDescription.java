package org.xkonnex.repo.dsl.bindingdsl.binding.query;

import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ChannelRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.semanticsdsl.semanticsDsl.Qualifier;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Channel;

public class ChannelRefBindingDescription {

	private ChannelRef channelRef;

	private Channel resolvedChannel;
	
	private AnyBinding applicableBinding;
	
	private Module providingModule;
	
	private Qualifier endpointQualifier;

	public ChannelRef getChannelRef() {
		return channelRef;
	}

	public void setChannelRef(ChannelRef channelRef) {
		this.channelRef = channelRef;
	}

	public Channel getResolvedChannel() {
		return resolvedChannel;
	}

	public void setResolvedChannel(Channel resolvedChannel) {
		this.resolvedChannel = resolvedChannel;
	}

	public AnyBinding getApplicableBinding() {
		return applicableBinding;
	}

	public void setApplicableBinding(AnyBinding applicableBinding) {
		this.applicableBinding = applicableBinding;
	}

	public Module getProvidingModule() {
		return providingModule;
	}

	public void setProvidingModule(Module providingModule) {
		this.providingModule = providingModule;
	}

	public Qualifier getEndpointQualifier() {
		return endpointQualifier;
	}

	public void setEndpointQualifier(Qualifier endpointQualifier) {
		this.endpointQualifier = endpointQualifier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((applicableBinding == null) ? 0 : applicableBinding
						.hashCode());
		result = prime * result
				+ ((channelRef == null) ? 0 : channelRef.hashCode());
		result = prime
				* result
				+ ((endpointQualifier == null) ? 0 : endpointQualifier
						.hashCode());
		result = prime * result
				+ ((providingModule == null) ? 0 : providingModule.hashCode());
		result = prime * result
				+ ((resolvedChannel == null) ? 0 : resolvedChannel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChannelRefBindingDescription other = (ChannelRefBindingDescription) obj;
		if (applicableBinding == null) {
			if (other.applicableBinding != null)
				return false;
		} else if (!applicableBinding.equals(other.applicableBinding))
			return false;
		if (channelRef == null) {
			if (other.channelRef != null)
				return false;
		} else if (!channelRef.equals(other.channelRef))
			return false;
		if (endpointQualifier == null) {
			if (other.endpointQualifier != null)
				return false;
		} else if (!endpointQualifier.equals(other.endpointQualifier))
			return false;
		if (providingModule == null) {
			if (other.providingModule != null)
				return false;
		} else if (!providingModule.equals(other.providingModule))
			return false;
		if (resolvedChannel == null) {
			if (other.resolvedChannel != null)
				return false;
		} else if (!resolvedChannel.equals(other.resolvedChannel))
			return false;
		return true;
	}

	
}
