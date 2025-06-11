package 滑动窗口;

/*
给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。

返回 只删除一个 子数组可获得的 最大得分 。

如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。



示例 1：

输入：nums = [4,2,4,5,6]
输出：17
解释：最优子数组是 [2,4,5,6]
示例 2：

输入：nums = [5,2,1,2,5,2,1,2,5]
输出：8
解释：最优子数组是 [5,2,1] 或 [1,2,5]


提示：

1 <= nums.length <= 105
1 <= nums[i] <= 104
 */
public class leetcode_1695 {
    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
        System.out.println(maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));
        System.out.println(maximumUniqueSubarray(new int[]{187, 470, 25, 436, 538, 809, 441, 167, 477, 110, 275, 133, 666, 345, 411,
                459, 490, 266, 987, 965, 429, 166, 809, 340, 467, 318, 125, 165, 809, 610, 31, 585, 970, 306, 42,
                //                                  22
                189, 169, 743, 78, 810, 70, 382, 367, 490, 787, 670, 476, 278, 775, 673, 299, 19, 893, 817, 971, 458, 409, 886, 434})); // 16911
    }

    public static int maximumUniqueSubarray(int[] nums) {
        int ans = 0, t = 0, l = 0, max = Integer.MIN_VALUE, count = 0;
        for (int j : nums) {
            max = Math.max(max, j);
        }
        int[] cache = new int[max + 1];
        for (int num : nums) {
            // 出现重复的计数 用于移动窗口判断
            if (cache[num] != 0) {
                count++;
            }
            cache[num]++;
            t += num;
            while (count > 0) {
                // 当前左边l指向的是重复的 则停止左侧移动 充重置count计数
                if (cache[nums[l]]-- > 1) {
                    count--;
                }
                t -= nums[l];
                l++;
            }
            ans = Math.max(ans, t);
        }
        return ans;
    }
}
