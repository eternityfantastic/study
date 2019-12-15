public class day0303 implements 二叉树 {
    //先序创建
    static int i = 0;

    @Override
    public TreeNode CreateTestTree(String s) {
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

    @Override
    public int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getSize(root.left) + getSize(root.right) + 1;
    }

    @Override
    public int getLeafSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize(root.left) + getLeafSize(root.right);
    }

    @Override
    public boolean find(TreeNode root, int val) {
        if (root == null) {
            return false;
        }
        if (root.value == val) {
            return true;
        }
        return find(root.left, val) || find(root.right, val);
    }

    @Override
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null || p != null && q == null || p.value != q.value) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    @Override
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        if (isSameTree(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    @Override
    public void levelOrderTraversal(TreeNode root) {


    }

    @Override
    public boolean isCompleteTree(TreeNode root) {
        return false;
    }

    @Override
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p && root == q) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode != null && rightNode != null) {
            return root;
        }
        if (leftNode != null) {
            return leftNode;
        }
        if (rightNode != null) {
            return rightNode;
        }
        return null;

    }


    public TreeNode prev = null;

    @Override
    public void toLinkedList(TreeNode root) {
        if (root == null) {
            return;
        }
        toLinkedList(root.left);
//            至此左子树完
        root.left = prev;
        if (prev != null) {
            prev.right = root;
        }
        prev = root;
        toLinkedList(root.right);
    }
}

