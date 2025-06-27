package 二叉树;

import helper.NodeBuilder;
import helper.TreeBuilder;
import helper.TreeNode;
import helper.Utils;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
给你二叉树的根节点 root ，返回它节点值的 前序 遍历。



示例 1：

输入：root = [1,null,2,3]

输出：[1,2,3]

解释：



示例 2：

输入：root = [1,2,3,4,5,null,8,null,null,6,7,9]

输出：[1,2,4,5,6,7,3,8,9]

解释：



示例 3：

输入：root = []

输出：[]

示例 4：

输入：root = [1]

输出：[1]



提示：

树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100


进阶：递归算法很简单，你可以通过迭代算法完成吗？
 */
public class leetcode_144 {
    public static void main(String[] args) {
        // 1,null,2,3
        // 1,2,3,4,5,null,8,null,null,6,7,9
        List a = preorderTraversal(new TreeBuilder().build(new int[]{1, -1, 2, -1, -1, 3, 4}, -1));
        Utils.printList(a);
    }

    public static List<Integer> ans = new ArrayList<>();

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
//        dfs(root);
        if (root == null)
            return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return ans;
    }

    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
