package 动态规划;

/*
给定一个 m x n 的整数数组 grid。一个机器人初始位于 左上角（即 grid[0][0]）。机器人尝试移动到 右下角（即 grid[m - 1][n - 1]）。机器人每次只能向下或者向右移动一步。

网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。

返回机器人能够到达右下角的不同路径数量。

测试用例保证答案小于等于 2 * 109。



示例 1：


输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
输出：2
解释：3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
示例 2：


输入：obstacleGrid = [[0,1],[0,0]]
输出：1


提示：

m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] 为 0 或 1

https://leetcode.cn/problems/unique-paths-ii/description/
 */
public class leetcode_63 {
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int[] f = new int[n + 1];
        /*
            0   0   0   0
            0   0   0   0
            0   0   1   0
            0   0   0   0

            滚动数组如下：
            0   1   0   0

            0   1   1   1
            0   1   0   1
            0   1   1   2
         */
        f[1] = 1;
        for (int[] ints : obstacleGrid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] != 1) {
                    f[j + 1] += f[j];
                } else { // 注意是障碍物是 置为0 否则上一轮的结果会导致错误的结果
                    f[j + 1] = 0;
                }
            }
        }
        return f[n];
    }

    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m + 1][n + 1];
        /*
            0   0   0   0
            0   0   0   0
            0   0   1   0
            0   0   0   0
         */
        f[0][1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    f[i + 1][j + 1] = f[i + 1][j] + f[i][j + 1];
                }
            }
        }
        return f[m][n];
    }
}
