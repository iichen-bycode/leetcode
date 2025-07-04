package 滑动窗口;

import java.util.HashMap;
import java.util.List;

/*
给你一个整数数组 nums 和一个整数 k 。请你从 nums 中满足下述条件的全部子数组中找出最大子数组和：

子数组的长度是 k，且
子数组中的所有元素 各不相同 。
返回满足题面要求的最大子数组和。如果不存在子数组满足这些条件，返回 0 。

子数组 是数组中一段连续非空的元素序列。



示例 1：

输入：nums = [1,5,4,2,9,9,9], k = 3
输出：15
解释：nums 中长度为 3 的子数组是：
- [1,5,4] 满足全部条件，和为 10 。
- [5,4,2] 满足全部条件，和为 11 。
- [4,2,9] 满足全部条件，和为 15 。
- [2,9,9] 不满足全部条件，因为元素 9 出现重复。
- [9,9,9] 不满足全部条件，因为元素 9 出现重复。
因为 15 是满足全部条件的所有子数组中的最大子数组和，所以返回 15 。
示例 2：

输入：nums = [4,4,4], k = 3
输出：0
解释：nums 中长度为 3 的子数组是：
- [4,4,4] 不满足全部条件，因为元素 4 出现重复。
因为不存在满足全部条件的子数组，所以返回 0 。


提示：

1 <= k <= nums.length <= 105
1 <= nums[i] <= 105
https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
类似 2841
 */
public class leetcode_2461 {
    public static void main(String[] args) {
        System.out.println(maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
        System.out.println(maximumSubarraySum(new int[]{4, 4, 4}, 3));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        return maxSum(nums, k, k);
    }

    public static long maxSum(int[] nums, int m, int k) {
        int max = Integer.MIN_VALUE;
        for (int j : nums) {
            max = Math.max(max, j);
        }
        // 长度k  m个互不相同
        long ans = 0, count = 0;
        int num = 0;
        // 使用数组比使用map快
        int[] cache = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            // 扩充窗口
            count += nums[i];
            if (cache[nums[i]] == 0) {
                num++;
            }
            cache[nums[i]]++;
            if (i < k - 1) {
                continue;
            }
            // 窗口大小等于k
            if (num >= m) {
                ans = Math.max(ans, count);
            }
            // 移动窗口
            cache[nums[i - k + 1]]--;
            if (cache[nums[i - k + 1]] == 0) {
                num--;
            }
            count -= nums[i - k + 1];
        }
        return ans;
    }
}
