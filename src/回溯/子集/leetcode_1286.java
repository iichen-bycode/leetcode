package 回溯.子集;
/*
请你设计一个迭代器类 CombinationIterator ，包括以下内容：

CombinationIterator(string characters, int combinationLength) 一个构造函数，输入参数包括：用一个 有序且字符唯一 的字符串 characters（该字符串只包含小写英文字母）和一个数字 combinationLength 。
函数 next() ，按 字典序 返回长度为 combinationLength 的下一个字母组合。
函数 hasNext() ，只有存在长度为 combinationLength 的下一个字母组合时，才返回 true


示例 1：

输入:
["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[["abc", 2], [], [], [], [], [], []]
输出：
[null, "ab", true, "ac", true, "bc", false]
解释：
CombinationIterator iterator = new CombinationIterator("abc", 2); // 创建迭代器 iterator
iterator.next(); // 返回 "ab"
iterator.hasNext(); // 返回 true
iterator.next(); // 返回 "ac"
iterator.hasNext(); // 返回 true
iterator.next(); // 返回 "bc"
iterator.hasNext(); // 返回 false


提示：

1 <= combinationLength <= characters.length <= 15
 characters 中每个字符都 不同
每组测试数据最多对 next 和 hasNext 调用 104次
题目保证每次调用函数 next 时都存在下一个字母组合。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 字母组合迭代器
public class leetcode_1286 {
    public static void main(String[] args) {
        CombinationIterator combinationIterator = new CombinationIterator("abc", 2);
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
    }

    static class CombinationIterator {
        List<String> ans = new ArrayList<>();
        char[] cache;
        int size = 0;

        public CombinationIterator(String characters, int combinationLength) {
            cache = new char[combinationLength];
            backTracking(characters, 0, 0, combinationLength);
        }

        private void backTracking(String characters, int start, int index, int combinationLength) {
            if (index == combinationLength) {
                ans.add(new String(cache));
                return;
            }
            for (int j = start; j < characters.length(); j++) {
                cache[index] = characters.charAt(j);
                backTracking(characters, j + 1, index + 1, combinationLength);
            }
        }

        public String next() {
            return ans.get(size++);
        }

        public boolean hasNext() {
            return size < ans.size();
        }
    }

    static class CombinationIterator2 {
        List<String> ans = new ArrayList<>();

        public CombinationIterator2(String characters, int combinationLength) {
            backTracking(characters, 0, combinationLength, new StringBuilder());
        }

        private void backTracking(String characters, int i, int combinationLength, StringBuilder path) {
            if (path.length() == combinationLength) {
                ans.add(path.toString());
                return;
            }
            for (int j = i; j < characters.length(); j++) {
                path.append(characters.charAt(j));
                backTracking(characters, j + 1, combinationLength, path);
                path.deleteCharAt(path.length() - 1);
            }
        }

        public String next() {
            if (ans.isEmpty())
                return "";
            return ans.remove(0);
        }

        public boolean hasNext() {
            return !ans.isEmpty();
        }
    }
}
