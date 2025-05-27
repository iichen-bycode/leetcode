package medium;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode_971 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10,new TreeNode(11,new TreeNode(111),new TreeNode(112)),new TreeNode(12));
        List<Integer> res = flipMatchVoyage(treeNode,new int[]{10,12,11,111,112});
        for (Integer re : res) {
            System.out.print(re + ",");
        }
    }
    public static List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        int index = 0;
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
           if(p != null) {
               if(p.val != voyage[index]) {
                   return List.of(-1);
               }
               ++index;
               if(p.left != null && p.right !=null && p.right.val == voyage[index]) {
                   TreeNode t = p.left;
                   p.left = p.right;
                   p.right = t;
                   ans.add(p.val);
               }
               stack.add(p);
               p = p.left;
           } else {
               p = stack.pop().right;
           }
        }
        return ans;
    }
}
