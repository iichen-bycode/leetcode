package 常用数据结构.枚举技巧;

import helper.Utils;

import java.util.Arrays;
import java.util.HashSet;

/*
给你一个字符串 s ，返回 s 中 长度为 3 的不同回文子序列 的个数。

即便存在多种方法来构建相同的子序列，但相同的子序列只计数一次。

回文 是正着读和反着读一样的字符串。

子序列 是由原字符串删除其中部分字符（也可以不删除）且不改变剩余字符之间相对顺序形成的一个新字符串。

例如，"ace" 是 "abcde" 的一个子序列。


示例 1：

输入：s = "aabca"
输出：3
解释：长度为 3 的 3 个回文子序列分别是：
- "aba" ("aabca" 的子序列)
- "aaa" ("aabca" 的子序列)
- "aca" ("aabca" 的子序列)
示例 2：

输入：s = "adc"
输出：0
解释："adc" 不存在长度为 3 的回文子序列。
示例 3：

输入：s = "bbcbaba"
输出：4
解释：长度为 3 的 4 个回文子序列分别是：
- "bbb" ("bbcbaba" 的子序列)
- "bcb" ("bbcbaba" 的子序列)
- "bab" ("bbcbaba" 的子序列)
- "aba" ("bbcbaba" 的子序列)


提示：

3 <= s.length <= 105
s 仅由小写英文字母组成

https://leetcode.cn/problems/unique-length-3-palindromic-subsequences/description/
 */
public class leetcode_1930 {
    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca"));
//        System.out.println(countPalindromicSubsequence("adc"));
//        System.out.println(countPalindromicSubsequence("bbcbaba"));

        // 3 0 4
    }

    // 可以同3563 处理
    public static int countPalindromicSubsequence(String s) {
        /*
            遍历j 记录左侧、右侧 s[i]字符存在的数量 。
            若右侧存在左侧的字符则 当前j可以组成
         */
        char[] ss = s.toCharArray();
        int[] l = new int[26];
        int[] r = new int[26];
        HashSet<Integer> ans = new HashSet<>();
        for (char c : ss) {
            r[c - 'a'] += 1;
        }
        /*
            bbcbaba

        - "bbb" ("bbcbaba" 的子序列)
        - "bcb" ("bbcbaba" 的子序列)
        - "bab" ("bbcbaba" 的子序列)
        - "aba" ("bbcbaba" 的子序列)

         */
        for (char c : ss) {
            Utils.print(l);
            Utils.print(r);
            // aabca
            r[c - 'a'] -= 1;
            for (int i = 0; i < l.length; i++) {
                if (l[i] != 0 && r[i] != 0) {
                    ans.add((i + 1) * 100 + (c - 'a') * 10 + (i + 1));
                }
            }
            l[c - 'a'] += 1;
        }
        return ans.size();
    }
}
