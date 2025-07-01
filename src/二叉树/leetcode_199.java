package 二叉树;

/*
给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。



示例 1：

输入：root = [1,2,3,null,5,null,4]

输出：[1,3,4]

解释：



示例 2：

输入：root = [1,2,3,4,null,null,null,5]

输出：[1,3,4,5]

解释：



示例 3：

输入：root = [1,null,3]

输出：[1,3]

示例 4：

输入：root = []

输出：[]



提示:

二叉树的节点个数的范围是 [0,100]
-100 <= Node.val <= 100

 */

import helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//二叉树的右视图
public class leetcode_199 {
    public List<Integer> rightSideView2(TreeNode root) {
        // 层次遍历 每层的最后一个元素即可
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode t = queue.poll();
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
                if (size == 1) {
                    ans.add(t.val);
                }
                size--;
            }
        }
        return ans;
    }

    public List<Integer> rightSideView(TreeNode root) {
        // 每层最右侧 最后一个就是需要的  而且每层深度与ans长度相同
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        dfs(root, ans, 0);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans, int depth) {
        // 自顶向下
        if (root == null) {
            return;
        }
        // 首次深度达到添加数据
        if (ans.size() == depth) {
            ans.add(root.val);
        }
        dfs(root.right, ans, depth + 1);
        dfs(root.left, ans, depth + 1);
    }


    /*
            /
                   1
              2         3
          4
       5
     */
}
