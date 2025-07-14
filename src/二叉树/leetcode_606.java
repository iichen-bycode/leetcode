package 二叉树;
/*
给你二叉树的根节点 root ，请你采用前序遍历的方式，将二叉树转化为一个由括号和整数组成的字符串，返回构造出的字符串。

空节点使用一对空括号对 "()" 表示，转化后需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。



示例 1：


输入：root = [1,2,3,4]
输出："1(2(4))(3)"
解释：初步转化后得到 "1(2(4)())(3()())" ，但省略所有不必要的空括号对后，字符串应该是"1(2(4))(3)" 。
示例 2：


输入：root = [1,2,3,null,4]
输出："1(2()(4))(3)"
解释：和第一个示例类似，但是无法省略第一个空括号对，否则会破坏输入与输出一一映射的关系。


提示：

树中节点的数目范围是 [1, 104]
-1000 <= Node.val <= 1000
 */

import helper.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

// 根据二叉树创建字符串
public class leetcode_606 {
    StringBuilder sb = new StringBuilder();

    public String tree2str(TreeNode root) {
        dfs(root);
        return sb.toString();
    }

    private void dfs(TreeNode root) {
        /*
            叶子返回 ”“
            左空 不可以省略
            右空 可以省略
         */
        if (root == null)
            return;
        sb.append(root.val);
        // 叶子节点不添加 括号
        if (root.left == null && root.right == null)
            return;
        // 左节点不管空不空都要添加括号
        sb.append("(");
        dfs(root.left);
        sb.append(")");
        // 右节点只要不空才添加括号
        if (root.right != null) {
            sb.append("(");
            dfs(root.right);
            sb.append(")");
        }
    }


    public String tree2str2(TreeNode root) {
        StringBuffer ans = new StringBuffer();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        Set<TreeNode> visited = new HashSet<TreeNode>();
        while (!stack.isEmpty()) {
            // peek处理前置   pop处理结尾
            TreeNode node = stack.peek();
            // 表示当前节点已经处理完成 添加末尾结束 )
            if (!visited.add(node)) {
                if (node != root) {
                    ans.append(")");
                }
                stack.pop();
            } else {
                if (node != root) {
                    ans.append("(");
                }
                ans.append(node.val);
                if (node.left == null && node.right != null) {
                    ans.append("()");
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return ans.toString();
    }
}
