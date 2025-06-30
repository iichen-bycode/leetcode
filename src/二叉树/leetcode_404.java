package 二叉树;

import helper.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
给定二叉树的根节点 root ，返回所有左叶子之和。



示例 1：



输入: root = [3,9,20,null,null,15,7]
输出: 24
解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
示例 2:

输入: root = [1]
输出: 0


提示:

节点数在 [1, 1000] 范围内
-1000 <= Node.val <= 1000

 */
public class leetcode_404 {

    public int sumOfLeftLeaves(TreeNode root) {
        int ans = 0;
        if(root == null) {
            return ans;
        }
        // Deque换成Queue就是广度
        Deque<TreeNode> stack = new ArrayDeque<>();
        // 模拟递归
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            if(p.left != null) {
                if(p.left.left == null && p.left.right == null) {
                    ans += p.left.val;
                } else {
                    stack.push(p.left);
                }
            }

            if (p.right != null && !(p.right.left == null && p.right.right == null)) {
                stack.push(p.right);
            }
        }
        return ans;
    }



    public int sumOfLeftLeaves3(TreeNode root) {
        return dfs3(root,false);
    }
    private int dfs3(TreeNode root, boolean b) {
        if(root == null)
            return 0;
        return dfs3(root.left,false) + dfs3(root.right,true) + (root.left != null && root.left.left == null && root.left.right == null ? root.val : 0);
    }



    public int sumOfLeftLeaves2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return dfs(root);
    }
    private int dfs(TreeNode root) {
        int ans = 0;
        if(root.left != null) {
            ans += root.left.left == null && root.left.right == null ? root.left.val : dfs(root.left);;
        }

        // 加上右子树的总数
        if(root.right != null && !(root.right.left == null && root.right.right == null)) {
            ans += dfs(root.right);
        }
        return ans;
    }
}
