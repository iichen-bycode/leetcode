package 二叉树;

import helper.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/*
给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。

更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。

给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。

如果第二小的值不存在的话，输出 -1 。



示例 1：


输入：root = [2,2,5,null,null,5,7]
输出：5
解释：最小的值是 2 ，第二小的值是 5 。
示例 2：


输入：root = [2,2,2]
输出：-1
解释：最小的值是 2, 但是不存在第二小的值。


提示：

树中节点数目在范围 [1, 25] 内
1 <= Node.val <= 231 - 1
对于树中每个节点 root.val == min(root.left.val, root.right.val)
 */
public class leetcode_671 {
    int ans = -1;
    public int findSecondMinimumValue(TreeNode root) {
        // 翻译为递归
        dfs(root,root.val);
        return ans;
    }

    private void dfs(TreeNode root,int top) {
        if(root == null)
            return;
        if(root.val != top) {
            if(ans == -1)
                ans = root.val;
            else
                ans = Math.min(ans,root.val);
        }
        dfs(root.left,top);
        dfs(root.right,top);
    }

    public int findSecondMinimumValue2(TreeNode root) {
        /*
               a :

                    a a+1

                    a a

         */
        Queue<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        int top = root.val;
        long secondMin = Long.MAX_VALUE;
        while (!stack.isEmpty()) {
            TreeNode t = stack.poll();
            if(t.val != top) {
                secondMin = Math.min(secondMin, t.val);
            }
            TreeNode l = t.left;
            TreeNode r = t.right;
            if (l != null) {
                stack.offer(l);
                stack.offer(r);
            }
        }
        return secondMin == Long.MAX_VALUE ? -1 : (int) secondMin;
    }
}
