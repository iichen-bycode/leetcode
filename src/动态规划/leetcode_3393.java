package 动态规划;

/*
给你一个大小为 m x n 的二维整数数组 grid 和一个整数 k 。

你的任务是统计满足以下 条件 且从左上格子 (0, 0) 出发到达右下格子 (m - 1, n - 1) 的路径数目：

每一步你可以向右或者向下走，也就是如果格子存在的话，可以从格子 (i, j) 走到格子 (i, j + 1) 或者格子 (i + 1, j) 。
路径上经过的所有数字 XOR 异或值必须 等于 k 。
请你返回满足上述条件的路径总数。

由于答案可能很大，请你将答案对 109 + 7 取余 后返回。



示例 1：

输入：grid = [[2, 1, 5], [7, 10, 0], [12, 6, 4]], k = 11

输出：3

解释：

3 条路径分别为：

(0, 0) → (1, 0) → (2, 0) → (2, 1) → (2, 2)
(0, 0) → (1, 0) → (1, 1) → (1, 2) → (2, 2)
(0, 0) → (0, 1) → (1, 1) → (2, 1) → (2, 2)
示例 2：

输入：grid = [[1, 3, 3, 3], [0, 3, 3, 2], [3, 0, 1, 1]], k = 2

输出：5

解释：

5 条路径分别为：

(0, 0) → (1, 0) → (2, 0) → (2, 1) → (2, 2) → (2, 3)
(0, 0) → (1, 0) → (1, 1) → (2, 1) → (2, 2) → (2, 3)
(0, 0) → (1, 0) → (1, 1) → (1, 2) → (1, 3) → (2, 3)
(0, 0) → (0, 1) → (1, 1) → (1, 2) → (2, 2) → (2, 3)
(0, 0) → (0, 1) → (0, 2) → (1, 2) → (2, 2) → (2, 3)
示例 3：

输入：grid = [[1, 1, 1, 2], [3, 0, 3, 2], [3, 0, 2, 2]], k = 10

输出：0



提示：

1 <= m == grid.length <= 300
1 <= n == grid[r].length <= 300
0 <= grid[r][c] < 16
0 <= k < 16
https://leetcode.cn/problems/count-paths-with-the-given-xor-value/description/
 */
public class leetcode_3393 {
    public static void main(String[] args) {
        //[[2, 1, 5], [7, 10, 0], [12, 6, 4]], k = 11       3
        //[[1, 3, 3, 3], [0, 3, 3, 2], [3, 0, 1, 1]], k = 2       5
        //[[1, 1, 1, 2], [3, 0, 3, 2], [3, 0, 2, 2]], k = 10       0
        System.out.println(countPathsWithXorValue(new int[][]{{2, 1, 5}, {7, 10, 0}, {12, 6, 4}}, 11));
        System.out.println(countPathsWithXorValue(new int[][]{{1, 3, 3, 3}, {0, 3, 3, 2}, {3, 0, 1, 1}}, 2));
        System.out.println(countPathsWithXorValue(new int[][]{{1, 1, 1, 2}, {3, 0, 3, 2}, {3, 0, 2, 2}}, 10));
    }

    public static int countPathsWithXorValue(int[][] grid, int k) {
        /*
            0   0   0   0
            0   2   1   5
            0   7   10  0
            0   12  6   4

            需要用三维数组
            f[i][j][v] 表示（i，j）处 异或值为v的方案数
         */
        int MOD = 1_000_000_007;
        int max = 0, m = grid.length, n = grid[0].length;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, ints[j]);
            }
        }
        // 获取最大值 那么所有数据 异或后的结果也不会大于 最大值对于的二进制长度L  2的L次方 - 1
        int bitCount = 32 - Integer.numberOfLeadingZeros(max);
        max = 1 << bitCount;
        if (k >= max)
            return 0;
        int[][][] f = new int[m + 1][n + 1][max];
        f[0][1][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < max; l++) {
                    f[i + 1][j + 1][l] = (f[i + 1][j][l ^ grid[i][j]] + f[i][j + 1][l ^ grid[i][j]]) % MOD;
                }
            }
        }
        return f[m][n][k];
    }



    static final int MOD = 1_000_000_007;
    static final int D = 16;
    public int countPathsWithXorValue2(int[][] grid, int k) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][] dp = new int[COLS][D];
        int[][] dp0 = new int[COLS][D];
        {
            // 初始化第一行
            int[] vs = grid[0];
            int v = 0;
            for(int i=0; i<COLS; i++) {
                v ^= vs[i];
                dp[i][v] = 1;
            }
        }
        for(int i=1; i<ROWS; i++) {
            int[][] xx = dp; dp = dp0; dp0 = xx;//dp与dp0交换，dp一个是旧状态（i-1），dp0一个是当前状态（i）。
            int[] vs = grid[i];
            int v = vs[0];
            int[] dp00 = dp0[0];
            int[] dp10 = dp[0];
            //更新dp[0][D]
            for(int x=0; x<D; x++) {
                dp10[x] = dp00[x^v];
            }
            for(int col=1; col<COLS; col++) {
                v = vs[col];
                dp00 = dp0[col];//当前状态，考虑的是向右走使异或值达到ix
                dp10 = dp[col-1];//前一状态，考虑的是向下走使异或值达到ix
                int[] dp11 = dp[col];//dp11[x] 表示从起点到当前单元格 (i, col) 的所有路径中，异或结果为 x 的路径数量
                for(int x=0; x<D; x++) {
                    int ix = v^x;
                    dp11[x] = (dp10[ix] + dp00[ix])%MOD;//对dp11的更新会连带着更新dp
                }
            }
        }
        return dp[COLS-1][k];
    }
}
