package 二叉树;

import helper.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明：叶子节点是指没有子节点的节点。



示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：2
示例 2：

输入：root = [2,null,3,null,4,null,5,null,6]
输出：5


提示：

树中节点数的范围在 [0, 105] 内
-1000 <= Node.val <= 1000
 */
public class leetcode_111 {
    // 同104 层次遍历
    public int minDepth2(TreeNode root) {
        int ans = 0;
        if (root == null)
            return ans;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            while (size > 0) {
                TreeNode t = queue.poll();
                if (t.left == null && t.right == null)
                    return ans;
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
                size--;
            }
        }
        return ans;
    }


//    -----------------------------------------------------
//    -----------------------------------------------------
    int ans = Integer.MAX_VALUE;
    public int minDepth3(TreeNode root) {
        // 左右子树的min + 1
        if (root == null)
            return 0;
        dfs3(root,0);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    private void dfs3(TreeNode root,int depth) {
        // 从顶往下
//        if (root == null)
        if (root == null || depth > ans)
            return;
        depth++;
        if(root.left == null && root.right == null) {
            ans = Math.min(ans,depth);
        }
        dfs3(root.left,depth);
        dfs3(root.right,depth);
    }


//    -----------------------------------------------------
//    -----------------------------------------------------

    public int minDepth(TreeNode root) {
        // 自底向上  不能直接同104 直接min 需要过滤掉 左右子树包含 0的值
        return dfs(root);
    }


    private int dfs(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null) {
            return dfs(root.right);
        }
        if(root.right == null) {
            return dfs(root.left);
        }
        return Math.min(dfs(root.left),dfs(root.right)) + 1;
    }
}

























