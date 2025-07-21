import helper.TreeNode;
import helper.Utils;

import java.net.URI;
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
        /*


         */
//        Utils.print(buildNext("aacaab"));
//        Utils.print(maxSlidingWindow(new int[]{2, 3, 4, 7, 8, 9, 1}, 3));
        /*

            010
            000
         */
//        System.out.println((char)('z' - 32));
//        System.out.println((char)('a' - 32));
//        System.out.println('9' - 0);
//        System.out.println('a' - 0);
//        System.out.println('z' - 0);
//        System.out.println('A' - 0);
//        System.out.println('Z' - 0);
        System.out.println(Integer.valueOf("223"));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>(); // 存下标

        for (int i = 0; i < n; i++) {
            // 移除超出窗口的元素
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 移除比当前元素小的尾部元素（保持单调递减）
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 添加当前元素
            deque.offerLast(i);

            // 窗口形成后，收集答案
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    private static int longestPalindrome(String pattern) {
        int n = pattern.length();
        boolean[][] dp = new boolean[n][n];
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                // 首尾字符相同则 子需要判断 dp[l+1][r-1] 是否为回文 即i与j之间的字串是否为
                if (pattern.charAt(i) == pattern.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[i][j] = true;
                    // 当前回文串更大
                    if (i - j > r - l) {
                        l = j;
                        r = i;
                    }
                }
            }
        }
        System.out.println(pattern.substring(l, r + 1));
        return r - l + 1;
    }

    private static int[] buildNext(String pattern) {
        int n = pattern.length(), l = 0;
        int[] next = new int[n];
        for (int i = 1; i < n; i++) {
            while (l > 0 && pattern.charAt(i) != pattern.charAt(l)) {
                l = next[l - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(l)) {
                l++;
            }
            next[i] = l;
        }
        return next;
    }

    class Solution {
        public String longestPalindrome(String s) {
            /*
             *
             * 当：s[right] == s[left]
             * 	right-left == 0 一个字符 满足
             *  right-left == 1 二和字符 满足
             *  right-left>=2 三个及以上字符
             */

            int i = 0, j = 0;
            boolean dp[][] = new boolean[s.length()][s.length()];
            for (int right = 0; right < s.length(); right++) {
                for (int left = 0; left <= right; left++) {
                    if ((s.charAt(right) == s.charAt(left)) && (right - left <= 2 || dp[left + 1][right - 1])) {
                        dp[left][right] = true;
                        if ((right - left) > (j - i)) {
                            i = left;
                            j = right;
                        }
                    }
                }
            }
            return s.substring(i, j + 1);
        }
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
