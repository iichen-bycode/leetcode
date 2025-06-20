package 动态规划;

import java.util.Arrays;

/*
给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例 1：

图片

输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
输出：7
解释：因为路径 1→3→1→1→1 的总和最小。
示例 2：

输入：grid = [[1,2,3],[4,5,6]]
输出：12
提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100
 */
public class leetcode_64 {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println(minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
        System.out.println(minPathSum(new int[][]{{1, 2}, {1,1}}));
    }

    public static int minPathSum(int[][] grid) {
          /* 0  max max max
            max  1   3   1
            max  1   5   1
            max  4   2   1


             0  max max max
            max  1   4   5
            max  2   7   6
            max  6   8   7

         */
        int n = grid[0].length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1] = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                dp[j + 1] = Math.min(dp[j], dp[j + 1]) + ints[j];
            }
            for (int i = 0; i < dp.length; i++) {
                System.out.print(dp[i] + "  ");
            }
            System.out.println();
        }

        return dp[n];
    }

    public static int minPathSum3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            // 额外多添加一维 方便计算 i==0 和 j==0
            dp[i + 1][0] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[1][1] = grid[0][0];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
                }
            }
        }
        return dp[m][n];
    }

    public static int minPathSum2(int[][] grid) {
        /*
            1   3   1
            1   5   1
            4   2   1

            1   4   5
            2   7   6
            6   8   7
         */
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j >= 1) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                }
                if (j == 0 && i >= 1) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                }
                if (i != 0 && j != 0) {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
