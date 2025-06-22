package TreeCircumfrence;

import java.util.LinkedList;
import java.util.Queue;

public class CircumferenceFinder {
    private CircumferenceFinder(){}
    public static int runCircumference(Tree tree){
        TreeNode root = tree.getNodes().get(0);
        root.dx = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode maxDxNode = root;
        while (!queue.isEmpty()){
            TreeNode current = queue.remove();
            current.visited = true;
            if (current.dx > maxDxNode.dx){
                maxDxNode = current;
            }
            for (TreeEdge edge : tree.getEdges(current)){
                if (edge.node1 == current && !edge.node2.visited){
                    edge.node2.dx = current.dx+1;
                    queue.add(edge.node2);
                }
                else if (edge.node2 == current && !edge.node1.visited){
                    edge.node1.dx = current.dx+1;
                    queue.add(edge.node1);
                }
            }
        }
        queue.add(maxDxNode);
        int circumference = 0;
        while (!queue.isEmpty()){
            TreeNode current = queue.remove();
            current.visitedY = true;
            if (current.dy > circumference){
                circumference = current.dy;
            }
            for (TreeEdge edge : tree.getEdges(current)){
                if (edge.node1 == current && !edge.node2.visitedY){
                    edge.node2.dy = current.dy+1;
                    queue.add(edge.node2);
                }
                else if (edge.node2 == current && !edge.node1.visitedY){
                    edge.node1.dy = current.dy+1;
                    queue.add(edge.node1);
                }
            }
        }
        return circumference;
    }
}
