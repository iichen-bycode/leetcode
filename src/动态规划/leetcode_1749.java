package 动态规划;

/*
给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。

请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。

abs(x) 定义如下：

如果 x 是负整数，那么 abs(x) = -x 。
如果 x 是非负整数，那么 abs(x) = x 。


示例 1：

输入：nums = [1,-3,2,3,-4]
输出：5
解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
示例 2：

输入：nums = [2,-5,1,-4,3,-2]
输出：8
解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。


提示：

1 <= nums.length <= 105
-104 <= nums[i] <= 104

https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/
 */
public class leetcode_1749 {
    public static void main(String[] args) {
        System.out.println(maxAbsoluteSum(new int[]{1, -3, 2, 3, -4})); //5
        System.out.println(maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2}));//8
        System.out.println(maxAbsoluteSum(new int[]{-7, -1, 0, -2, 1, 3, 8, -2, -6, -1, -10, -6, -6, 8, -4, -9, -4, 1, 4, -9}));//44
        // 0 -7 -8 -8 -10 -9 -6 2 0 -6 -7 -17 -23 -29 -21 -25 -34 -38 -37 -33 -42
    }

    // 最大子数组和最小子数组 最大值 就是答案
    public static int maxAbsoluteSum(int[] nums) {
        int min = 0, max = 0, ans = 0;
        for (int num : nums) {
            min = Math.min(min + num, num);
            max = Math.max(max + num, num);
            ans = Math.max(ans, Math.max(max, -min));
        }
        return ans;
    }


    public static int maxAbsoluteSum2(int[] nums) {
        // 前缀和
        int len = nums.length;
        int[] f = new int[len + 1];
        for (int i = 0; i < len; i++) {
            f[i + 1] = f[i] + nums[i];
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < len + 1; i++) {
            min = Math.min(min, f[i]);
            max = Math.max(max, f[i]);
        }
        return max - min;
    }
}
