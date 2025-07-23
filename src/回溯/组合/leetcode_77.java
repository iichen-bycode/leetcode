package 回溯.组合;

/*
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。



示例 1：

输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
示例 2：

输入：n = 1, k = 1
输出：[[1]]


提示：

1 <= n <= 20
1 <= k <= n
 */

import helper.Utils;
import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 组合
public class leetcode_77 {
    public static void main(String[] args) {
        Utils.printList2(combine(4, 3));
        ans.clear();
        Utils.printList2(combine(1, 1));
    }

    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        backTracking(1, n, k, new LinkedList<Integer>());
        return ans;
    }

    private static void backTracking(int start, int n, int k, LinkedList<Integer> list) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        // n - (k - item.size()) + 1
        /*
            1 2 3 4 5  n = 5,k = 3,start = 4 就没不要了
            还要选择 k - size,
            下标最大：n - (k - size) + 1
         */
        for (int i = start; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            backTracking(i + 1, n, k, list);
            list.removeLast();
        }
    }
}
