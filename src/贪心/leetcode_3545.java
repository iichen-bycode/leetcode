package 贪心;

import java.util.Arrays;

/*
给你一个字符串 s（由小写英文字母组成）和一个整数 k。

你的任务是删除字符串中的一些字符（可以不删除任何字符），使得结果字符串中的 不同字符数量 最多为 k。

返回为达到上述目标所需删除的 最小 字符数量。



示例 1：

输入： s = "abc", k = 2

输出： 1

解释：

s 有三个不同的字符：'a'、'b' 和 'c'，每个字符的出现频率为 1。
由于最多只能有 k = 2 个不同字符，需要删除某一个字符的所有出现。
例如，删除所有 'c' 后，结果字符串中的不同字符数最多为 k。因此，答案是 1。
示例 2：

输入： s = "aabb", k = 2

输出： 0

解释：

s 有两个不同的字符（'a' 和 'b'），它们的出现频率分别为 2 和 2。
由于最多可以有 k = 2 个不同字符，不需要删除任何字符。因此，答案是 0。
示例 3：

输入： s = "yyyzz", k = 1

输出： 2

解释：

s 有两个不同的字符（'y' 和 'z'），它们的出现频率分别为 3 和 2。
由于最多只能有 k = 1 个不同字符，需要删除某一个字符的所有出现。
删除所有 'z' 后，结果字符串中的不同字符数最多为 k。因此，答案是 2。


提示：

1 <= s.length <= 16
1 <= k <= 16
s 仅由小写英文字母组成。
 */
public class leetcode_3545 {
    public static void main(String[] args) {
        System.out.println(minDeletion("abc", 2));// 1
        System.out.println(minDeletion("aabb", 2));// 0
        System.out.println(minDeletion("yyyzz", 1));// 2
    }

    public static int minDeletion(String s, int k) {
        int[] cache = new int[26];
        char[] c = s.toCharArray();
        for (char value : c) {
            cache[value - 'a']++;
        }
        Arrays.sort(cache);
        int ans = 0, n = cache.length;
        for (int i = 0; i < n; i++) {
            if (cache[i] > 0 && i < n - k) {
                ans += cache[i];
            }
        }
        return ans;
    }
}
