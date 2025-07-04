package 滑动窗口;

/*
给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。

请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。

任何误差小于 10-5 的答案都将被视为正确答案。



示例 1：

输入：nums = [1,12,-5,-6,50,3], k = 4
输出：12.75
解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
示例 2：

输入：nums = [5], k = 1
输出：5.00000


提示：

n == nums.length
1 <= k <= n <= 105
-104 <= nums[i] <= 104
 */
public class leetcode_643 {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
        System.out.println(findMaxAverage(new int[]{5},1));
        System.out.println(findMaxAverage(new int[]{-1},1));

        System.out.println(findMaxAverage2(new int[]{1,12,-5,-6,50,3},4));
        System.out.println(findMaxAverage2(new int[]{5},1));
        System.out.println(findMaxAverage2(new int[]{-1},1));
    }

    public static double findMaxAverage2(int[] nums, int k) {
        int cur = 0,max = Integer.MIN_VALUE;
        int l = 0,r = 0;
        while (r < nums.length) {
            cur += nums[r];
            while (r - l >= k - 1) {
                max = Math.max(max,cur);
                cur -= nums[l];
                l++;
            }
            r++;
        }
        return (double) max / k;
    }
    public static double findMaxAverage(int[] nums, int k) {
        int cur = 0,max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            if(i < k - 1)
                continue;
            max = Math.max(max,cur);
            cur -= nums[i - k + 1];
        }
        return (double) max / k;
    }
}
