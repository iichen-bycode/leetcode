package 二叉树.最近公共祖先;

import helper.TreeNode;
/*
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”



示例 1：


输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出：3
解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
示例 2：


输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出：5
解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
示例 3：

输入：root = [1,2], p = 1, q = 2
输出：1


提示：

树中节点数目在范围 [2, 105] 内。
-109 <= Node.val <= 109
所有 Node.val 互不相同 。
p != q
p 和 q 均存在于给定的二叉树中。
 */

// 二叉树的最近公共祖先
public class leetcode_236 {
    public static void main(String[] args) {
   /*
                        4
                     2      6
                   1   3  5   7

         */
//        TreeNode root = new TreeNode(4);
//        TreeNode l = new TreeNode(2, new TreeNode(1), new TreeNode(3));
//        TreeNode r = new TreeNode(6, new TreeNode(5), new TreeNode(7));
//        root.left = l;
//        root.right = r;
//        System.out.println(lowestCommonAncestor(root, new TreeNode(1), new TreeNode(3)).val);
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2, null, new TreeNode(4));
        TreeNode r = new TreeNode(3);
        root.left = l;
        root.right = r;
        System.out.println(lowestCommonAncestor(root, new TreeNode(4), new TreeNode(3)).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
                1
              2   3
               4
         */
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null) {
            return root;
        } else if (l != null) {
            return l;
        } else return r;
    }
}
