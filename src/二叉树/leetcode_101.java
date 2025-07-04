package 二叉树;

/*
给你一个二叉树的根节点 root ， 检查它是否轴对称。



示例 1：


输入：root = [1,2,2,3,4,4,3]
输出：true
示例 2：


输入：root = [1,2,2,null,3,null,3]
输出：false


提示：

树中节点数目在范围 [1, 1000] 内
-100 <= Node.val <= 100


进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 */

import helper.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

// 对称二叉树  使用 100
public class leetcode_101 {
    public boolean isSymmetric(TreeNode root) {
        // 迭代实现  Queue和Stack都行
        Deque<TreeNode> pStack = new LinkedList<>();
        Deque<TreeNode> qStack = new LinkedList<>();
        pStack.push(root.left);
        qStack.push(root.right);
        while (!pStack.isEmpty() && !qStack.isEmpty()) {
            TreeNode p = pStack.pop();
            TreeNode q = qStack.pop();
            if (p == null || q == null) {
                if(p != q) {
                    return false;
                }
            } else {
                if(p.val != q.val) {
                    return false;
                }
                pStack.push(p.left);
                pStack.push(p.right);
                qStack.push(q.right);
                qStack.push(q.left);
            }
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        /*
                 1
           2            2
       3       4    4       3

            p.left == q.right
         */
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null)
            return false;
        else if (q == null) {
            return false;
        }
        return p.val == q.val && dfs(p.left, q.right) && dfs(p.right, q.left);
    }
}
