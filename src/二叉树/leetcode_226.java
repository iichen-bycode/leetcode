package 二叉树;
/*
给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。



示例 1：



输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
示例 2：



输入：root = [2,1,3]
输出：[2,3,1]
示例 3：

输入：root = []
输出：[]


提示：

树中节点数目范围在 [0, 100] 内
-100 <= Node.val <= 100
 */

import helper.TreeNode;

// 翻转二叉树
public class leetcode_226 {
    public TreeNode invertTree2(TreeNode root) {
        // 左右节点交换
        if (root == null)
            return null;
        // 自顶向下
        dfs2(root);
        return root;
    }

    private void dfs2(TreeNode root) {
        if (root == null)
            return;
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        dfs2(root.left);
        dfs2(root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        // 左右节点交换
        // 自底向上
        if (root == null)
            return null;
        return dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null)
            return null;
        TreeNode l = dfs(root.left);
        root.left = dfs(root.right);
        root.right = l;
        return root;
    }
}
