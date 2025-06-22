package TreeCircumfrence;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Tree {
    private final HashMap<TreeNode, List<TreeEdge>> nodesAndEdges;
    private final TreeNode root;
    public Tree() {
        nodesAndEdges = new HashMap<>();
        root = createNode();
    }
    public TreeNode getRoot() {
        return root;
    }
    public void addEdge(TreeNode node1,TreeNode node2) {
        TreeEdge edge = new TreeEdge(node1,node2);
        List<TreeEdge> edges1 = nodesAndEdges.getOrDefault(node1,new LinkedList<>());
        edges1.add(edge);
        List<TreeEdge> edges2 = nodesAndEdges.getOrDefault(node2,new LinkedList<>());
        edges2.add(edge);
        nodesAndEdges.put(node1, edges1);
        nodesAndEdges.put(node2, edges2);
    }
    public List<TreeEdge> getEdges(TreeNode node){
        return nodesAndEdges.getOrDefault(node,new LinkedList<>());
    }
    public List<TreeEdge> getEdges(){
        List<TreeEdge> edges = new LinkedList<>();
        for (List<TreeEdge> edges1 : nodesAndEdges.values()) {
            edges.addAll(edges1);
        }
        return edges;
    }
    public List<TreeNode> getNodes(){
        return nodesAndEdges.keySet().stream().toList();
    }
    public TreeNode createNode(){
        TreeNode treeNode = new TreeNode();
        nodesAndEdges.put(treeNode,new LinkedList<>());
        return treeNode;
    }
}
