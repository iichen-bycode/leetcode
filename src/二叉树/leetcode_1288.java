package 二叉树;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。



举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。

如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。

如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。



示例 1：



输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
输出：true
示例 2：



输入：root1 = [1,2,3], root2 = [1,3,2]
输出：false


提示：

给定的两棵树结点数在 [1, 200] 范围内
给定的两棵树上的值在 [0, 200] 范围内
 */
public class leetcode_1288 {
    List<Integer> a1 = new ArrayList<>();
    List<Integer> a2 = new ArrayList<>();



    public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        dfs1(root1);
        dfs2(root2);
        if (a1.size() != a2.size())
            return false;
        for (int i = 0; i < a1.size(); i++) {
            if (!a1.get(i).equals(a2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void dfs1(TreeNode root) {
        if (root == null)
            return;
        if(root.left == null && root.right == null) {
            a1.add(root.val);
        }
        dfs1(root.left);
        dfs1(root.right);
//        boolean l = dfs1(root.left);
//        boolean r = dfs1(root.right);
//        if (l && r) {
//            a1.add(root.val);
//        }
//        return false;
    }

    private boolean dfs2(TreeNode root) {
        if (root == null)
            return true;
        boolean l = dfs2(root.left);
        boolean r = dfs2(root.right);
        if (l && r) {
            a2.add(root.val);
        }
        return false;
    }
}
