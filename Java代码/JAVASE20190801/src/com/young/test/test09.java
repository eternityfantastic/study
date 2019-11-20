package com.young.test;

import javax.xml.soap.Node;

//import java.net.Authenticator.RequestorType;

public class test09 {
	class TreeNode {
		char value;
		TreeNode left;
		TreeNode right;

		public TreeNode(char value) {
			this.value = value;
		}
	}

	// 根据字符串创建二叉树先序遍历
	public int i = 0;

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

	// 前序遍历NLR
	void BinaryTreePrevOrder(TreeNode root) {
		// 判断root是否为空
		if (root == null) {
			return;

		} else {
			System.out.println(root.value + " ");
			// 递归
			BinaryTreePrevOrder(root.left);
			BinaryTreePrevOrder(root.right);

		}
	}

	// 中序遍历LNR
	void BinaryTreeInOrder(TreeNode root) {
		if (root == null) {
			return;
		} else {
			BinaryTreePrevOrder(root.left);
			System.out.println(root.value + " ");
			BinaryTreePrevOrder(root.right);
		}
	}

	// 后序遍历LNR
	void BinaryTreeFinvOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		BinaryTreePrevOrder(root.left);
		BinaryTreePrevOrder(root.right);
		System.out.println(root.value + " ");
	}

	// 节点个数
	int getsize(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return getsize(root.left) + getsize(root.right) + 1;// 后序遍历
	}
	//叶子节点数
	int getLeafsize(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		return getsize(root.left) + getsize(root.right);// 后序遍历
	}
	//第K层的节点数
	int getKLevelSize(TreeNode root,int k)
	{
		if (root==null) {
			return 0;
		}else if (k==1) {
			return 1;
		}
		return getKLevelSize(root.left, k-1)+getKLevelSize(root.right, k-1);
	}
	// 查找依次在二叉树的根、左子树，右子树中查找Valuer如果找到返回节点否则返回Null
	TreeNode find(TreeNode root,char value)
	{
		if (root==null) {
			return null;
		}
		if (root.value==value) {
			return root;
		}
		TreeNode ret=find(root.left, value);
		if (ret==null) {//左子树中没找到
			ret=find(root.right, value);
		} else {
			return ret;
		}
		if (ret==null) {
			return null;
		}else {
			return ret;
		}		 
	}
	TreeNode find2(TreeNode root,char value)
	{
		if (root==null) {
			return null;
		}
		if (root.value==value) {
			return root;
		}
		TreeNode ret = find(root.left, value);//至此左子树遍历完
		if (ret!=null) {
			return ret;
		}else {
			ret = find(root.right, value);
			if (ret!=null) {
				return ret;
			}
		}
		return null;
	}
	public static void main(String[] args) {

	}
}
