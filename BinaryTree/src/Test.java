public class Test {
    public static void main(String[] args) {
        Test01 t = new Test01();
        TreeNode treeNode = t.CreateTestTree("ABC##DE#G##F###");
        t.BinaryTreePrevOrder(treeNode);
        System.out.println();
        t.BinaryTreeInOrder(treeNode);
    }
}
