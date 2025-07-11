package 常用数据结构.前缀和;
/*
给你一个整数数组 arr 。请你返回和为 奇数 的子数组数目。

由于答案可能会很大，请你将结果对 10^9 + 7 取余后返回。



示例 1：

输入：arr = [1,3,5]
输出：4
解释：所有的子数组为 [[1],[1,3],[1,3,5],[3],[3,5],[5]] 。
所有子数组的和为 [1,4,9,3,8,5].
奇数和包括 [1,9,3,5] ，所以答案为 4 。
示例 2 ：

输入：arr = [2,4,6]
输出：0
解释：所有子数组为 [[2],[2,4],[2,4,6],[4],[4,6],[6]] 。
所有子数组和为 [2,6,12,4,10,6] 。
所有子数组和都是偶数，所以答案为 0 。
示例 3：

输入：arr = [1,2,3,4,5,6,7]
输出：16
示例 4：

输入：arr = [100,100,99,99]
输出：4
示例 5：

输入：arr = [7]
输出：1


提示：

1 <= arr.length <= 10^5
1 <= arr[i] <= 100
 */

import helper.Utils;

// 和为奇数的子数组数目
public class leetcode_1524 {
    public static void main(String[] args) {
        System.out.println(numOfSubarrays(new int[]{1, 3, 5}));
        System.out.println(numOfSubarrays(new int[]{2, 4, 6}));
        System.out.println(numOfSubarrays(new int[]{1, 2, 3, 4, 5, 6, 7})); // 16
        /*
            0 1 3 6 10 15 21 28
            看左边
            1   1
            3   1
            6   2
            10  2
            15  3
            21  3
            28  4

            看右边
            0   4
            1   3
            3   3
            6   2
            10  2
            15  1
            21  1
         */
        System.out.println(numOfSubarrays(new int[]{100, 100, 99, 99}));
        System.out.println(numOfSubarrays(new int[]{7}));
    }

    public static int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int odd = 0, even = 1; // 由于初始为0，所以初始奇数个数为0，偶数个数为1
        int sum = 0;
        int ans = 0;
        for (int num : arr) {
            sum += num;
            ans = (ans + (sum % 2 == 0 ? odd : even)) % MOD;
            if (sum % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return ans;
    }

    public static int numOfSubarrays2(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;
        int[] f = new int[n + 1];
        // 偶数个数
        long evenNum = 1;
        for (int i = 0; i < n; i++) {
            f[i + 1] = f[i] + arr[i];
            if (f[i + 1] % 2 == 0) {
                evenNum++;
            }
        }
        long ans = 0;
        long oddNum = n + 1 - evenNum;
        Utils.print(f);
        for (int i = 0; i < f.length; i++) {
            if (i == 0) {
                ans = (ans + oddNum) % MOD;
                evenNum--;
            } else {
                if (f[i] % 2 == 0) {
                    ans = (ans + oddNum) % MOD;
                    --evenNum;
                } else {
                    ans = (ans + evenNum) % MOD;
                    --oddNum;
                }
            }
        }
        return (int) ans;
    }
}
