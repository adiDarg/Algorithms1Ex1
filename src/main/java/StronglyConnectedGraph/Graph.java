package StronglyConnectedGraph;

import java.util.*;

public class Graph {
    HashSet<Integer> nodes;
    List<List<Integer>> edges;
    public Graph(){
        nodes = new HashSet<>();
        edges = new ArrayList<>();
    }
    public void addEdge(int source, int target){
        if(nodes.contains(source) && nodes.contains(target)){
            List<Integer> edge = new LinkedList<>();
            edge.add(source);
            edge.add(target);
            edges.add(edge);
        }
    }
    public void addNode(int node){
        nodes.add(node);
    }
}
