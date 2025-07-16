package 二叉树.直径;

import helper.TreeNode;
/*
给你一棵二叉树的根节点，返回该树的 直径 。

二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。

两节点之间路径的 长度 由它们之间边数表示。



示例 1：


输入：root = [1,2,3,4,5]
输出：3
解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
示例 2：

输入：root = [1,2]
输出：1


提示：

树中节点数目在范围 [1, 104] 内
-100 <= Node.val <= 100
 */

// 二叉树的直径
public class leetcode_543 {
    public int diameterOfBinaryTree(TreeNode root) {
        /*
                 1
              2     3
            4   5
         */
        dfs(root);
        return ans;
    }
    int ans = 0;
    private int dfs(TreeNode root) {
        if(root == null)
            return -1;
        // 返回-1 则叶子节点就是 真链长为0
        int l = dfs(root.left) + 1;
        int r = dfs(root.right) + 1;
        ans = Math.max(ans,l + r);
        // 返回最长链
        return Math.max(l,r);
    }
    private int dfs2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int now = left + right;
        ans = Math.max(ans, now);
        return 1 + Math.max(left, right);
    }
}















