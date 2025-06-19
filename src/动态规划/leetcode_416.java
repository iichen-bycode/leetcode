package 动态规划;

import java.util.Arrays;

/*
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。



示例 1：

输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
示例 2：

输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。


提示：

1 <= nums.length <= 200
1 <= nums[i] <= 100
https://leetcode.cn/problems/partition-equal-subset-sum/description/
 */
public class leetcode_416 {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(canPartition(new int[]{2, 2, 1, 1}));
        // 21 27
    }

    public static boolean canPartition(int[] nums) {
        /*
         * 由题解 分成两部分 x y 即 x + y = count(nums) 若count(nums) % 2 == 0 可以分成继续后续逻辑
         * 找出nums是否符合的组合 否则不可以 直接返回false
         *
         * 最终： 从nums中找出是否有 和target 为 nums/2
         *
         * weight和value数组都是 nums,
         *
         * 1、最值问题: dp[i] = max/min(dp[i], dp[i-nums]+1)或dp[i] = max/min(dp[i],
         * dp[i-num]+nums); 2、存在问题(bool)：dp[i]=dp[i]||dp[i-num];
         * 3、组合问题：dp[i]+=dp[i-num];
         */
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            // 背包容量为target可以选的 num
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }
}
