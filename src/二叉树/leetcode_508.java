package 二叉树;

/*
给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。

一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。



示例 1：



输入: root = [5,2,-3]
输出: [2,-3,4]
示例 2：



输入: root = [5,2,-5]
输出: [2]


提示:

节点数在 [1, 104] 范围内
-10^5 <= Node.val <= 10^5
 */

import helper.TreeNode;

import java.util.*;


// 出现次数最多的子树元素和
public class leetcode_508 {
    public static void main(String[] args) {


    }

    HashMap<Integer, Integer> map = new HashMap<>();
    int count = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        /*
            左子树值 + 右子树值 + 当前节点
         */
        dfs(root);
        int[] ans = new int[105];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == count) {
                ans[index++] = entry.getKey();
            }
        }
        return Arrays.copyOf(ans,index);
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int res = dfs(root.left) + dfs(root.right) + root.val;
        count = Math.max(count, map.getOrDefault(res, 0) + 1);
        map.merge(res, 1, Integer::sum);
        return res;
    }
}
