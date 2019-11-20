public interface BinaryTree {


    // 根据字符串创建二叉树先序遍历

    TreeNode CreateTestTree(String s);

    // 前序遍历NLR

    void BinaryTreePrevOrder(TreeNode root);

    // 中序遍历LNR

    void BinaryTreeInOrder(TreeNode root);

    // 后序遍历LNR

    void BinaryTreeFinvOrder(TreeNode root);


    // 节点个数

    int getsize(TreeNode root);

    //叶子节点数

    int getLeafsize(TreeNode root);

    //第K层的节点数

    int getKLevelSize(TreeNode root, int k);

    // 查找依次在二叉树的根、左子树，右子树中查找Valuer如果找到返回节点否则返回null

    TreeNode find(TreeNode root, char value);
}
