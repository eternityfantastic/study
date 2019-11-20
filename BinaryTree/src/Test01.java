public class Test01 implements BinaryTree {
    @Override
    public TreeNode CreateTestTree(String s) {

        TreeNode root = null;
        if (s.length() > 0) {

            char ch = s.charAt(0);
            if (ch != '#') {
                root = new TreeNode(ch);

                root.left = CreateTestTree(s.substring(1));
                root.right = CreateTestTree(s.substring(1));

            } else {
                root = CreateTestTree(s.substring(1));
            }
        }

        return root;
    }


    @Override
    public void BinaryTreePrevOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value);
        BinaryTreePrevOrder(root.left);
        BinaryTreePrevOrder(root.right);

    }

    @Override
    public void BinaryTreeInOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        BinaryTreePrevOrder(root.left);
        System.out.print(root.value);
        BinaryTreePrevOrder(root.right);


    }

    @Override
    public void BinaryTreeFinvOrder(TreeNode root) {

    }

    @Override
    public int getsize(TreeNode root) {
        return 0;
    }

    @Override
    public int getLeafsize(TreeNode root) {
        return 0;
    }

    @Override
    public int getKLevelSize(TreeNode root, int k) {
        return 0;
    }

    @Override
    public TreeNode find(TreeNode root, char value) {
        if (root == null) {
            return null;
        }
        if (root.value == value) {
            return root;
        }
        TreeNode ret = find(root.left, value);
        if (ret != null) {
            return ret;
        } else {
            return find(root.right, value);
        }
    }
}
