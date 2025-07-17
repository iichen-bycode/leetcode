package 二叉树.直径;

/*
二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。

路径和 是路径中各节点值的总和。

给你一个二叉树的根节点 root ，返回其 最大路径和 。



示例 1：


输入：root = [1,2,3]
输出：6
解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
示例 2：


输入：root = [-10,9,20,null,null,15,7]
输出：42
解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42


提示：

树中节点数目范围是 [1, 3 * 104]
-1000 <= Node.val <= 1000
 */

import helper.TreeNode;

// 二叉树中的最大路径和
public class leetcode_124 {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    /*
        -2              2
            -3       -3    4
     */
    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        l = Math.max(l, 0);
        r = Math.max(r, 0);
        int t = l + r + root.val;
        // 答案 是当前节点和左右子树的最大 注意与下面返回的区别
        ans = Math.max(ans, t);
        // 返回当前节点的最大
        return Math.max(l,r) + root.val;
    }
}
