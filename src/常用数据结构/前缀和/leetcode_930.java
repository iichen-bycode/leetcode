package 常用数据结构.前缀和;

import helper.Utils;

/*
给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。

子数组 是数组的一段连续部分。



示例 1：

输入：nums = [1,0,1,0,1], goal = 2
输出：4
解释：
有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
示例 2：

输入：nums = [0,0,0,0,0], goal = 0
输出：15


提示：

1 <= nums.length <= 3 * 104
nums[i] 不是 0 就是 1
0 <= goal <= nums.length
https://leetcode.cn/problems/binary-subarrays-with-sum/
 */
public class leetcode_930 {
    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        /* 0 1 2 3 4 5
           0 1 1 2 2 3
         */
        System.out.println(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
    }

    /*
        恰好型滑动窗口
     */
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return 0;
    }

    public static int numSubarraysWithSum2(int[] nums, int goal) {
        int[] f = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            f[i + 1] = nums[i] + f[i];
        }
        int ans = 0;
        for (int i = 0; i < f.length; i++) {
            for (int j = i + 1; j < f.length; j++) {
                if (f[j] - f[i] == goal) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
