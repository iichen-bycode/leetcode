package 常用数据结构.枚举技巧;

import helper.Utils;

import java.util.Arrays;

/*
给你一个下标从 0 开始的整数数组 nums 。

如果下标三元组 (i, j, k) 满足下述全部条件，则认为它是一个 山形三元组 ：

i < j < k
nums[i] < nums[j] 且 nums[k] < nums[j]
请你找出 nums 中 元素和最小 的山形三元组，并返回其 元素和 。如果不存在满足条件的三元组，返回 -1 。



示例 1：

输入：nums = [8,6,1,5,3]
输出：9
解释：三元组 (2, 3, 4) 是一个元素和等于 9 的山形三元组，因为：
- 2 < 3 < 4
- nums[2] < nums[3] 且 nums[4] < nums[3]
这个三元组的元素和等于 nums[2] + nums[3] + nums[4] = 9 。可以证明不存在元素和小于 9 的山形三元组。
示例 2：

输入：nums = [5,4,8,7,10,2]
输出：13
解释：三元组 (1, 3, 5) 是一个元素和等于 13 的山形三元组，因为：
- 1 < 3 < 5
- nums[1] < nums[3] 且 nums[5] < nums[3]
这个三元组的元素和等于 nums[1] + nums[3] + nums[5] = 13 。可以证明不存在元素和小于 13 的山形三元组。
示例 3：

输入：nums = [6,5,4,3,4,5]
输出：-1
解释：可以证明 nums 中不存在山形三元组。


提示：

3 <= nums.length <= 105
1 <= nums[i] <= 108

https://leetcode.cn/problems/minimum-sum-of-mountain-triplets-ii/description/
 */
public class leetcode_2909 {
    public static void main(String[] args) {
        System.out.println(minimumSum(new int[]{8, 6, 1, 5, 3}));
        System.out.println(minimumSum(new int[]{5, 4, 8, 7, 10, 2}));
        System.out.println(minimumSum(new int[]{6, 5, 4, 3, 4, 5}));
    }

    public static int minimumSum(int[] nums) {
        // 两次 单变量   minimumSum2是获取右侧最小值。
        /*
            可以先i<j 来获取所有满足的 并记录和

            在从右往左 j<k 在满足 num[j] > num[k]下  判断 上诉记录的和是否包含当前下标 j包含则 表明满足条件 ans更新
         */
        int len = nums.length, l = Integer.MAX_VALUE, r = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;
        int[] f = new int[len];
        Arrays.fill(f, -1);
        for (int i = 0; i < len; i++) {
            if (nums[i] > l) {
                f[i] = nums[i] + l;
            }
            l = Math.min(l, nums[i]);
        }
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] > r && f[i] != -1) {
                ans = Math.min(ans, f[i] + r);
            }
            r = Math.min(r, nums[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int minimumSum2(int[] nums) {
        // 先确定后缀 j到k的最小值
        /*
            任意 下标i 到 n-1之间的最小值
            f[i] 表示 i右边的最小值
            f[i] = min(nums[i],f[i+1])
         */
        int len = nums.length, ans = Integer.MAX_VALUE, l = Integer.MAX_VALUE;
        int[] suffix = new int[len];
        suffix[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            suffix[i] = Math.min(nums[i], suffix[i + 1]);
        }
        // 第一个元素和最后一个无意义
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > l && nums[i] > suffix[i + 1]) {
                ans = Math.min(ans, l + nums[i] + suffix[i + 1]);
            }
            l = Math.min(l, nums[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
