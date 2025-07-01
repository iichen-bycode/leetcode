package 二叉树;

/*
如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。

只有给定的树是单值二叉树时，才返回 true；否则返回 false。



示例 1：



输入：[1,1,1,1,1,null,1]
输出：true
示例 2：



输入：[2,2,2,5,2]
输出：false


提示：

给定树的节点数范围是 [1, 100]。
每个节点的值都是整数，范围为 [0, 99] 。
 */


import helper.TreeNode;

// 单值二叉树
public class leetcode_965 {
    boolean ans = true;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return false;
        dfs(root, root.val);
        return ans;
    }

    public boolean isUnivalTree2(TreeNode root) {
        if (root == null)
            return false;
        return dfs2(root, root.val);
    }

    private boolean dfs2(TreeNode root, int num) {
        if(root == null) {
            return true;
        }
        return root.val == num && dfs2(root.left,num) && dfs2(root.right,num);
    }
    private void dfs(TreeNode root, int num) {
        if (root == null)
            return;
        if (root.val != num)
            ans = false;
        dfs(root.left, num);
        dfs(root.right, num);
    }
}
