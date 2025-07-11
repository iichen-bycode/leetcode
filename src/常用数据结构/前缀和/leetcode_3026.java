package 常用数据结构.前缀和;
/*
给你一个长度为 n 的数组 nums 和一个 正 整数 k 。

如果 nums 的一个子数组中，第一个元素和最后一个元素 差的绝对值恰好 为 k ，我们称这个子数组为 好 的。换句话说，如果子数组 nums[i..j] 满足 |nums[i] - nums[j]| == k ，那么它是一个好子数组。

请你返回 nums 中 好 子数组的 最大 和，如果没有好子数组，返回 0 。



示例 1：

输入：nums = [1,2,3,4,5,6], k = 1
输出：11
解释：好子数组中第一个元素和最后一个元素的差的绝对值必须为 1 。好子数组有 [1,2] ，[2,3] ，[3,4] ，[4,5] 和 [5,6] 。最大子数组和为 11 ，对应的子数组为 [5,6] 。
示例 2：

输入：nums = [-1,3,2,4,5], k = 3
输出：11
解释：好子数组中第一个元素和最后一个元素的差的绝对值必须为 3 。好子数组有 [-1,3,2] 和 [2,4,5] 。最大子数组和为 11 ，对应的子数组为 [2,4,5] 。
示例 3：

输入：nums = [-1,-2,-3,-4], k = 2
输出：-6
解释：好子数组中第一个元素和最后一个元素的差的绝对值必须为 2 。好子数组有 [-1,-2,-3] 和 [-2,-3,-4] 。最大子数组和为 -6 ，对应的子数组为 [-1,-2,-3] 。


提示：

2 <= nums.length <= 105
-109 <= nums[i] <= 109
1 <= k <= 109
 */

import java.util.HashMap;
import java.util.Map;

// 最大好子数组和
public class leetcode_3026 {
    public static void main(String[] args) {
        System.out.println(maximumSubarraySum(new int[]{1, 2, 3, 4, 5, 6}, 1));//11
        System.out.println(maximumSubarraySum(new int[]{-1, 3, 2, 4, 5}, 3));//11
        System.out.println(maximumSubarraySum(new int[]{-1, -2, -3, -4}, 2));//-6
        System.out.println(maximumSubarraySum(new int[]{-8, 4, 3, -8}, 4));//0
        System.out.println(maximumSubarraySum(new int[]{1, 1, 4}, 2));//0
        System.out.println(maximumSubarraySum(new int[]{-636, -784, -356, -832, -797, -978, -651, -667, -907, -900, -168, -697, -879, -998, -126, -900, -542, -553, -268, -374, -710, -768, -727, -975, -106, -756, -462, -815, -276, -163, -301, -822, -367, -685, -581, -488, -763, -612, -847, -730, -479, -874, -221, -912, -229, -543, -876, -845, -424, -215, -819, -164, -840, -525, -987, -291, -658, -168, -382, -781, -951, -396, -228, -394, -445, -863, -290, -675, -289, -950, -885,
                -228, -624, -236, -437, -246, -302, -741, -243, -419, -851, -980, -667, -661, -140, -893, -328, -354, -359, -845, -396, -309, -450, -941, -310, -119, -614, -854, -599, -605}, 8));//0
        /*

         */
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        Map<Integer, Long> map = new HashMap<>();
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int a = nums[i] - k;
            int b = nums[i] + k;
            if (map.containsKey(a)) {
                max = Math.max(max, sum[i + 1] - map.get(a));
            }
            if (map.containsKey(b)) {
                max = Math.max(max, sum[i + 1] - map.get(b));
            }
            long x = map.getOrDefault(nums[i], Long.MAX_VALUE);
            // 相同的值 记录最小的和 这样可以获得最大期望
            map.put(nums[i], Math.min(x, sum[i]));
        }
        return max == Long.MIN_VALUE ? 0 : max;
    }
}
