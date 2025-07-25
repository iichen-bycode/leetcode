package 二叉树.最近公共祖先;
/*
给你一棵 二叉树 的根节点 root ，这棵二叉树总共有 n 个节点。每个节点的值为 1 到 n 中的一个整数，且互不相同。给你一个整数 startValue ，表示起点节点 s 的值，和另一个不同的整数 destValue ，表示终点节点 t 的值。

请找到从节点 s 到节点 t 的 最短路径 ，并以字符串的形式返回每一步的方向。每一步用 大写 字母 'L' ，'R' 和 'U' 分别表示一种方向：

'L' 表示从一个节点前往它的 左孩子 节点。
'R' 表示从一个节点前往它的 右孩子 节点。
'U' 表示从一个节点前往它的 父 节点。
请你返回从 s 到 t 最短路径 每一步的方向。



示例 1：



输入：root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
输出："UURL"
解释：最短路径为：3 → 1 → 5 → 2 → 6 。
示例 2：



输入：root = [2,1], startValue = 2, destValue = 1
输出："L"
解释：最短路径为：2 → 1 。


提示：

树中节点数目为 n 。
2 <= n <= 105
1 <= Node.val <= n
树中所有节点的值 互不相同 。
1 <= startValue, destValue <= n
startValue != destValue
 */

import helper.TreeNode;
import helper.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 从二叉树一个节点到另一个节点每一步的方向
public class leetcode_2096 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2, null, new TreeNode(4));
        TreeNode r = new TreeNode(3);
        root.left = l;
        root.right = r;
        System.out.print(getDirections(root, 3, 4));
               /*
                1
              2   3
               4
         */
    }

    static StringBuilder sb = new StringBuilder();
    public static String getDirections(TreeNode root, int startValue, int destValue) {
        // 获取公共祖先
        TreeNode ancestor = lowestCommonAncestor(root, startValue, destValue);
        findLPath(ancestor, startValue);
        int endL = sb.length();
        sb.delete(0,endL);
        sb.append("U".repeat(endL));
        findLPath(ancestor,destValue);
        return sb.toString();
    }

    private static boolean findLPath(TreeNode ancestor, int startValue) {
        if (ancestor == null)
            return false;
        if (ancestor.val == startValue) {
            return true;
        }
        sb.append("L");
        // 没找到才需要removeLast
        if(findLPath(ancestor.left, startValue))
            return true;
        sb.deleteCharAt(sb.length() - 1);
        sb.append("R");
        if(findLPath(ancestor.right, startValue))
            return true;
        sb.deleteCharAt(sb.length() - 1);
        return false;
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, int startValue, int destValue) {
        if (root == null || root.val == startValue || root.val == destValue) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, startValue, destValue);
        TreeNode r = lowestCommonAncestor(root.right, startValue, destValue);
        if (l != null && r != null) {
            return root;
        } else if (l != null) {
            return l;
        } else {
            return r;
        }
    }
}
