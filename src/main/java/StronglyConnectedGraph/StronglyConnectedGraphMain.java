package StronglyConnectedGraph;

public class StronglyConnectedGraphMain {
    public static void main(String[] args) {
        Graph g = GraphCreatorForSCG.createGraph();
        boolean result = SCGAlgorithm.runAlgorithm(g);
        System.out.println(result? "Graph is well connected":"Graph is NOT well connected");
    }
}
