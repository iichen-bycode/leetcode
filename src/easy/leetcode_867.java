package easy;

/*
给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。

矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。





示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[[1,4,7],[2,5,8],[3,6,9]]
示例 2：

输入：matrix = [[1,2,3],[4,5,6]]
输出：[[1,4],[2,5],[3,6]]


提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 1000
1 <= m * n <= 105
-109 <= matrix[i][j] <= 109
 */

public class leetcode_867 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{new int[]{1,2,3},new int[]{4,5,6},new int[]{7,8,9}};
        int [][]res = transpose(matrix);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }
    public static int[][] transpose(int[][] matrix) {
        int a = matrix.length;
        int b = matrix[0].length;
        int [][]res = new int[b][a];
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                res[i][j] = matrix[j][i];
            }
        }
        return res;
    }
}
