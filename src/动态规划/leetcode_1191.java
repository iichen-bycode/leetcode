package 动态规划;

import helper.Utils;

/*
给定一个整数数组 arr 和一个整数 k ，通过重复 k 次来修改数组。

例如，如果 arr = [1, 2] ， k = 3 ，那么修改后的数组将是 [1, 2, 1, 2, 1, 2] 。

返回修改后的数组中的最大的子数组之和。注意，子数组长度可以是 0，在这种情况下它的总和也是 0。

由于 结果可能会很大，需要返回的 109 + 7 的 模 。



示例 1：

输入：arr = [1,2], k = 3
输出：9
示例 2：

输入：arr = [1,-2,1], k = 5
输出：2
示例 3：

输入：arr = [-1,-2], k = 7
输出：0


提示：

1 <= arr.length <= 105
1 <= k <= 105
-104 <= arr[i] <= 104
https://leetcode.cn/problems/k-concatenation-maximum-sum/
 */
public class leetcode_1191 {
    public static void main(String[] args) {
        /*
        输入：arr = [1,2], k = 3
        输出：9
        1 2 1 2 1 2


        输入：arr = [1,-2,1], k = 5
        输出：2
        1 -2 1 1 -2 1 1 -2 1 1 -2 1 1 -2 1

        输入：arr = [-1,-2], k = 7
        输出：0
        -1 -2 -1 -2
         */
        System.out.println(kConcatenationMaxSum(new int[]{1, 2}, 3));
        System.out.println(kConcatenationMaxSum(new int[]{1, -2, 1}, 5));
        System.out.println(kConcatenationMaxSum(new int[]{-1, -2}, 7));
        System.out.println(kConcatenationMaxSum(new int[]{10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000}, 100000));
        // 999999937
    }

    // 会超时 需要数学证明使用其他方法
    public static int kConcatenationMaxSum(int[] arr, int k) {
        int MOD = 1_000_000_007;
        long sum = 0,ans = 0;
        int n = arr.length, len = k * n;
        for (int i = 0; i < len; i++) {
            int cur = arr[i % n];
            sum = Math.max((sum + cur), cur);
//            if(ans < 1000000000) {
//                System.out.println(">>>>>>>> sum " + sum + "<> " + ans);
//            }
            ans = Math.max(sum, ans) % MOD;
        }
//        System.out.println(">>>>>>>>>>>>>>>>>>>");
        return (int) ans;
    }

}
