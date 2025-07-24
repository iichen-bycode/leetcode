package 二叉树;
/*
给你一个有根节点 root 的二叉树，返回它 最深的叶节点的最近公共祖先 。

回想一下：

叶节点 是二叉树中没有子节点的节点
树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。


示例 1：


输入：root = [3,5,1,6,2,0,8,null,null,7,4]
输出：[2,7,4]
解释：我们返回值为 2 的节点，在图中用黄色标记。
在图中用蓝色标记的是树的最深的节点。
注意，节点 6、0 和 8 也是叶节点，但是它们的深度是 2 ，而节点 7 和 4 的深度是 3 。
示例 2：

输入：root = [1]
输出：[1]
解释：根节点是树中最深的节点，它是它本身的最近公共祖先。
示例 3：

输入：root = [0,1,3,null,2]
输出：[2]
解释：树中最深的叶节点是 2 ，最近公共祖先是它自己。


提示：

树中的节点数将在 [1, 1000] 的范围内。
0 <= Node.val <= 1000
每个节点的值都是 独一无二 的。
 */

import helper.TreeNode;

// 最深叶节点的最近公共祖先
public class leetcode_1123 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        TreeNode l = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
//        TreeNode r = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        TreeNode root = new TreeNode(0);
        TreeNode l = new TreeNode(1, null, new TreeNode(2));
        TreeNode r = new TreeNode(3);
        root.left = l;
        root.right = r;
        System.out.println(lcaDeepestLeaves(root).val);
    }

    static int maxDepth = 0;
    static TreeNode ans;

    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public static int dfs(TreeNode root, int depth) {
        if (root == null) {
            maxDepth = Math.max(maxDepth, depth);
            return depth;
        }
        // 对某个节点 只有左右子节点是包含最深的叶子才是答案
        int l = dfs(root.left, depth + 1);
        int r = dfs(root.right, depth + 1);
        // 左右相同深度且是最大深度 更新答案
        if (l == r && l == maxDepth) {
            ans = root;
        }
        return Math.max(l, r);
    }

//    class Solution {
//        public TreeNode lcaDeepestLeaves(TreeNode root) {
//            return dfs(root).getValue();
//        }
//
//        private Pair<Integer, TreeNode> dfs(TreeNode node) {
//            if (node == null) {
//                return new Pair<>(0, null);
//            }
//            Pair<Integer, TreeNode> left = dfs(node.left);
//            Pair<Integer, TreeNode> right = dfs(node.right);
//            if (left.getKey() > right.getKey()) { // 左子树更高
//                return new Pair<>(left.getKey() + 1, left.getValue());
//            }
//            if (left.getKey() < right.getKey()) { // 右子树更高
//                return new Pair<>(right.getKey() + 1, right.getValue());
//            }
//            return new Pair<>(left.getKey() + 1, node); // 一样高
//        }
//    }
}
