package TreeCircumfrence;

import java.util.Scanner;

public class MainTreeEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input length of tree:");
        TreeCreator tc = new TreeCreator(sc.nextInt());
        tc.generateTree();
        System.out.println("Circumference of tree is: " + CircumferenceFinder.runCircumference(tc.getTree()));
    }
}
