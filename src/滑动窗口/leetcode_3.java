package 滑动窗口;

import java.util.HashSet;
import java.util.Map;

/*
给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。



示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


提示：

0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成
 */
public class leetcode_3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int ans = 0, l = 0, r = 0, n = s.length();
        HashSet<Character> cache = new HashSet<>();
        while (r < n) {
            char c = s.charAt(r);
            // 从左逐个移除掉
            while (cache.contains(c)) {
                cache.remove(s.charAt(l));
                ++l;
            }
            cache.add(c);
            ans = Math.max(ans,r - l + 1);
            r++;
        }
        return ans;
    }
}
