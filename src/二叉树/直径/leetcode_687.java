package 二叉树.直径;
/*
给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。

两个节点之间的路径长度 由它们之间的边数表示。



示例 1:



输入：root = [5,4,5,1,1,5]
输出：2
示例 2:



输入：root = [1,4,5,4,4,5]
输出：2


提示:

树的节点数的范围是 [0, 104]
-1000 <= Node.val <= 1000
树的深度将不超过 1000
 */

import helper.TreeNode;

//最长同值路径
public class leetcode_687 {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        /*
            左子树+ 右子树 且 当前值与左右子树值相同 否则为0
         */
        dfs(root);
        return ans;
    }

    int ans = 0;

    // 相对于543 额外需要判断当前节点值 与 子树的值是否相同 不同的话则 当前节点的 链长 需要为0
    private int dfs(TreeNode root) {
        if (root == null)
            return -1;
        int l = dfs(root.left) + 1;
        int r = dfs(root.right) + 1;
        if(root.left != null && root.left.val != root.val)
            l = 0;
        if(root.right != null && root.right.val != root.val)
            r = 0;
        ans = Math.max(ans, l + r);
        return Math.max(l, r);
    }
}
















