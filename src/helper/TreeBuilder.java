package helper;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TreeBuilder {
    public TreeNode build(int[] nodes, int place) {
        // 1,2,3,4,5,null,8,null,null,6,7,9
        /*
                        1
                2               3
            4       5       x       8
         x     x  6   7          9


                      0
                 1        2
               3    4   5   6
         */
        int index = 0;
        TreeNode root = new TreeNode(nodes[index]);
        Queue<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        while (!stack.isEmpty() && (2 * index + 2) < nodes.length) {
            TreeNode node = stack.poll();
            TreeNode left = nodes[2 * index + 1] == place ? null : new TreeNode(nodes[2 * index + 1]);
            TreeNode right = nodes[2 * index + 2] == place ? null : new TreeNode(nodes[2 * index + 2]);
            node.left = left;
            node.right = right;
            if (left != null) {
                stack.add(left);
            }
            if (right != null) {
                stack.add(right);
            }
            /*
                left == null  ++
                right == null ++
                left,right == null  +=2
             */
            index = left == null && right == null ? index + 3 : index + 2;
        }
        return root;
    }
}
