package 二叉树.直径;
/*
给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。

叶子节点 是指没有子节点的节点。


示例 1：


输入：root = [1,2,3,null,5]
输出：["1->2->5","1->3"]
示例 2：

输入：root = [1]
输出：["1"]


提示：

树中节点的数目在范围 [1, 100] 内
-100 <= Node.val <= 100
 */

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 二叉树的所有路径
public class leetcode_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return ans;
    }

    // 自顶向下
    private void dfs(TreeNode root, String path) {
        if (root == null) {
            return;
        }
        path += root.val;
        if(root.left == null && root.right == null) {
            ans.add(path);
            return;
        }
        path += "->";
        dfs(root.left,path);
        dfs(root.right,path);
    }

    // 回溯
    private void dfs2(TreeNode root, StringBuffer sb) {
        if (root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            ans.add(sb.toString());
        }
        String s = sb.isEmpty() ? String.valueOf(root.val) : "->" + root.val;
        sb.append(s);
        dfs2(root.left, sb);
        dfs2(root.right, sb);
        sb.delete(sb.length() - s.length(), sb.length());
    }

    List<String> ans = new ArrayList<>();
}




















