package 二叉树.二叉搜索树;
/*
给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

差值是一个正数，其数值等于两值之差的绝对值。



示例 1：


输入：root = [4,2,6,1,3]
输出：1
示例 2：


输入：root = [1,0,48,null,null,12,49]
输出：1


提示：

树中节点的数目范围是 [2, 104]
0 <= Node.val <= 105
 */

import helper.TreeNode;

// 二叉搜索树的最小绝对差
public class leetcode_530 {
    public int getMinimumDifference(TreeNode root) {
        max = min = root.val;
        dfs(root);
        return max - min;
    }

    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if(root.right != null) {
            max = root.right.val;
            dfs(root.right);
        }
        if(root.left != null) {
            min = root.left.val;
            dfs(root.left);
        }
    }
}
