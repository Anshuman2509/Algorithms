package test3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph {
	private Map<Integer, LinkedList<Integer>> vertices=new HashMap<Integer, LinkedList<Integer>>();
	
	
	public void add(int vertex) {
		vertices.put(vertex, new LinkedList<Integer>());
	}
	
	public void addEdge(int source,int destination,boolean bidirectional) {
		if(!vertices.containsKey(source))
			add(source);
		
		if(!vertices.containsKey(destination))
			add(destination);
		
		vertices.get(source).add(destination);
		if(bidirectional)
			vertices.get(destination).add(source);
			
	}
	
	public int getVertexCount() {
		return this.vertices.size();
	}
	
	public int getEdgeCount(boolean bidirectional) {
		int count=0;
		for(Integer i:vertices.keySet()) {
			count+=vertices.get(i).size();
		}
		if(bidirectional)
			count=count/2;
		
		return count;
	}
	
	@Override
	public String toString() {
		StringBuilder builder=new StringBuilder();
		
		for(Integer i:vertices.keySet()) {
			builder.append(i+":' ");
			for(Integer j:vertices.get(i)) {
				builder.append(j+" ");
			}
			builder.append("\n");
		}
		return builder.toString();
	}
	
	public static void main(String[] args) {
		Graph g=new Graph();
		g.addEdge(0, 1, true); 
        g.addEdge(0, 4, true); 
        g.addEdge(1, 2, true); 
        g.addEdge(1, 3, true); 
        g.addEdge(1, 4, true); 
        g.addEdge(2, 3, true); 
        g.addEdge(3, 4, true); 
        
        System.out.println(g);
        System.out.println("Total Vertex "+g.getVertexCount());
        System.out.println("Total Edges "+g.getEdgeCount(true));

	}

}
