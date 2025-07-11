package 常用数据结构.前缀和;

/*
给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。

子数组是数组中元素的连续非空序列。



示例 1：

输入：nums = [1,1,1], k = 2
输出：2
示例 2：

输入：nums = [1,2,3], k = 3
输出：2


提示：

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
 */

import java.util.HashMap;

// 和为 K 的子数组
public class leetcode_560 {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        /*
            1   2   3
            0:1
            1:1
            2:1
            3:1
         */
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
        /*
            1   3   6
         */
    }

    public static int subarraySum(int[] nums, int k) {
            /*
                k - nums[j]
             */
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0, count = 0;
        for (int num : nums) {
            count += num;
            if (map.containsKey(count - k)) {
                ans++;
            }
            map.put(count, map.getOrDefault(count, 0) + 1);
        }
        return ans;
    }
}
