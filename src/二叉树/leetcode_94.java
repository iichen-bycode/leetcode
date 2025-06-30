package 二叉树;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。



示例 1：


输入：root = [1,null,2,3]
输出：[1,3,2]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [1]
输出：[1]


提示：

树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100


进阶: 递归算法很简单，你可以通过迭代算法完成吗？

https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
 */
public class leetcode_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 不停的取左子树直到为null 回退后 需要再入栈右子树
        if (root == null)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 记录当前的结果 节点后 需要入栈右子树
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            // 当前已经到达左子树为空的 最左边的节点
            TreeNode t = stack.pop();
            // 打印当前节点
            ans.add(t.val);
            // 把当前的节点右子树入栈 即 中序遍历的顺序了
            if (t.right != null) {
                cur = t.right;
            }
        }
        return ans;
    }

    public List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal2(TreeNode root) {
        // 递归
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }
}
