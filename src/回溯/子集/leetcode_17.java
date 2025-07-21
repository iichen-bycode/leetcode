package 回溯.子集;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。





示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]


提示：

0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。
 */

import helper.Utils;

import java.util.ArrayList;
import java.util.List;

// 电话号码的字母组合
public class leetcode_17 {
    public static void main(String[] args) {
//        Utils.printListS(letterCombinations("23"));
        Utils.printListS(letterCombinations("23"));
    }

    static List<String> ans = new ArrayList<>();

    static char[][] number = new char[][]{{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    public static List<String> letterCombinations(String digits) {
        if(digits.isBlank())
            return ans;
        backTracking(digits, number, 0, new StringBuilder());
        return ans;
    }

    // cIndex就是第几层循环    结束条件就是 当cIndex为digits的长度
    private static void backTracking(String digits, char[][] number, int cIndex, StringBuilder sb) {
        if (cIndex == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        int a = digits.charAt(cIndex) - '0';
        for (int i = 0; i < number[a].length; i++) {
            sb.append(number[a][i]);
            backTracking(digits, number, cIndex + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
