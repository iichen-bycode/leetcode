package 滑动窗口;

/*
给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。


示例 1：

输入：nums = [10,5,2,6], k = 100
输出：8
解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2]、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
示例 2：

输入：nums = [1,2,3], k = 0
输出：0


提示:

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106

https://leetcode.cn/problems/subarray-product-less-than-k/
 */
public class leetcode_713 {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0, count = 1, len = nums.length, l = 0;
        for (int i = 0; i < len; i++) {
            count *= nums[i];
            while (l <= i && count >= k) {
                count /= nums[l++];
            }
            ans += i - l + 1;
        }
        return ans;
    }
}
