package 动态规划;

import helper.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
给定一个三角形 triangle ，找出自顶向下的最小路径和。

每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。



示例 1：

输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
输出：11
解释：如下面简图所示：
   2
  3 4
 6 5 7
4 1 8 3
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
示例 2：

输入：triangle = [[-10]]
输出：-10


提示：

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104


进阶：

你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
https://leetcode.cn/problems/triangle/description/
 */
public class leetcode_120 {
    public static void main(String[] args) {
        // [[2],[3,4],[6,5,7],[4,1,8,3]]
        System.out.println(minimumTotal(Arrays.asList(List.of(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), List.of(4, 1, 8, 3))));
//        System.out.println(minimumTotal(List.of(List.of(-10))));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        // f[i] = Math.max(f[i],f[i-1]) + a[i]
        /*
               2
              3 4
             6 5 7
            4 1 8 3

            x   0   0   0   0
            x   2   x   x   x
            x   3   4   x   x
            x   6   5   7   x
            x   4   1   8   3


            x   4   1   8   3
            x   6   5   7   x
            x   3   4   x   x
            x   2   x   x   x
            x   0   0   0   0

            4   1   8   3
            7   6   10  3
            9   10  10  3
            11  10  10  3

         */
        // 反向遍历
        int[] f = new int[m];
        for (int i = 0; i < m; i++) {
            f[i] = triangle.get(m - 1).get(i);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                f[j] = Math.min(f[j], f[j + 1]) + triangle.get(i).get(j);
            }
            Utils.print(f);
        }
        return f[0];
    }

    public static int minimumTotal2(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] f = new int[m + 1][m + 1];
        // f[i] = Math.max(f[i],f[i-1]) + a[i]
        /*
               2
              3 4
             6 5 7
            4 1 8 3

            x   0   0   0   0
            x   2   x   x   x
            x   3   4   x   x
            x   6   5   7   x
            x   4   1   8   3


            x   0   0   0   0
            x   2   x   x   x
            x   5   6   x   x
            x   11  10  13   x
            x   15  11  18  16
         */
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    if (j == 0) {
                        f[i][j] = Integer.MAX_VALUE;
                    }
                } else {
                    f[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i + 1; j++) {
                f[i + 1][j + 1] = Math.min(f[i][j + 1], f[i][j]) + triangle.get(i).get(j);
            }
//            Utils.print2(f);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m + 1; i++) {
            ans = Math.min(ans, f[m][i]);
        }
        return ans;
    }
}
