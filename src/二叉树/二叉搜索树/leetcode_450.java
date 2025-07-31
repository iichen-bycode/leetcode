package 二叉树.二叉搜索树;

/*
给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

一般来说，删除节点可分为两个步骤：

首先找到需要删除的节点；
如果找到了，删除它。


示例 1:



输入：root = [5,3,6,2,4,null,7], key = 3
输出：[5,4,6,2,null,null,7]
解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
另一个正确答案是 [5,2,6,null,4,null,7]。


示例 2:

输入: root = [5,3,6,2,4,null,7], key = 0
输出: [5,3,6,2,4,null,7]
解释: 二叉树不包含值为 0 的节点
示例 3:

输入: root = [], key = 0
输出: []


提示:

节点数的范围 [0, 104].
-105 <= Node.val <= 105
节点值唯一
root 是合法的二叉搜索树
-105 <= key <= 105


进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。
 */

import helper.TreeNode;

// 删除二叉搜索树中的节点
public class leetcode_450 {
    // 原始笨方法
    private TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            TreeNode l = root.left;
            TreeNode r = root.right;
            if(r == null) {
                return l;
            } else {
                while (r.left != null) {
                    r = r.left;
                }
                r.left = l;
                return root.right;
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    // 普通二叉树删除
//    class Solution {
//        public:
//        TreeNode* deleteNode(TreeNode* root, int key) {
//            if (root == nullptr) return root;
//            if (root->val == key) {
//                if (root->right == nullptr) { // 这里第二次操作目标值：最终删除的作用
//                    return root->left;
//                }
//                TreeNode *cur = root->right;
//                while (cur->left) {
//                    cur = cur->left;
//                }
//                swap(root->val, cur->val); // 这里第一次操作目标值：交换目标值其右子树最左面节点。
//            }
//            root->left = deleteNode(root->left, key);
//            root->right = deleteNode(root->right, key);
//            return root;
//        }
//    }
}


















