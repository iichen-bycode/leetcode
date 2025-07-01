import helper.TreeNode;
import helper.Utils;

import java.util.*;

public class test {
    public static void main(String[] args) {
        /*
            8   4   2   1
            3:  11
            4: 100
         */
//        System.out.println(1 << 2);
//        System.out.println(1 << 3);
//        System.out.println((1 << 2) & (1 << 3));
//        System.out.println(numberOfSubstrings("abcabbb"));
        // 16 8 4 2 1
        /*
            1000

            1111
         */
        //        [[4,8],[3,6],[10,20],[15,30]]
//        [[4,5],[7,8]]
        /*
            0010
            0101
         */
//        Deque<Integer> stack = new ArrayDeque<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        for (int a : stack) {
//            System.out.print(a+",");
//        }
//        System.out.println();
//        for (int a : queue) {
//            System.out.print(a+",");
//        }
//        System.out.println();
//        System.out.println(Long.MAX_VALUE);
//        System.out.println(Math.max(Integer.MAX_VALUE,2147483647));
        System.out.println(Integer.valueOf("465"));
    }


    public static int numberOfSubstrings(String S) {
        char[] s = S.toCharArray();

        int ans = 0;
        int left = 0;
        int[] cnt = new int[3];
        for (char c : s) {
            cnt[c - 'a']++;
            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                cnt[s[left] - 'a']--;
                left++;
            }
            ans += left;
        }
        return ans;
    }
}
