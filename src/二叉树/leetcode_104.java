package 二叉树;

import helper.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/*
给定一个二叉树 root ，返回其最大深度。

二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。



示例 1：





输入：root = [3,9,20,null,null,15,7]
输出：3
示例 2：

输入：root = [1,null,2]
输出：2


提示：

树中节点的数量在 [0, 104] 区间内。
-100 <= Node.val <= 100
 */
public class leetcode_104 {
    int ans = 0;
    public int maxDepth(TreeNode root) {
        // 自顶向下 同层次遍历 需要记录当前层的 层级
        if(root == null)
            return ans;
        dfs(root,0);
        return ans;
    }
    public void dfs(TreeNode root,int depth) {
        if(root == null)
            return;
        // 当前层级++
        depth++;
        ans = Math.max(ans,depth);
        dfs(root.left,depth);
        dfs(root.right,depth);
    }


    public int maxDepth2(TreeNode root) {
        // 等于当前节点的深度等于 max(l,r) + 1
        if (root == null)
            return 0;
        return dfs2(root);
    }

    private int dfs2(TreeNode root) {
        //自底向上
        if (root == null)
            return 0;
        return Math.max(dfs2(root.left), dfs2(root.right)) + 1;
    }

    public int maxDepth3(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        int ans = 0;
        queue.offer(root);
        // 层次遍历 每一次 poll每一层后 +1
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            while (size > 0) {
                TreeNode t = queue.poll();
                if(t.left != null) {
                    queue.offer(t.left);
                }
                if(t.right != null) {
                    queue.offer(t.right);
                }
                size--;
            }
        }
        return ans;
    }
}

























