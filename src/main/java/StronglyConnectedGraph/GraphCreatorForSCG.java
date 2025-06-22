package StronglyConnectedGraph;

import java.util.List;
import java.util.Scanner;

public class GraphCreatorForSCG {
    public static Graph createGraph(){
        Graph graph = new Graph();
        Scanner sc = new Scanner(System.in);
        System.out.println("How many nodes?");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            graph.addNode(i);
        }
        int node1 = 0;
        int node2 = 0;
        while (true){
            System.out.println("Creating Edge: Enter source node(nodes are in range 1 -> n of nodes)(enter -1 to exit): ");
            node1 = sc.nextInt();
            if (node1 == -1){
                break;
            }
            System.out.println("Enter target node:");
            node2 = sc.nextInt();
            graph.addEdge(node1, node2);
        }
        return graph;
    }
}
