public class BinTree {
    TreeNode CreateTestTree(String s) {
        int i = 0;
        TreeNode root = null;
        if (s.charAt(i) != '#') {
            root = new TreeNode(s.charAt(i));
            i++;
            root.left = CreateTestTree(s);
            root.right = CreateTestTree(s);
        } else {
            i++;
        }
        return root;
    }
    public void BinaryTreePrevOrder(TreeNode root) {
        if(root == null){
            return ;
        }
        System.out.print(root.value+" ");
        BinaryTreePrevOrder(root.left);
        BinaryTreePrevOrder(root.right);
    }
    public void BinaryTreeinOrder(TreeNode root){
        if(root == null){
            return ;
        }
        BinaryTreePrevOrder(root.left);
        System.out.println(root.value);
        BinaryTreePrevOrder(root.right);
    }

    public void toLinkedList(TreeNode root ){
        if(root == null){
            return ;
        }
        toLinkedList(root.left);
        TreeNode prve = null;
        root.left = prve;
        if(prve != null){
            prve.right = root;
        }
    }

}

class TreeNode {
    char value;
    TreeNode left;
    TreeNode right;

    public TreeNode(char value) {
        this.value = value;
    }
}
