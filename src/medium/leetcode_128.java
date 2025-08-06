package medium;

/*
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。



示例 1：

输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
示例 2：

输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
示例 3：

输入：nums = [1,0,1,2]
输出：3


提示：

0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

// 最长连续序列
public class leetcode_128 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        /*
         0 0 1 2 3 4 5 6 7 8
         */
        System.out.println(longestConsecutive(new int[]{1, 0, 1, 2}));
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for (int a : nums) {
            set.add(a);
        }
        for (int a : set) {
            // 有更小的连续值 则当前就无需继续了
            if (set.contains(a - 1)) {
                continue;
            }
            int b = a + 1;
            while (set.contains(b)) {
                b++;
            }
            ans = Math.max(ans, b - a);
        }
        return ans;
    }

    public static int longestConsecutive2(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        Arrays.sort(nums);
        int ans = 1, count = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }
            ans = Math.max(ans, count);
            if (ans >= len / 2)
                break;
        }
        return ans;
    }
}
