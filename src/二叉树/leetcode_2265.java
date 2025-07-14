package 二叉树;
/*
给你一棵二叉树的根节点 root ，找出并返回满足要求的节点数，要求节点的值等于其 子树 中值的 平均值 。

注意：

n 个元素的平均值可以由 n 个元素 求和 然后再除以 n ，并 向下舍入 到最近的整数。
root 的 子树 由 root 和它的所有后代组成。


示例 1：


输入：root = [4,8,5,0,1,null,6]
输出：5
解释：
对值为 4 的节点：子树的平均值 (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4 。
对值为 5 的节点：子树的平均值 (5 + 6) / 2 = 11 / 2 = 5 。
对值为 0 的节点：子树的平均值 0 / 1 = 0 。
对值为 1 的节点：子树的平均值 1 / 1 = 1 。
对值为 6 的节点：子树的平均值 6 / 1 = 6 。
示例 2：


输入：root = [1]
输出：1
解释：对值为 1 的节点：子树的平均值 1 / 1 = 1。


提示：

树中节点数目在范围 [1, 1000] 内
0 <= Node.val <= 1000
 */

import helper.TreeNode;

// 统计值等于子树平均值的节点数
public class leetcode_2265 {
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    int ans = 0;

    // 可以不用pair 向下传递计数节点
    private Pair dfs(TreeNode cur) {
        if (cur == null)
            return new Pair(0, 0);
        Pair l = dfs(cur.left);
        Pair r = dfs(cur.right);
        if ((l.count + r.count + cur.val) / (l.nodeNum + r.nodeNum + 1) == cur.val) {
            ans++;
        }
        return new Pair(l.nodeNum + r.nodeNum + 1, l.count + r.count + cur.val);
    }

    static class Pair {
        int nodeNum;
        int count;

        public Pair(int nodeNum, int count) {
            this.nodeNum = nodeNum;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "nodeNum=" + nodeNum +
                    ", count=" + count +
                    '}';
        }
    }


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        int cnt = 0;
        int ans = 0;

        public int averageOfSubtree(TreeNode root) {
            dfs(root);
            return ans;
        }

        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 向下传递计数节点递归结束 即到底的计数减去之前传下来的计数 相减就是子树的节点了
            // 记下当前的从顶到当前节点路径上的数目
            int cur = cnt;
            cnt++;
            int l = dfs(root.left);
            int r = dfs(root.right);
            // 递归结束 的cnt - 之前的cur就是子树的个数了
            int sum = l + r + root.val;
            if (root.val == sum / (cnt - cur)) {
                ans++;
            }

            return sum;
        }

    }
}




















