package TreeCircumfrence;

public class MainTreeEx {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator(10);
        tc.generateTree();
        System.out.println("Circumference of tree is: " + CircumferenceFinder.runCircumference(tc.getTree()));
    }
}
