package 指针.单序列.相向;

import helper.Utils;

/*
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。



示例 1：

输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]
示例 2：

输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]


提示：

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 已按 非递减顺序 排序


进阶：

请你设计时间复杂度为 O(n) 的算法解决本问题
 */
public class leetcode_977 {
    public static void main(String[] args) {
        int[] a = sortedSquares(new int[]{-5,-4, -1, 0, 3, 10});
        Utils.print(a);
        int[] b = sortedSquares(new int[]{-7, -3, 2, 3, 11});
        Utils.print(b);
    }

    public static int[] sortedSquares(int[] nums) {
        // -5 -4, -1, 0, 3, 10
        /*
            负数看为正数 对于l = 0,r = n -1
            若 a[l]^2 < a[r] ^2 则 l的位置不动 r--  且设置数据
            若 a[l]^2 > a[r] ^2 则 r的位置不动 l++  l的平方值需要设置数据
         */
        int l = 0, n = nums.length, r = n - 1;
        int[] ans = new int[n];
        while (l <= r) {
            int sumL = nums[l] * nums[l];
            int sumR = nums[r] * nums[r];
            if (sumL < sumR) {
                ans[--n] = sumR;
                r--;
            } else {
                ans[--n] = sumL;
                l++;
            }
        }
        return ans;
    }
}
