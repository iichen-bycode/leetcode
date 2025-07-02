package 指针.单序列.相向;
/*
给你一个下标从 0 开始、长度为 n 的整数数组 nums ，和两个整数 lower 和 upper ，返回 公平数对的数目 。

如果 (i, j) 数对满足以下情况，则认为它是一个 公平数对 ：

0 <= i < j < n，且
lower <= nums[i] + nums[j] <= upper


示例 1：

输入：nums = [0,1,7,4,4,5], lower = 3, upper = 6
输出：6
解释：共计 6 个公平数对：(0,3)、(0,4)、(0,5)、(1,3)、(1,4) 和 (1,5) 。
示例 2：

输入：nums = [1,7,9,2,5], lower = 11, upper = 11
输出：1
解释：只有单个公平数对：(2,3) 。


提示：

1 <= nums.length <= 105
nums.length == n
-109 <= nums[i] <= 109
-109 <= lower <= upper <= 109
 */


import java.util.Arrays;

//统计公平数对的数目
public class leetcode_2563 {
    public static void main(String[] args) {
        System.out.println(countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6));
        /*
            0   1   2   3   4   5

            0   1   4   4   5   7
         (0,3)、(0,4)、(0,5)、(1,3)、(1,4) 和 (1,5) 。
         0+4
         0+4
         0+5
         1+4
         1+4
         1+5


         */
        System.out.println(countFairPairs(new int[]{1, 7, 9, 2, 5}, 11, 11));
    }

    public static long countFairPairs(int[] nums, int lower, int upper) {
        // lower <= 两数之和 <= upper
        /*
            则 0<= 两数之和 <= upper  -   0 <= 两数之和 <= lower  即可

            前缀和的思路
         */
        Arrays.sort(nums);
        return count(nums, upper) - count(nums, lower - 1);
    }

    private static long count(int[] nums, int upper) {
        long res = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] <= upper) {
                res += j - i;
                i++;
            } else {
                j--;
            }
        }
        return res;
    }



    public static long countFairPairs2(int[] nums, int lower, int upper) {
        // for i遍历，然后查找 i-n之间满足 条件的 左右边界 j,k, 且 k>=j  二分查找
        Arrays.sort(nums);
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 因为bound 找不到会返回比当前target 第一个大的下标所以 队医lower直接符合，对于upper则需要 -1 是下一个
            //     0   1   2   3   4   5
            //     0   1   4   4   5   7        3   6

            /*
                1 2 5 7 9               11  11
             */
            int l = lowerBound(nums, i + 1, n, lower - nums[i]);
            int r = upperBound(nums, i + 1, n, upper - nums[i]) - 1;
            if (r >= l) {
                ans += r - l + 1;
            }
        }
        return ans;
    }

    private static int upperBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            // 第一个 > target的下标  -1  就是 <= upper的结果下标
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private static int lowerBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
