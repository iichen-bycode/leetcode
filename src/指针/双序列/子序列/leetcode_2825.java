package 指针.双序列.子序列;
/*
给你一个下标从 0 开始的字符串 str1 和 str2 。

一次操作中，你选择 str1 中的若干下标。对于选中的每一个下标 i ，你将 str1[i] 循环 递增，变成下一个字符。也就是说 'a' 变成 'b' ，'b' 变成 'c' ，以此类推，'z' 变成 'a' 。

如果执行以上操作 至多一次 ，可以让 str2 成为 str1 的子序列，请你返回 true ，否则返回 false 。

注意：一个字符串的子序列指的是从原字符串中删除一些（可以一个字符也不删）字符后，剩下字符按照原本先后顺序组成的新字符串。



示例 1：

输入：str1 = "abc", str2 = "ad"
输出：true
解释：选择 str1 中的下标 2 。
将 str1[2] 循环递增，得到 'd' 。
因此，str1 变成 "abd" 且 str2 现在是一个子序列。所以返回 true 。
示例 2：

输入：str1 = "zc", str2 = "ad"
输出：true
解释：选择 str1 中的下标 0 和 1 。
将 str1[0] 循环递增得到 'a' 。
将 str1[1] 循环递增得到 'd' 。
因此，str1 变成 "ad" 且 str2 现在是一个子序列。所以返回 true 。
示例 3：

输入：str1 = "ab", str2 = "d"
输出：false
解释：这个例子中，没法在执行一次操作的前提下，将 str2 变为 str1 的子序列。
所以返回 false 。


提示：

1 <= str1.length <= 10^5
1 <= str2.length <= 10^5
str1 和 str2 只包含小写英文字母。
 */

// 循环增长使字符串子序列等于另一个字符串
public class leetcode_2825 {
    public static void main(String[] args) {
        System.out.println(canMakeSubsequence("abc", "ad"));
        System.out.println(canMakeSubsequence("zc", "ad"));
        System.out.println(canMakeSubsequence("ab", "d"));
    }

    public static boolean canMakeSubsequence(String str1, String str2) {
        /*
            a=97  z=122
         */
        int l = 0, r = 0, m = str1.length(), n = str2.length();
        while (l < m && r < n) {
            char a = str1.charAt(l);
            char b = str2.charAt(r);
            if (a == b || (a == 'z' ? 'a' : a + 1) == b) {
                r++;
            }
            if(r == n)
                return true;
            l++;
        }
        return r == n;
    }
}
