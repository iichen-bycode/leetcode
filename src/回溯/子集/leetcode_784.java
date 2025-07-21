package 回溯.子集;

/*
给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。

返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。



示例 1：

输入：s = "a1b2"
输出：["a1b2", "a1B2", "A1b2", "A1B2"]



示例 2:

输入: s = "3z4"
输出: ["3z4","3Z4"]


提示:

1 <= s.length <= 12
s 由小写英文字母、大写英文字母和数字组成
 */

import helper.Utils;

import java.util.ArrayList;
import java.util.List;

// 字母大小写全排列
public class leetcode_784 {
    public static void main(String[] args) {
        Utils.printListS(letterCasePermutation("a1b2"));
        ans.clear();
        Utils.printListS(letterCasePermutation("3z4"));
        ans.clear();
        Utils.printListS(letterCasePermutation("C"));
    }

    static List<String> ans = new ArrayList<>();

    public static List<String> letterCasePermutation(String s) {
        // (char)('a' - 32)
        backTracking(s, 0, "");
        return ans;
    }

    private static void backTracking(String s, int start, String path) {
        /*  a1b2
                a           A
                1           1
               b  B       b   B
               2  2       2   2

         */
        if (path.length() == s.length()) {
            ans.add(path);
            return;
        }
        char c = s.charAt(start);
        if (c < 'A') {
            path += c;
            backTracking(s, start + 1, path);
        } else if (c < 'a') {
            backTracking(s, start + 1, path + c);
            backTracking(s, start + 1, path + (char) (c + 32));
        } else {
            backTracking(s, start + 1, path + c);
            backTracking(s, start + 1, path + (char) (c - 32));
        }
    }
}
