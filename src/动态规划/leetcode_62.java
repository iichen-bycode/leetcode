package 动态规划;

import java.util.Arrays;

/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

问总共有多少条不同的路径？



示例 1：


输入：m = 3, n = 7
输出：28
示例 2：

输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右
3. 向下 -> 向右 -> 向下
示例 3：

输入：m = 7, n = 3
输出：28
示例 4：

输入：m = 3, n = 3
输出：6


提示：

1 <= m, n <= 100
题目数据保证答案小于等于 2 * 109
 */
public class leetcode_62 {
    public static void main(String[] args) {
//        System.out.println(uniquePaths(3, 7));
//        System.out.println(uniquePaths(3, 2));
//        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths(3, 3));
    }

    public static int uniquePaths(int m, int n) {
        /*  3 * 3
            0   0   0   0

            若；
            dp[1] = 1,dp[j + 1] = dp[j] + dp[j+1];
            init 0   1   0   0

                 0   1  1   1
                 0  1   2   3
                 0  1   3   6

           若：
           dp[0] = 1,dp[j + 1] = dp[j] + dp[j+1];
           init 1   0   0   0

                1   1   1   1
                1   2   3   4
                1   3   6   10

         */
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
//                dp[j + 1] = dp[j + 1] + dp[j];
                dp[j + 1] += dp[j];
            }
//            for (int j = 0; j < dp.length; j++) {
//                System.out.print(dp[j] + "  ");
//            }
//            System.out.println();
        }
        return dp[n];
    }

    public static int uniquePaths2(int m, int n) {
        /*
            1   1   1
            1   1   1
            1   1   1

            0   1   0   0
            0   1   1   1
            0   1   2   3
            0   1   3   6

         */
        int[][] dp = new int[m + 1][n + 1];
//        dp[i][j] = dp[i-1][j] + dp[i][j-1];
        dp[0][1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j];
            }
        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j] + "   ");
//            }
//            System.out.println();
//        }
        return dp[m][n];
    }
}
