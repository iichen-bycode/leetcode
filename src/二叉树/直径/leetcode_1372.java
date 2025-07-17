package 二叉树.直径;
/*
给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：

选择二叉树中 任意 节点和一个方向（左或者右）。
如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
改变前进方向：左变右或者右变左。
重复第二步和第三步，直到你在树中无法继续移动。
交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。

请你返回给定树中最长 交错路径 的长度。



示例 1：



输入：root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
输出：3
解释：蓝色节点为树中最长交错路径（右 -> 左 -> 右）。
示例 2：



输入：root = [1,1,1,null,1,null,null,1,1,null,1]
输出：4
解释：蓝色节点为树中最长交错路径（左 -> 右 -> 左 -> 右）。
示例 3：

输入：root = [1]
输出：0


提示：

每棵树最多有 50000 个节点。
每个节点的值在 [1, 100] 之间。
 */

import helper.TreeNode;

// 二叉树中的最长交错路径
public class leetcode_1372 {
    public int longestZigZag(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return 0;
        // 当前节点的 分别 往左或右
        dfs(root, false, 0);
        dfs(root, true, 0);
        return ans;
    }

    // 关键是：之前是往右 下一次也要考虑往右 把次数改为1即可。
    private void dfs(TreeNode root, boolean isR, int count) {
        if (root == null)
            return;
        ans = Math.max(ans, count);
        count++;
        if (isR) {
            if (root.left != null) {
                dfs(root.left, false, count);
            }
            if (root.right != null) {
                dfs(root.right, true, 1);
            }
        } else {
            if (root.left != null) {
                dfs(root.left, false, 1);
            }
            if (root.right != null) {
                dfs(root.right, true, count);
            }
        }
    }

    int ans = 0;
}






