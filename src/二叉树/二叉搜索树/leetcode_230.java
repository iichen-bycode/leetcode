package 二叉树.二叉搜索树;

/*
给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。



示例 1：


输入：root = [3,1,4,null,2], k = 1
输出：1
示例 2：


输入：root = [5,3,6,2,4,null,null,1], k = 3
输出：3




提示：

树中的节点数为 n 。
1 <= k <= n <= 104
0 <= Node.val <= 104


进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 */

import helper.TreeNode;

// 二叉搜索树中第 K 小的元素
public class leetcode_230 {
    int ans = 0;
    int num = 0;
    public int kthSmallest(TreeNode root, int k) {
        num = k;
        dfs(root,k);
        return ans;
    }

    private void dfs(TreeNode root, int k) {
        if(root == null)
            return;
        dfs(root.left,k);
        num--;
        if(num == 0) {
            ans = root.val;
            return;
        }
        dfs(root.right,k);
    }
}


















