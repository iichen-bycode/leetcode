package 滑动窗口;

/*
给你一个字符串 s ，它只包含三种字符 a, b 和 c 。

请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。



示例 1：

输入：s = "abcabc"
输出：10
解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
示例 2：

输入：s = "aaacb"
输出：3
解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。
示例 3：

输入：s = "abc"
输出：1


提示：

3 <= s.length <= 5 x 10^4
s 只包含字符 a，b 和 c 。
https://leetcode.cn/problems/number-of-substrings-containing-all-three-characters/description/
 */
public class leetcode_1358 {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
        System.out.println(numberOfSubstrings("aaacb"));
        System.out.println(numberOfSubstrings("abc"));
    }

    // 越长越合法
    public static int numberOfSubstrings(String s) {
        int len = s.length(), ans = 0, l = 0;
        char[] c = s.toCharArray();
        int[] count = new int[3];
        for (int i = 0; i < len; i++) {
            count[c[i] - 'a'] += 1;
            // "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc"
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                ans += len - i;
                count[c[l++] - 'a'] -= 1;
            }
        }
        return ans;
    }
}
