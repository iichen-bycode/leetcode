package 回溯.划分;
/*
累加数 是一个字符串，组成它的数字可以形成累加序列。

一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，序列中的每个后续数字必须是它之前两个数字之和。

给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。

说明：累加序列里的数，除数字 0 之外，不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。



示例 1：

输入："112358"
输出：true
解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
示例 2：

输入："199100199"
输出：true
解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199


提示：

1 <= num.length <= 35
num 仅由数字（0 - 9）组成


进阶：你计划如何处理由过大的整数输入导致的溢出?
 */

import helper.Utils;

import java.util.ArrayList;

// 累加数
public class leetcode_306 {
    public static void main(String[] args) {
        /*
        输入："112358"
        输出：true
        解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
        示例 2：

        输入："199100199"
        输出：true
        解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
         */
        /*
             1
          1     12 123(x)
         2 23
        3
       5
         */
//        System.out.println(isAdditiveNumber("112358"));
//        ans = false;
        System.out.println(isAdditiveNumber("211738"));
        ans = false;
        System.out.println(isAdditiveNumber("1023"));
        ans = false;
//        System.out.println(isAdditiveNumber("19910019919910019919910019919910019"));
//        ans = false;

    }

    static boolean ans = false;

    public static boolean isAdditiveNumber(String num) {
        backTracking(num, 0, new ArrayList<Long>());
        return ans;
    }

    private static void backTracking(String num, int start, ArrayList<Long> list) {
        if (start == num.length()) {
            if (list.size() >= 3) {
                StringBuilder sb = new StringBuilder();
                for (long a : list) {
                    sb.append(a);
                }
                System.out.println(sb);
                if(sb.length() == num.length()) {
                    ans = true;
                }
            }
            return;
        }
        long t = 0;
        for (int i = start; i < num.length(); i++) {
            t = t * 10 + num.charAt(i) - '0';
            int size = list.size();
            if (size >= 2 && list.get(size - 2) > 1_000_000_000_000_00L) {
                return;
            }
            if (size < 2 || list.get(size - 1) + list.get(size - 2) == t) {
                list.add(t);
//                for (long a : list) {
//                    System.out.print(a + ",");
//                }
//                System.out.println();
                backTracking(num, i + 1, list);
                list.remove(t);
            }
        }
    }
}
