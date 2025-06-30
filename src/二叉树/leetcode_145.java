package 二叉树;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。



示例 1：

输入：root = [1,null,2,3]

输出：[3,2,1]

解释：



示例 2：

输入：root = [1,2,3,4,5,null,8,null,null,6,7,9]

输出：[4,6,7,5,2,9,8,3,1]

解释：



示例 3：

输入：root = []

输出：[]

示例 4：

输入：root = [1]

输出：[1]



提示：

树中节点的数目在范围 [0, 100] 内
-100 <= Node.val <= 100


进阶：递归算法很简单，你可以通过迭代算法完成吗？
 */
public class leetcode_145 {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal2(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if(root == null)
            return;
        dfs(root.left);
        dfs(root.right);
        ans.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        // 按照上诉的迭代翻译  先加入左子树 再加入右子树 最后处理结果
        if(root == null)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode last = root;
        while (!stack.isEmpty()) {
            // 最后才处理当前节点所以 先peel
            TreeNode t = stack.peek();
            // 塞入左子树  关键是处理当前节点时 不能重复处理左右子树 所以需要一个临时节点记录上一个处理节点是哪个
            // last = 当前处理节点的左节点 则去处理当前节点的右子树
            // last = 当前处理节点的右节点 则当前节点的左右子树都好了 那么就可以处理当前节点了 last更新
            if(t.left != null && t.left != last && t.right != last) {
                stack.push(t.left);
            }
            // 塞入右子树
            else if(t.right != null && t.right != last) {
                stack.push(t.right);
            }
            // 处理结果
            else {
                ans.add(stack.pop().val);
                last = t;
            }
        }
        return ans;
    }

}
