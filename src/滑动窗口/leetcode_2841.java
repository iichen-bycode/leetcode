package 滑动窗口;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
给你一个整数数组 nums 和两个正整数 m 和 k 。

请你返回 nums 中长度为 k 的 几乎唯一 子数组的 最大和 ，如果不存在几乎唯一子数组，请你返回 0 。

如果 nums 的一个子数组有至少 m 个互不相同的元素，我们称它是 几乎唯一 子数组。

子数组指的是一个数组中一段连续 非空 的元素序列。



示例 1：

输入：nums = [2,6,7,3,1,7], m = 3, k = 4
输出：18
解释：总共有 3 个长度为 k = 4 的几乎唯一子数组。分别为 [2, 6, 7, 3] ，[6, 7, 3, 1] 和 [7, 3, 1, 7] 。这些子数组中，和最大的是 [2, 6, 7, 3] ，和为 18 。
示例 2：

输入：nums = [5,9,9,2,4,5,4], m = 1, k = 3
输出：23
解释：总共有 5 个长度为 k = 3 的几乎唯一子数组。分别为 [5, 9, 9] ，[9, 9, 2] ，[9, 2, 4] ，[2, 4, 5] 和 [4, 5, 4] 。这些子数组中，和最大的是 [5, 9, 9] ，和为 23 。
示例 3：

输入：nums = [1,2,1,2,1,2,1], m = 3, k = 3
输出：0
解释：输入数组中不存在长度为 k = 3 的子数组含有至少  m = 3 个互不相同元素的子数组。所以不存在几乎唯一子数组，最大和为 0 。


提示：

1 <= nums.length <= 2 * 104
1 <= m <= k <= nums.length
1 <= nums[i] <= 109
https://leetcode.cn/problems/maximum-sum-of-almost-unique-subarray/description/
 */
public class leetcode_2841 {
    public static void main(String[] args) {
        System.out.println(maxSum(List.of(2, 6, 7, 3, 1, 7), 3, 4));   // 18
        System.out.println(maxSum(List.of(5, 9, 9, 2, 4, 5, 4), 1, 3)); // 23
        System.out.println(maxSum(List.of(1, 2, 1, 2, 1, 2, 1), 3, 3)); // 0
    }


    public static long maxSum(List<Integer> nums, int m, int k) {
        // 长度k  m个互不相同
        long ans = 0, count = 0;
        int num = 0;
        HashMap<Integer,Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            // 扩充窗口
            count += nums.get(i);
            if(!cache.containsKey(nums.get(i))) {
                cache.put(nums.get(i),1);
            } else {
                cache.put(nums.get(i),cache.get(nums.get(i)) + 1);
            }
            if (cache.get(nums.get(i)) == 1) {
                num++;
            }
            if (i < k - 1) {
                continue;
            }
            // 窗口大小等于k
            if (num >= m) {
                ans = Math.max(ans, count);
            }
            // 移动窗口
            cache.put(nums.get(i - k + 1),cache.get(nums.get(i - k + 1)) - 1);
            if (cache.get(nums.get(i - k + 1)) == 0) {
                num--;
            }
            count -= nums.get(i - k + 1);
        }
        return ans;
    }

}
