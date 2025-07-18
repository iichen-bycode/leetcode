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
            ans = Math.max(sum, ans) % MOD;
        }
        return (int) ans;
    }

    class Solution {

        /**
         * 计算k次连接数组后的最大子数组和
         *
         * k次串联=环形子数组
         *
         * @param arr 输入数组
         * @param k 数组连接次数
         * @return 最大子数组和对MOD取模的结果
         */
        public static int kConcatenationMaxSum(int[] arr, int k) {
            // 模数常量，用于结果取模
            final int MOD = 1000000007;

            // 当前连续子数组和
            long preResult = 0;

            // k==1时，全局最大子数组和
            long result = 0;

            // 第一遍遍历：处理 k=1 的情况（原始数组）
            for (int value : arr) {
                // Kadane算法核心：决定是重新开始子数组还是延续当前子数组
                preResult = Math.max(value, preResult + value);
                // 更新全局最大值
                result = Math.max(result, preResult);
            }

            // 如果只需要处理原始数组(k=1)，直接返回结果
            if (k == 1) {
                return (int) (result % MOD);
            }

            // 第二遍遍历：处理k=2的情况（数组连接两次）
            long result2 = 0;
            for (int value : arr) {
                preResult = Math.max(value, preResult + value);
                result2 = Math.max(result2, preResult);
            }

            // 如果连接两次没有比连接一次获得更大和，返回 k=1 的结果
            if (result2 - result <= 0) {
                return (int) (result % MOD);
            }

            // 如果只需要处理 k=2 的情况，直接返回结果
            if (k == 2) {
                return (int) (result2 % MOD);
            }

            // 第三遍遍历：处理k=3的情况（数组连接三次）
            long result3 = 0;
            for (int value : arr) {
                preResult = Math.max(value, preResult + value);
                result3 = Math.max(result3, preResult);
            }

            // 如果连接三次没有比连接两次获得更大和，返回k=2的结果
            if (result3 - result2 <= 0) {
                return (int) (result2 % MOD);
            }

            // 处理k>3的情况：基于观察到的模式进行结果推算
            // 处理大k值时的整数溢出
            long diff = result3 - result2;
            long increment = diff * (k - 2) % MOD; // 改为k-2更符合数学关系
            return (int) ((result2 + increment) % MOD);
        }
    }
}
