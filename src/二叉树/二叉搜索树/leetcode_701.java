package 二叉树.二叉搜索树;

/*
给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。

注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。



示例 1：


输入：root = [4,2,7,1,3], val = 5
输出：[4,2,7,1,3,5]
解释：另一个满足题目要求可以通过的树是：

示例 2：

输入：root = [40,20,60,10,30,50,70], val = 25
输出：[40,20,60,10,30,50,70,null,null,25]
示例 3：

输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
输出：[4,2,7,1,3,5]


提示：

树中的节点数将在 [0, 104]的范围内。
-108 <= Node.val <= 108
所有值 Node.val 是 独一无二 的。
-108 <= val <= 108
保证 val 在原始BST中不存在。
 */

import helper.TreeNode;

// 二叉搜索树中的插入操作
public class leetcode_701 {
    TreeNode pre;

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        if(root.val > val) {
            // 链接新增的节点
            root.right = insertIntoBST(root.right,val);
        } else {
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }

    // 迭代实现
    public TreeNode insertIntoBST3(TreeNode root, int val) {
        TreeNode t = new TreeNode(val);
        if (root == null) {
            return t;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > val) {
                if (cur.left == null) {
                    cur.left = t;
                    break;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = t;
                    break;
                }
                cur = cur.right;
            }
        }
        return root;
    }

    public TreeNode insertIntoBST2(TreeNode root, int val) {
        TreeNode t = new TreeNode(val);
        if (root == null)
            return t;
        dfs(root, val);
        if (pre.val > val) {
            // 可以不要
//            if(pre.left != null) {
//                t.left = pre.left;
//            }
            pre.left = t;
        } else {
            if (pre.right != null) {
                t.right = pre.right;
            }
            pre.right = t;
        }
        return root;
    }

    private void dfs(TreeNode root, int val) {
        if (root == null)
            return;
        dfs(root.left, val);
        if (root.val > val && pre != null) {
            return;
        }
        pre = root;
        dfs(root.right, val);
    }
}























