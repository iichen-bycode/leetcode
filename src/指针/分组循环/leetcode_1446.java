package 指针.分组循环;
/*
给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。

请你返回字符串 s 的 能量。



示例 1：

输入：s = "leetcode"
输出：2
解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
示例 2：

输入：s = "abbcccddddeeeeedcba"
输出：5
解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。


提示：

1 <= s.length <= 500
s 只包含小写英文字母。

 */


//连续字符
public class leetcode_1446 {
    public static void main(String[] args) {
        System.out.println(maxPower("leetcode"));
        System.out.println(maxPower("abbcccddddeeeeedcba"));
    }

    public static int maxPower(String s) {
        char last = 'A';
        int count = 1, ans = 1;
        for (char c : s.toCharArray()) {
            if (c == last) {
                count++;
                ans = Math.max(ans, count);
            } else {
                last = c;
                count = 1;
            }
        }
        return ans;
    }
}
