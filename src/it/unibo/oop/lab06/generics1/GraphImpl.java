package it.unibo.oop.lab06.generics1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphImpl<N> implements Graph<N>{
	
	private Set<NodeImpl<N>> nodes;
	
	public GraphImpl(){
		this.nodes = new HashSet<NodeImpl<N>>();
	}
	
	public GraphImpl(Collection<NodeImpl<N>> initialSet){
		this();
		this.nodes.addAll(initialSet);
	}

	@Override
	public void addNode(N node) {
		this.nodes.add(new NodeImpl<N>(node));
	}
	
	private NodeImpl<N> findNode(N target){
		var it = this.nodes.iterator();
		NodeImpl<N> node = it.next();
		while(!node.hasValue(target) && it.hasNext()) {
			node = it.next();
		}
		if (node.hasValue(target)) {
			return node;
		}
		return null;
	}

	@Override
	public void addEdge(N source, N target) {
		var src = this.findNode(source);
		var dst = this.findNode(target);
		if (src != null && dst != null) {
			src.addEdge(dst);
		}
	}

	@Override
	public Set<N> nodeSet() {
		Set<N> values = new HashSet<N>();
		for (NodeImpl<N> node : this.nodes) {
			values.add(node.getValue());
		}
		return values;
	}

	@Override
	public Set<N> linkedNodes(N node) {
		Set<N> linked = new HashSet<N>();
		var edges = this.findNode(node).getEdges();
		for (var edge : edges) {
			linked.add(edge.getValue());
		}
		return linked;
	}
	
	private enum Color {
		WHITE, GRAY, BLACK
	}
	
	private int findIndex(ArrayList<NodeImpl<N>> list, N n) {
		int i = 0;
		while (i < list.size() && !list.get(i).hasValue(n)) {
			i++;
		}
		return i;
	}
	
	private void initializeSingleSource (ArrayList<NodeImpl<N>> nodeList, 
			ArrayList<N> fathers, Color[] visited, N source) {
		for (int i = 0; i < nodeList.size(); i++) {
			visited[i] = Color.WHITE;
		}
		fathers.set(this.findIndex(nodeList, source), source);
		visited[this.findIndex(nodeList, source)] = Color.GRAY;
	}
	
	
	private ArrayList<N> reconstructPath(ArrayList<NodeImpl<N>> list, N source,
			N dest, ArrayList<N> father){
		ArrayList<N> path = new ArrayList<N>();
		N u = dest;
		while (father.get(this.findIndex(list, u)) != u) {
			path.add(0, u);
			u = father.get(this.findIndex(list, u));
		}
		path.add(0, source);
		return path;
	}
	
	private void BFS(ArrayList<NodeImpl<N>> nodeList, N source,
			N dest, ArrayList<N> fathers) {
		Color[] visited = new Color[this.nodes.size()];
		ArrayList<NodeImpl<N>> toVisit = new ArrayList<NodeImpl<N>>();
		
		this.initializeSingleSource(nodeList, fathers, visited, source);
		
		toVisit.add(nodeList.get(this.findIndex(nodeList, source)));
		while(!toVisit.isEmpty()) {
			var u = toVisit.get(0);
			for (var v : u.getEdges()) {
				if (visited[nodeList.indexOf(v)] == Color.WHITE) {
					visited[nodeList.indexOf(v)] = Color.GRAY;
					fathers.set(nodeList.indexOf(v), u.getValue());
					toVisit.add(v);
				}
			}
			toVisit.remove(0);
			visited[nodeList.indexOf(u)] = Color.BLACK;
		}
	}
	
	@Override
	public List<N> getPath(N source, N target) {
		ArrayList<NodeImpl<N>> nodeList = new ArrayList<>(this.nodes);
		ArrayList<N> fathers = new ArrayList<N>();
		for (var v : nodeList) {
			fathers.add(null);
		}
		this.BFS(nodeList, source, target, fathers);

		return this.reconstructPath(nodeList, source, target, fathers);
	}

}
