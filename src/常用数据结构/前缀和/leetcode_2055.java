package 常用数据结构.前缀和;
/*
给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。

同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。

比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。



示例 1:

ex-1

输入：s = "**|**|***|", queries = [[2,5],[5,9]]
输出：[2,3]
解释：
- queries[0] 有两个盘子在蜡烛之间。
- queries[1] 有三个盘子在蜡烛之间。
示例 2:

ex-2

输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
输出：[9,0,0,0,0]
解释：
- queries[0] 有 9 个盘子在蜡烛之间。
- 另一个查询没有盘子在蜡烛之间。


提示：

3 <= s.length <= 105
s 只包含字符 '*' 和 '|' 。
1 <= queries.length <= 105
queries[i].length == 2
0 <= lefti <= righti < s.length
 */

import helper.Utils;

// 蜡烛之间的盘子   未作出
public interface leetcode_2055 {
    public static void main(String[] args) {
        /*
        输入：s = "**|**|***|", queries = [[2,5],[5,9]]
        输出：[2,3]

        输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
        输出：[9,0,0,0,0]
         */
        Utils.print(platesBetweenCandles("**|**|***|", new int[][]{{2, 5}, {5, 9}}));
        /*
          0 1 2 3 4 5 6 7 8 9 10

            |  3  6  12  15  16  19
         */
        Utils.print(platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}}));

        Utils.print(platesBetweenCandles("**|*******************|**********************************************|************|*********|*****|*********************************************************************************************|***",
                new int[][]{{100, 164}}));
        /*
          0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21
            0 0 0 0 0 0 2 2 2 2  2  2  7  7  7  9  9  9  9  11 11
         */
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] preSum = new int[n];
        for (int i = 0, sum = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            preSum[i] = sum;
        }
        // 左侧的距离 | 的第一个的下标
        int[] left = new int[n];
        for (int i = 0, l = -1; i < n; i++) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            left[i] = l;
        }
        // 右侧的距离 | 的第一个的下标
        int[] right = new int[n];
        for (int i = n - 1, r = -1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            right[i] = r;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = right[query[0]], y = left[query[1]];
            ans[i] = x == -1 || y == -1 || x >= y ? 0 : preSum[y] - preSum[x];
        }
        return ans;
    }

    public static int[] platesBetweenCandles2(String s, int[][] queries) {
        /*

         */
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            while (l < r) {
                if (s.charAt(l) == '|' && s.charAt(r) == '|')
                    break;
                if (s.charAt(l) != '|') {
                    l++;
                }
                if (s.charAt(r) != '|') {
                    r--;
                }
            }
            System.out.println(l + "<>" + r);
            for (int j = l; j < r; j++) {
                ans[i] += s.charAt(j) == '*' ? 1 : 0;
            }
        }
        return ans;
    }
}
