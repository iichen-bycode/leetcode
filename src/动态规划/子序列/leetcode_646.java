package 动态规划.子序列;

/*
给你一个由 n 个数对组成的数对数组 pairs ，其中 pairs[i] = [lefti, righti] 且 lefti < righti 。

现在，我们定义一种 跟随 关系，当且仅当 b < c 时，数对 p2 = [c, d] 才可以跟在 p1 = [a, b] 后面。我们用这种形式来构造 数对链 。

找出并返回能够形成的 最长数对链的长度 。

你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。



示例 1：

输入：pairs = [[1,2], [2,3], [3,4]]
输出：2
解释：最长的数对链是 [1,2] -> [3,4] 。
示例 2：

输入：pairs = [[1,2],[7,8],[4,5]]
输出：3
解释：最长的数对链是 [1,2] -> [4,5] -> [7,8] 。


提示：

n == pairs.length
1 <= n <= 1000
-1000 <= lefti < righti <= 1000
 */

import helper.Utils;

import java.util.Arrays;
import java.util.Comparator;

// 最长数对链 相比300、673 这里是无序的  如：[[1,2],[7,8],[4,5]]   [4,5]可以在[1,2],[7,8]之间
public class leetcode_646 {
    public static void main(String[] args) {
//        System.out.println(findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
//        System.out.println(findLongestChain(new int[][]{{1, 2}, {4, 5}, {7, 8}}));
//        System.out.println(findLongestChain(new int[][]{{1, 2}, {7, 8}, {4, 5}}));
        // [-6,9],[1,6],[8,10],[-1,4],[-6,-2],[-9,8],[-5,3],[0,3]
        System.out.println(findLongestChain(new int[][]{{-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3}, {0, 3}}));
    }

    // 贪心
    public static int findLongestChain(int[][] pairs) {
        int ans = 0, cur = Integer.MIN_VALUE;
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
//        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        Utils.print2(pairs);
        for (int[] a : pairs) {
            if (a[0] > cur) {
                cur = a[1];
                ans++;
            }
        }
        return ans;
    }

    // 动态规划
    public static int findLongestChain2(int[][] pairs) {
        int len = pairs.length;
        int ans = 0;
        int[] f = new int[len];
        // 排序后 就和300 673一样了
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < len; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}












