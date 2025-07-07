package 指针.双序列.子序列;
/*
给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。

如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。



示例 1：

输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
输出："apple"
示例 2：

输入：s = "abpcplea", dictionary = ["a","b","c"]
输出："a"


提示：

1 <= s.length <= 1000
1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 1000
s 和 dictionary[i] 仅由小写英文字母组成
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 通过删除字母匹配到字典里最长单词
public class leetcode_524 {
    public static void main(String[] args) {
        // apple
        System.out.println(findLongestWord("abpcplea", List.of("ale", "apple", "bpcpl", "monkey", "plea")));
        //a
//        System.out.println(findLongestWord("abpcplea", List.of("a", "b", "c")));
    }

    public static String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        for (String a : dictionary) {
            if (a.length() >= ans.length() && isSubsequence(a, s)) {
                if (a.length() > ans.length()) {
                    ans = a;
                } else {
                    for (int i = 0; i < a.length(); i++) {
                        if (a.charAt(i) < ans.charAt(i)) {
                            ans = a;
                            break;
                        } else if (a.charAt(i) > ans.charAt(i)) {
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty())
            return true;
        int l = 0, m = s.length(), r = 0, n = t.length();
        while (l < m && r < n) {
            char a = s.charAt(l);
            char b = t.charAt(r);
            if (a == b) {
                l++;
            }
            if (l == m)
                return true;
            r++;
        }
        return false;
    }
}
