package it.unibo.oop.lab06.generics1;

import java.util.Set;
import java.util.HashSet;

public class NodeImpl<N> {
	private N value;
	private Set<NodeImpl<N>> edges;
	
	public NodeImpl(final N val) {
		this.value = val;
		this.edges = new HashSet<>();
	}

	public N getValue() {
		return this.value;
	}

	public Set<NodeImpl<N>> getEdges(){
		return this.edges;
	}
	
	public void addEdge(NodeImpl<N> dst) {
		this.edges.add(dst);
	}
	
	public boolean hasValue(N n) {
		return this.value == n;
	}

}
