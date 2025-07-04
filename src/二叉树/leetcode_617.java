package 二叉树;
/*
给你两棵二叉树： root1 和 root2 。

想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。

返回合并后的二叉树。

注意: 合并过程必须从两个树的根节点开始。



示例 1：


输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
输出：[3,4,5,5,4,null,7]
示例 2：

输入：root1 = [1], root2 = [1,2]
输出：[2,2]


提示：

两棵树中的节点数目在范围 [0, 2000] 内
-104 <= Node.val <= 104
 */

import helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 合并二叉树
public class leetcode_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == root2)
            return null;
        return dfs(root1, root2);
    }

    private TreeNode dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return root1 == null ? root2 : root1;
        root1.val += root2.val;
        root1.left = dfs(root1.left, root2.left);
        root1.right = dfs(root1.right, root2.right);
        return root1;
    }

    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == root2)
            return null;
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            p.val += q.val;
            if (p.left != null && q.left != null) {
                queue.offer(p.left);
                queue.offer(p.left);
            } else if (p.left == null) {// 挂靠右树 的节点即可
                p.left = q.left;
            }

            if (p.right != null && q.right != null) {
                queue.offer(p.right);
                queue.offer(p.right);
            } else if (p.right == null) {
                p.right = q.right;
            }
        }
        return root1;
    }


}
