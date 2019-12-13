public interface 二叉树循环遍历 {
    class TreeNode {
        char value;
        二叉树递归遍历.TreeNode left;
        二叉树递归遍历.TreeNode right;

        public TreeNode(char value) {
            this.value = value;
        }
    }

    // 前序遍历NLR

    void BinaryTreePrevOrder(二叉树递归遍历.TreeNode root);

    // 中序遍历LNR

    void BinaryTreeInOrder(二叉树递归遍历.TreeNode root);

    // 后序遍历LNR

    void BinaryTreeFinvOrder(二叉树递归遍历.TreeNode root);

}
