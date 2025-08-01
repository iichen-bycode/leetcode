package 二叉树.二叉搜索树;

/*
给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。



示例 1：


输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
输出：32
示例 2：


输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
输出：23


提示：

树中节点数目在范围 [1, 2 * 104] 内
1 <= Node.val <= 105
1 <= low <= high <= 105
所有 Node.val 互不相同
 */

import helper.TreeNode;

// 二叉搜索树的范围和
public class leetcode_938 {
    int ans = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return ans;
    }

    private void dfs(TreeNode root, int low, int high) {
        if (root == null)
            return;
        if (root.val > high) {
            dfs(root.left,low,high);
        } else if(root.val < low) {
            dfs(root.right,low,high);
        } else {
            ans += root.val;
            dfs(root.left,low,high);
            dfs(root.right,low,high);
        }
    }
}
















