package 滑动窗口;

import java.util.Arrays;

/*
给定一个含有 n 个正整数的数组和一个正整数 target 。

找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。



示例 1：

输入：target = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。
示例 2：

输入：target = 4, nums = [1,4,4]
输出：1
示例 3：

输入：target = 11, nums = [1,1,1,1,1,1,1,1]
输出：0


提示：

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104


进阶：

如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
https://leetcode.cn/problems/minimum-size-subarray-sum/
 */
public class leetcode_209 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        //  0 2  5  6  8  12 15
        //  0 1  2   3 4  5  6
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }

    // 二分 + 前缀和实现
    public static int minSubArrayLen(int target, int[] nums) {
        // sum[j] - sum[i] >= k ,则 j - i
        /*
        int length = nums.length;
        int min = Integer.MAX_VALUE;
        int[] sums = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i <= length; i++) {
            int target = s + sums[i];
            int index = Arrays.binarySearch(sums, target);
            if (index < 0)
                index = ~index;
            if (index <= length) {
                min = Math.min(min, index - i);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
         */
        int len = nums.length, ans = Integer.MAX_VALUE;
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 0; i <= len; i++) {
            int t = sum[i] + target;
            int index = Arrays.binarySearch(sum, t);  // return -(low + 1);  // key not found.
            if (index < 0) {
                index = -index - 1;// ~index
            }
            if (index <= len) {
                ans = Math.min(ans, index - i);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // 滑动窗口
    public static int minSubArrayLen2(int target, int[] nums) {
        int len = nums.length, l = 0, ans = Integer.MAX_VALUE, count = 0;
        for (int i = 0; i < len; i++) {
            count += nums[i];
            while (count >= target) {
                ans = Math.min(ans, i - l + 1);
                count -= nums[l++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
