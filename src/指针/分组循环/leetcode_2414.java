package 指针.分组循环;

/*
字母序连续字符串 是由字母表中连续字母组成的字符串。换句话说，字符串 "abcdefghijklmnopqrstuvwxyz" 的任意子字符串都是 字母序连续字符串 。

例如，"abc" 是一个字母序连续字符串，而 "acb" 和 "za" 不是。
给你一个仅由小写英文字母组成的字符串 s ，返回其 最长 的 字母序连续子字符串 的长度。



示例 1：

输入：s = "abacaba"
输出：2
解释：共有 4 个不同的字母序连续子字符串 "a"、"b"、"c" 和 "ab" 。
"ab" 是最长的字母序连续子字符串。
示例 2：

输入：s = "abcde"
输出：5
解释："abcde" 是最长的字母序连续子字符串。


提示：

1 <= s.length <= 105
s 由小写英文字母组成
 */

// 最长的字母序连续子字符串的长度
public class leetcode_2414 {
    public static void main(String[] args) {
        System.out.println(longestContinuousSubstring("abacaba"));
        System.out.println(longestContinuousSubstring("abcde"));
        System.out.println(longestContinuousSubstring("abcdefghijklznopqrstuvwxyz"));
        // a
    }

    public static int longestContinuousSubstring(String s) {
        int count = 1, ans = 1,n = s.length();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1) + 1) {
                count++;
            } else {
                count = 1;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
