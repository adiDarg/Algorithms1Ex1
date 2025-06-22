package TreeCircumfrence;

import java.util.HashMap;
import java.util.Scanner;

public class TreeCreator {
    private Tree tree;
    private int[] childrenPerLayer;
    public TreeCreator(int length) {
        tree = new Tree();
        childrenPerLayer = new int[length];
    }
    public void generateTree(){
        TreeNode root = tree.getRoot();
        generateTree(root,0);
    }
    public Tree getTree(){
        return tree;
    }
    private void generateTree(TreeNode root, int layer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of children for child " + childrenPerLayer[layer] + " of layer " + layer + ": ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            TreeNode child = tree.createNode();
            childrenPerLayer[layer+1]++;
            generateTree(child, layer + 1);
            tree.addEdge(root,child);
        }
    }
}
