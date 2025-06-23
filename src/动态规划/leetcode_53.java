package 动态规划;

import helper.Utils;

/*
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

子数组是数组中的一个连续部分。



示例 1：

输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
示例 2：

输入：nums = [1]
输出：1
示例 3：

输入：nums = [5,4,-1,7,8]
输出：23


提示：

1 <= nums.length <= 105
-104 <= nums[i] <= 104


进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
https://leetcode.cn/problems/maximum-subarray/description/
 */
public class leetcode_53 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));
        // 6    1  23
    }

    public static int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int curSum = 0;
        for(int num : nums){
            curSum += num;
            res = Math.max(curSum, res);
            if(curSum < 0){
                curSum = 0;
            }
        }
        return res;
    }

    public static int maxSubArray2(int[] nums) {
        int len = nums.length;
        int[] f = new int[len];
        f[0] = nums[0];
        int ans = f[0];
        for (int i = 1; i < len; i++) {
//            // 选当前值
//            f[i] = f[i - 1] + nums[i];
//            // 不选就是截断了 当前i为起点 之前的无关了
//            f[i] = nums[i];
            f[i] = Math.max(nums[i], f[i - 1] + nums[i]);
            ans = Math.max(f[i],ans);
        }
        return ans;
    }
}
