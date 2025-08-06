package medium;

/*
给你一个整数数组 nums ，你可以对它进行一些操作。

每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。

开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。



示例 1：

输入：nums = [3,4,2]
输出：6
解释：
删除 4 获得 4 个点数，因此 3 也被删除。
之后，删除 2 获得 2 个点数。总共获得 6 个点数。
示例 2：

输入：nums = [2,2,3,3,3,4]
输出：9
解释：
删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
总共获得 9 个点数。


提示：

1 <= nums.length <= 2 * 104
1 <= nums[i] <= 10^4
 */

import helper.Utils;


// 198
// 删除并获得点数
public class leetcode_740 {
    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4, 5, 5, 5}));
        System.out.println(deleteAndEarn(new int[]{1, 1, 1, 2, 4, 5, 5, 5, 6}));
//        0 3 2 0 4 15 6
    }

    private static int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int a : nums) {
            max = Math.max(max, a);
        }
        int[] cache = new int[max + 1];
        for (int a : nums) {
            cache[a] += a;
        }
        int f0 = 0;
        int f1 = 0;
        for (int x : cache) {
            int newF = Math.max(f1, f0 + x);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }

    class Solution {
        public int deleteAndEarn(int[] nums) {
            int mx = 0;
            for (int x : nums) {
                mx = Math.max(mx, x);
            }

            int[] a = new int[mx + 1];
            for (int x : nums) {
                a[x] += x; // 统计等于 x 的元素之和
            }

            return rob(a);
        }

        // 198. 打家劫舍
        private int rob(int[] nums) {
            int f0 = 0;
            int f1 = 0;
            for (int x : nums) {
                int newF = Math.max(f1, f0 + x);
                f0 = f1;
                f1 = newF;
            }
            return f1;
        }
    }
}
