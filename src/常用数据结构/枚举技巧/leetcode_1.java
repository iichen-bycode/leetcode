package 常用数据结构.枚举技巧;

import helper.Utils;

import java.util.HashMap;

/*
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。

你可以按任意顺序返回答案。



示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：

输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：

输入：nums = [3,3], target = 6
输出：[0,1]


提示：

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
只会存在一个有效答案


进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
https://leetcode.cn/problems/two-sum/description/
 */
public class leetcode_1 {
    public static void main(String[] args) {
        int[] a = twoSum(new int[]{2, 7, 11, 15}, 9);
        // 0 2 9 20 35
        Utils.print(a);

        int[] a2 = twoSum(new int[]{3, 3}, 6);
        Utils.print(a2);

        int[] a1 = twoSum(new int[]{3, 2, 4}, 6);
        // 0 3 5 9
        Utils.print(a1);

    }

    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int t = target - nums[i];
            if (map.containsKey(t)) {
                return new int[]{map.get(t), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
}
