package org.fornax.soa.basedsl.ref;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.xtext.resource.IEObjectDescription;

public class DependencyDescription implements Iterable<DependencyDescription> {
	
	private IEObjectDescription source;
	
	private IEObjectDescription target;
	
	private IEObjectDescription container;
	
	private Deque<DependencyDescription> dependencies;
	
	private DependencyDescription referrer;
	
	private boolean isBackRef;
	
	
	public DependencyDescription(IEObjectDescription target,
			IEObjectDescription sourceContainer) {
		super();
		this.target = target;
		this.container = sourceContainer;
		dependencies = new ArrayDeque<DependencyDescription>();
	}

	public DependencyDescription (IEObjectDescription source, IEObjectDescription target,
			IEObjectDescription targetContainer,
			DependencyDescription referrer) {
		super();
		if (target == null)
			throw new IllegalArgumentException();
		this.setSource(source);
		this.target = target;
		this.container = targetContainer;
		this.referrer = referrer;
	}

	public DependencyDescription (IEObjectDescription source, IEObjectDescription target,
			IEObjectDescription targetContainer,
			Deque<DependencyDescription> dependencies, DependencyDescription referrer) {
		super();
		if (target == null)
			throw new IllegalArgumentException();
		this.setSource(source);
		this.target = target;
		this.container = targetContainer;
		this.dependencies = dependencies;
		this.referrer = referrer;
	}

	public void setSource(IEObjectDescription source) {
		this.source = source;
	}

	public IEObjectDescription getSource() {
		return source;
	}

	public IEObjectDescription getTarget() {
		return target;
	}

	public void setTarget(IEObjectDescription target) {
		this.target = target;
	}

	public IEObjectDescription getContainer() {
		return container;
	}

	public void seteContainer(IEObjectDescription eContainer) {
		this.container = eContainer;
	}

	public Deque<DependencyDescription> getDependencies() {
		return dependencies;
	}

	public void setDependencies(Deque<DependencyDescription> dependencies) {
		this.dependencies = dependencies;
	}
	
	public void setReferrer(DependencyDescription referrer) {
		this.referrer = referrer;
	}

	/**
	 * The referrer to this dependency. A DependencyDescription is referrer to this 
	 * DependencyDescription if it's target matches the source of this description
	 * @return
	 */
	public DependencyDescription getReferrer() {
		return referrer;
	}

	public void setBackRef(boolean isBackRef) {
		this.isBackRef = isBackRef;
	}

	/**
	 * Denotes a backward reference in the dependency graph
	 * 
	 * @returns True, when the dependency is a backward reference
	 * in the dependency graph, i.e. the target has already been visited from
	 * a transitive upstream referrerin the graph
	 */
	public boolean isBackRef() {
		return isBackRef;
	}

	public boolean contains (DependencyDescription dependency) {
		if (this.equals(dependency))
			return true;
		for (DependencyDescription dep : dependencies) {
			if (dep.contains (dependency))
				return true;
		}
		return false;
	}
	

	public Iterator<DependencyDescription> iterator() {
		return new DepIterator (this);
	}

	private class DepIterator implements Iterator<DependencyDescription> {
		
		private DependencyDescription first;
		boolean isFirst = true;

		private Iterator<DependencyDescription> currentKeyIt;
		private Iterator<DependencyDescription> currentDepIt;
		
		public DepIterator(DependencyDescription dep) {
			if (dependencies != null) {
				currentKeyIt = dependencies.iterator();
			}
			first = dep;
		}

		public boolean hasNext() {
			if (!isFirst) {
				return currentDepIt != null && currentDepIt.hasNext() || 
					currentKeyIt != null && currentKeyIt.hasNext();
			}
			return first != null;
		}

		public DependencyDescription next() {
			DependencyDescription next = successor();
			return next;
		}

		public void remove() {
			throw new RuntimeException ("Not implemented");
		}
		
		private DependencyDescription successor() {
			if (isFirst) {
				isFirst = false;
				return first;
			}
			if (currentDepIt != null && currentDepIt.hasNext()) {
				return currentDepIt.next();
			}
			if (currentKeyIt != null && currentKeyIt.hasNext()) {
				DependencyDescription nextDep = currentKeyIt.next();
				currentDepIt = nextDep.iterator();
				return nextDep;
			}
			throw new NoSuchElementException();
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((target == null) ? 0 : target.hashCode());
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
		DependencyDescription other = (DependencyDescription) obj;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals (other.target))
			return false;
		return true;
	}

}
