package 常用数据结构.枚举技巧;

import java.util.HashSet;

/*
给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。

返回正整数 k ，如果不存在这样的整数，返回 -1 。



示例 1：

输入：nums = [-1,2,-3,3]
输出：3
解释：3 是数组中唯一一个满足题目要求的 k 。
示例 2：

输入：nums = [-1,10,6,7,-7,1]
输出：7
解释：数组中存在 1 和 7 对应的负数，7 的值更大。
示例 3：

输入：nums = [-10,8,6,7,-2,-3]
输出：-1
解释：不存在满足题目要求的 k ，返回 -1 。


提示：

1 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
nums[i] != 0
https://leetcode.cn/problems/largest-positive-integer-that-exists-with-its-negative/description/
 */
public class leetcode_2441 {
    public static void main(String[] args) {
        System.out.println(findMaxK(new int[]{-1, 2, -3, 3}));
        System.out.println(findMaxK(new int[]{-1, 10, 6, 7, -7, 1}));
        System.out.println(findMaxK(new int[]{-10, 8, 6, 7, -2, -3}));
    }

    public static int findMaxK(int[] nums) {
        // 数据量小 进行直接数组范围覆盖
        /*
            1 <= nums.length <= 1000
            -1000 <= nums[i] <= 1000
         */
        // 覆盖所有值的范围的数组
        boolean[] f = new boolean[2001];
        for (int num : nums) {
            // 值小于0 需要转为 > 0
            f[num + 1000] = true;
        }
        // 从大到小 若存在则为结果
        for (int i = 1000; i >= 0; i--) {
            if (f[i + 1000] && f[-i + 1000]) {
                return i;
            }
        }
        return -1;
    }

    public static int findMaxK2(int[] nums) {
        int ans = -1;
        HashSet<Integer> set = new HashSet<>();
        for (int cur : nums) {
            if (set.contains(-cur)) {
                ans = Math.max(Math.abs(cur), ans);
                set.remove(-cur);
            }
            set.add(cur);
        }
        return ans;
    }
}
