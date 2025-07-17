import helper.TreeNode;

import java.util.*;
import java.util.regex.Pattern;

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
//        int max = (int) (Math.pow(2, 31) - 1);
//        System.out.println((int) Math.sqrt(Integer.MAX_VALUE - 1) + "<>" + Integer.MAX_VALUE);
//        int a = 2147483600;
//        int m = (int) Math.sqrt(a - 1);
        /*
            4
            1   4
         */

//        System.out.println(erfen(new int[]{0, 2, 2, 3, 5, 7}, 4));
//        System.out.println(erfen(new int[]{1, 2, 3, 4, 5, 7}, 6));

//        long s = (long) 1000000000 + 1000000000 + 1000000000 + 1000000000;
//        System.out.println(s);
//        TreeNode a = new TreeNode(1);
//        TreeNode b = new TreeNode(1);
//        System.out.println(a == b);
//
//        TreeNode c = null;
//        TreeNode d = null;
//        System.out.println(c == d);
        // "aa" > "bb"
//        System.out.println( "l  " + ('l' - 'a'));
//        System.out.println( "e  " + ('e' - 'a'));
//        System.out.println( "t  " + ('t' - 'a'));
//        System.out.println( "c  " + ('c' - 'a'));
//        System.out.println( "o  " + ('o' - 'a'));
//        System.out.println( "d  " + ('d' - 'a'));
//        System.out.println( "zt  " + ('z' - 't'));
        /*
            5,9,20,27,0,0,0,0,0,0,>>>>>>> index: 4
            5,9,20,22,0,0,0,0,0,0,>>>>>>> index: 4
            5,13,26,0,0,0,0,0,0,0,>>>>>>> index: 3
            5,13,17,22,0,0,0,0,0,0,>>>>>>> index: 4
            5,13,17,18,0,0,0,0,0,0,>>>>>>> index: 4


            0,10,15,18,21,0,0,0,0,0,>>>>>>> index: 5
            0,10,15,18,16,0,0,0,0,0,>>>>>>> index: 5
            0,10,15,17,18,0,0,0,0,0,>>>>>>> index: 5
            0,10,7,18,0,0,0,0,0,0,>>>>>>> index: 4
         */
//        System.out.println(Pattern.matches("(?:.*[0-9].*){8,}","1d2d345d678"));
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        minHeap.offer(5);
//        minHeap.offer(4);
//        minHeap.offer(6);
//        minHeap.offer(1);
//        while (!minHeap.isEmpty()) {
//            System.out.println(minHeap.poll());
//        }
        /*
            0001
            0100
         */
        String a = "a";
        a = "b" + a;
        System.out.println("aba".compareTo("ab"));
    }

    private static void extracted(int[] f, int t) {
        int ans = 0;
        for (int i = 0; i < f.length - 1; i++) {
            int r = f.length - 1;
            while (i < r) {
                if (f[r] - f[i] == t) {
                    System.out.println(">>>>>>>> " + f + "<>" + i + "<>" + r);
                    ans++;
                }
                r--;
            }
        }
        System.out.println(ans);
    }

    public static int erfen(int[] ints, int target) {
        int l = 0, r = ints.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (ints[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
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
