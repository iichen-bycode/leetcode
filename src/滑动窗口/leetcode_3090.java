package 滑动窗口;

import java.util.HashMap;

/*
给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该子字符串的 最大 长度。



示例 1：

输入： s = "bcbbbcba"

输出： 4

解释：

以下子字符串长度为 4，并且每个字符最多出现两次："bcbbbcba"。

示例 2：

输入： s = "aaaa"

输出： 2

解释：

以下子字符串长度为 2，并且每个字符最多出现两次："aaaa"。



提示：

2 <= s.length <= 100
s 仅由小写英文字母组成。
 */
public class leetcode_3090 {
    public static void main(String[] args) {
        System.out.println(maximumLengthSubstring("bcbbbcba"));
        System.out.println(maximumLengthSubstring("aaaa"));
        System.out.println(maximumLengthSubstring("acedc"));
    }

    public static int maximumLengthSubstring(String s) {
        int ans = 0, l = 0, n = s.length();
        int[] cache = new int[26];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            while (cache[c - 'a'] >= 2) {
                cache[s.charAt(l) - 'a'] -= 1;
                l++;
            }
            cache[c - 'a'] += 1;
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}
