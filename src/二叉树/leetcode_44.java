package 二叉树;

import helper.TreeNode;

import java.util.HashSet;
import java.util.Stack;

/*
「力扣挑战赛」开幕式开始了，空中绽放了一颗二叉树形的巨型焰火。 给定一棵二叉树 root 代表焰火，节点值表示巨型焰火这一位置的颜色种类。请帮小扣计算巨型焰火有多少种不同的颜色。

示例 1：

输入：root = [1,3,2,1,null,2]
    1
  3     2
 1    2

输出：3

解释：焰火中有 3 个不同的颜色，值分别为 1、2、3

示例 2：

输入：root = [3,3,3]

输出：1

解释：焰火中仅出现 1 个颜色，值为 3

提示：

1 <= 节点个数 <= 1000
1 <= Node.val <= 1000
 */
public class leetcode_44 {
    public int numColor2(TreeNode root) {
        // 可以把hashset换成 数组 因为题目大小只要 1000个元素
        HashSet<Integer> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            set.add(t.val);
            if(t.left != null) {
                stack.push(t.left);
            }
            if(t.right != null) {
                stack.push(t.right);
            }
        }
        return set.size();
    }


    public int numColor(TreeNode root) {
        HashSet<Integer> set = new HashSet<>();
        dfs(root,set);
        return set.size();
    }

    private void dfs(TreeNode root, HashSet<Integer> set) {
        if(root == null) {
            return;
        }
        set.add(root.val);
        dfs(root.left,set);
        dfs(root.right,set);
    }
}
