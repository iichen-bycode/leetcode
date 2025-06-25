package 动态规划;

import helper.Utils;

import java.util.Arrays;

/*
给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。

下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。



示例 1：



输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
输出：13
解释：如图所示，为和最小的两条下降路径
示例 2：



输入：matrix = [[-19,57],[-40,-5]]
输出：-59
解释：如图所示，为和最小的下降路径


提示：

n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100

https://leetcode.cn/problems/minimum-falling-path-sum/description/
 */
public class leetcode_931 {
    public static void main(String[] args) {
        // [[2,1,3],[6,5,4],[7,8,9]]
        // [[-19,57],[-40,-5]]
        System.out.println(minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
        System.out.println(minFallingPathSum(new int[][]{{-19, 57}, {-40, -5}}));
        System.out.println(minFallingPathSum(new int[][]{{-48}}));
    }

    public static int minFallingPathSum(int[][] matrix) {
        // 空间优化 使用一维数组
            /*
            0   0   0   0   x
            0   2   1   3   x
            0   6   5   4   x
            0   7   8   9   x

            // 正序
            x   0   0   0
            x   2   1   3
            x   7   6   5
            x   13  13  14
            x   0   0   0

         */
        int m = matrix.length, n = matrix[0].length;
        int[] f = new int[n + 2];
        f[0] = f[n + 1] = Integer.MAX_VALUE;
        int pre = 0;
        for (int i = 0; i < m; i++) {
            pre = f[0];
            for (int j = 0; j < n; j++) {
                int t = pre;
                // 记录上一次计算的结果
                pre = f[j + 1];
                f[j + 1] = Math.min(Math.min(t, f[j + 1]), f[j + 2]) + matrix[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            ans = Math.min(ans, f[i]);
        }
        return ans;
    }

    public static int minFallingPathSum2(int[][] matrix) {
        // f[i][j] = min(f[i-1][j-1],f[i-1][j],f[i-1][j+1]) + matrix[i][j]
        /*
            0   0   0   0   x
            0   2   1   3   x
            0   6   5   4   x
            0   7   8   9   x

            // 正序
            x   0   0   0
            x   2   1   3
            x   7   6   5
            x   13  13  14
            x   0   0   0

         */
        int m = matrix.length, n = matrix[0].length;
        int[][] f = new int[m + 1][n + 2];
        for (int i = 0; i < m; i++) {
            f[i][0] = Integer.MAX_VALUE;
            f[i][n + 1] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                f[i + 1][j + 1] = Math.min(Math.min(f[i][j], f[i][j + 1]), f[i][j + 2]) + matrix[i][j];
            }
        }
        Utils.print2(f);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            ans = Math.min(ans, f[m][i]);
        }
        return ans;
    }
}
