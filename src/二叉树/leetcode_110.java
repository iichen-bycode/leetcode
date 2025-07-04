package 二叉树;

/*
给定一个二叉树，判断它是否是 平衡二叉树



示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：true
示例 2：


输入：root = [1,2,2,3,3,null,null,4,4]
输出：false
示例 3：

输入：root = []
输出：true


提示：

树中的节点数在范围 [0, 5000] 内
-104 <= Node.val <= 104
 */

import helper.TreeNode;

// 平衡二叉树
public class leetcode_110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        dfs(root);
        return ans;
    }

    boolean ans = true;

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        // 自底向上
        // 左右都处理及结束 再处理当前的结果
        int l = dfs(root.left);
        int r = dfs(root.right);
        // 处理结果
        if(Math.abs(l - r) > 1) {
            ans = false;
        }
        return Math.max(l, r) + 1;
    }
}
