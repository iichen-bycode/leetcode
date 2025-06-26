package 常用数据结构.枚举技巧;

import helper.Utils;

import java.util.Arrays;

/*
给你一个二维 boolean 矩阵 grid 。

如果 grid 的 3 个元素的集合中，一个元素与另一个元素在 同一行，并且与第三个元素在 同一列，则该集合是一个 直角三角形。3 个元素 不必 彼此相邻。

请你返回使用 grid 中的 3 个元素可以构建的 直角三角形 数目，且满足 3 个元素值 都 为 1 。



示例 1：

0	1	0
0	1	1
0	1	0
0	1	0
0	1	1
0	1	0
输入：grid = [[0,1,0],[0,1,1],[0,1,0]]

输出：2

解释：

有 2 个值为 1 的直角三角形。注意蓝色的那个 没有 组成直角三角形，因为 3 个元素在同一列。

示例 2：

1	0	0	0
0	1	0	1
1	0	0	0
输入：grid = [[1,0,0,0],[0,1,0,1],[1,0,0,0]]

输出：0

解释：

没有值为 1 的直角三角形。注意蓝色的那个 没有 组成直角三角形。

示例 3：

1	0	1
1	0	0
1	0	0

1	0	1
1	0	0
1	0	0
输入：grid = [[1,0,1],[1,0,0],[1,0,0]]

输出：2

解释：

有两个值为 1 的直角三角形。



提示：

1 <= grid.length <= 1000
1 <= grid[i].length <= 1000
0 <= grid[i][j] <= 1

https://leetcode.cn/problems/right-triangles/description/
 */
public class leetcode_3128 {
    public static void main(String[] args) {
        // [0,1,0],[0,1,1],[0,1,0] 2
//        System.out.println(numberOfRightTriangles(new int[][]{{0, 1, 0}, {0, 1, 1}, {0, 1, 0}}));
//        // [1,0,0,0],[0,1,0,1],[1,0,0,0] 0
//        System.out.println(numberOfRightTriangles(new int[][]{{1, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}}));
//        // [1,0,1],[1,0,0],[1,0,0] 2
//        System.out.println(numberOfRightTriangles(new int[][]{{1, 0, 1}, {1, 0, 0}, {1, 0, 0}}));
        // [1,1],[1,0],[0,1]    2
        System.out.println(numberOfRightTriangles(new int[][]{{1, 1}, {1, 0}, {0, 1}}));
    }

    public static long numberOfRightTriangles(int[][] grid) {
        /*
            1   1
            1   0
            0   1
         */
        int n = grid[0].length;
        int[] colSum = new int[n];
        Arrays.fill(colSum, -1); // 提前减一
        for (int[] row : grid) {
            for (int j = 0; j < n; j++) {
                colSum[j] += row[j];
            }
        }
        long ans = 0;
        for (int[] row : grid) {
            int rowSum = -1; // 提前减一
            for (int x : row) {
                rowSum += x;
            }
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1) {
                    ans += rowSum * colSum[j];
                }
            }
        }
        return ans;
    }

    public static long numberOfRightTriangles2(int[][] grid) {
        /*
                   x
               x   x   x
                   x

                         i-1,j
                i.j-1     i,j


                           i-1,j
                            i,j     i,j+1


                i-1,j-1    i-1,j
                            i,j


                            i-1,j   i-1,j+1
                             i,j
         */

        /*
        1	0	1
        1	0	0
        1	0	0
        
        1	0	1
        1	0	0
        1	0	0
        输入：grid = [[1,0,1],[1,0,0],[1,0,0]]
        
        任意(i,j) 判断当前行 左右侧 1的数量 以及上下侧的数量
                2
            3       5
                4
              3*4 + 4*5 + 2*5 + 2*3 = （3+5）*（2+4）
         */
        /*
        0	1	0
        0	1	1
        0	1	0
         */
        int m = grid.length; // 3
        int n = grid[0].length; // 4
        int[][][] f = new int[m][n][4];
        int l = 0, r = n - 1, t = 0, b = m - 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    while (l < j) {
                        if (grid[i][l] == 1) {
                            f[i][j][0] += 1;
                        }
                        l++;
                    }
                    while (r > j) {
                        if (grid[i][r] == 1) {
                            f[i][j][2] += 1;
                        }
                        r--;
                    }
                    while (t < i) {
                        if (grid[t][j] == 1) {
                            f[i][j][1] += 1;
                        }
                        t++;
                    }
                    while (b > i) {
                        if (grid[b][j] == 1) {
                            f[i][j][3] += 1;
                        }
                        b--;
                    }
                }
                l = 0;
                r = n - 1;
                t = 0;
                b = m - 1;
            }
        }
        /*
            1   0   0   0
            0   1   0   1
            1   0   0   0

            1   1
            1   0
            0   1
         */
        int ans = 0;
        for (int[][] ints : f) {
            for (int[] anInt : ints) {
                ans += (anInt[0] + anInt[2]) * (anInt[1] + anInt[3]);
//                System.out.print((anInt[0] + anInt[2]) * (anInt[1] + anInt[3]) + "#" + String.valueOf(anInt[0] * 1000 + anInt[1] * 100 + anInt[2] * 10 + anInt[3]) + "  ");
            }
//            System.out.println();
        }
        return ans;
    }
}
