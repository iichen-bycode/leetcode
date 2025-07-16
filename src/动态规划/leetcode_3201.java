package 动态规划;
/*
给你一个整数数组 nums。

nums 的子序列 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列：

(sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2
返回 nums 的 最长的有效子序列 的长度。

一个 子序列 指的是从原数组中删除一些元素（也可以不删除任何元素），剩余元素保持原来顺序组成的新数组。



示例 1：

输入： nums = [1,2,3,4]

输出： 4

解释：

最长的有效子序列是 [1, 2, 3, 4]。

示例 2：

输入： nums = [1,2,1,1,2,1,2]

输出： 6

解释：

最长的有效子序列是 [1, 2, 1, 2, 1, 2]。

示例 3：

输入： nums = [1,3]

输出： 2

解释：

最长的有效子序列是 [1, 3]。



提示：

2 <= nums.length <= 2 * 105
1 <= nums[i] <= 107
 */

import helper.Utils;

// 找出有效子序列的最大长度 I
public class leetcode_3201 {
    public static void main(String[] args) {
        System.out.println(maximumLength(new int[]{1, 2, 3, 4}));
        /*
                        1
              2         3       4
           3    4       4
           4

         */
        System.out.println(maximumLength(new int[]{1, 2, 1, 1, 2, 1, 2}));
        System.out.println(maximumLength(new int[]{1, 3}));
    }

    public static int maximumLength(int[] nums) {
        int n = nums.length;
        return n;
    }

    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int res = 0;
        for (int num : nums) {
            // 每个元素的 mod
            /*
                1   2   3   4
                num = 2，i = 1:
             */
            num %= k;
            for (int prev = 0; prev < k; prev++) {
                dp[prev][num] = dp[num][prev] + 1;
                res = Math.max(res, dp[prev][num]);
            }
        }
        return res;
    }
}


















