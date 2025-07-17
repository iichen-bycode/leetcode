package 二叉树.直径;

import helper.TreeNode;

public class leetcode_437 {
    class Solution {
        public int pathSum(TreeNode root, long targetSum) {
            if (root == null) {
                return 0;
            }

            // 类同1367
            int ret = rootSum(root, targetSum);
            ret += pathSum(root.left, targetSum);
            ret += pathSum(root.right, targetSum);
            return ret;
        }

        public int rootSum(TreeNode root, long targetSum) {
            int ret = 0;

            if (root == null) {
                return 0;
            }
            int val = root.val;
            if (val == targetSum) {
                ret++;
            }

            ret += rootSum(root.left, targetSum - val);
            ret += rootSum(root.right, targetSum - val);
            return ret;
        }
    }
}
