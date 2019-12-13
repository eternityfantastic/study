public interface 二叉树递归遍历 {
    class TreeNode {
        char value;
        TreeNode left;
        TreeNode right;

        public TreeNode(char value) {
            this.value = value;
        }
    }

    // 前序遍历NLR

    void BinaryTreePrevOrder(TreeNode root);

    // 中序遍历LNR

    void BinaryTreeInOrder(TreeNode root);

    // 后序遍历LNR

    void BinaryTreeFinvOrder(TreeNode root);

}
