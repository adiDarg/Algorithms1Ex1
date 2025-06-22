package StronglyConnectedGraph;

import java.util.*;

public class SCGAlgorithm {
    public static boolean runAlgorithm(Graph graph){
        List<List<Integer>> newEdges = new LinkedList<>();
        for (List<Integer> edge : graph.edges) {
            LinkedList<Integer> newEdge = new LinkedList<>();
            newEdge.add(edge.get(1));
            newEdge.add(edge.get(0));
            newEdges.add(newEdge);
        }
        return run(graph.edges,graph.nodes) && run(newEdges,graph.nodes);
    }
    private static boolean run(List<List<Integer>> edges, HashSet<Integer> nodes) {
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        for (List<Integer> edge : edges) {
            adj.put(edge.get(0), adj.getOrDefault(edge.get(0), new ArrayList<>()));
            adj.get(edge.get(0)).add(edge.get(1));
        }
        int root = edges.get(0).get(0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int node = queue.remove();
            visited.add(node);
            List<Integer> neighbors = adj.getOrDefault(node,new LinkedList<>());
            for (Integer neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
        return visited.size() == nodes.size();
    }
}
