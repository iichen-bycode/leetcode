package 常用数据结构.前缀和;

import helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。

路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。



示例 1：



输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
输出：3
解释：和等于 8 的路径有 3 条，如图所示。
示例 2：

输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：3


提示:

二叉树的节点个数的范围是 [0,1000]
-109 <= Node.val <= 109
-1000 <= targetSum <= 1000
 */

// 路径总和 III
public class leetcode_437 {
    /*
        10 5 3 3
        10 5 3 -2
        10 5 2 1
        10 -3 11

        10 15 18 21
        10 15 18 16
        10 15 17 18
        10 7 18
     */
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        dfs(root, 0, targetSum, map);
        return ans;
    }

    // 类同 560 1
    private void dfs(TreeNode root, long sum, int targetSum, Map<Long, Integer> map) {
        if (root == null)
            return;
        sum += root.val;
        ans += map.getOrDefault(sum - targetSum, 0);
        map.merge(sum, 1, Integer::sum);
        dfs(root.left, sum, targetSum, map);
        dfs(root.right, sum, targetSum, map);
        map.merge(sum, -1, Integer::sum);
    }
}
