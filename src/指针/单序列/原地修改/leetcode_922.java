package 指针.单序列.原地修改;
/*
给定一个非负整数数组 nums，  nums 中一半整数是 奇数 ，一半整数是 偶数 。

对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。

你可以返回 任何满足上述条件的数组作为答案 。



示例 1：

输入：nums = [4,2,5,7]
输出：[4,5,2,7]
解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
示例 2：

输入：nums = [2,3]
输出：[2,3]


提示：

2 <= nums.length <= 2 * 104
nums.length 是偶数
nums 中一半是偶数
0 <= nums[i] <= 1000


进阶：可以不使用额外空间解决问题吗？
 */

import helper.Utils;

// 按奇偶排序数组 II
public class leetcode_922 {
    public static void main(String[] args) {
        Utils.print(sortArrayByParityII(new int[]{4, 2, 5, 7}));
        Utils.print(sortArrayByParityII(new int[]{2, 3}));
        Utils.print(sortArrayByParityII(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        Utils.print(sortArrayByParityII(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
        Utils.print(sortArrayByParityII(new int[]{8, 9, 7, 6, 5, 4, 3, 2, 1, 0}));
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int n = nums.length, r = n - 1;
        // 直接从偶数项判断
        for (int i = 0; i < n; i = i + 2) { // 左找奇 右找偶
            if (nums[i] % 2 == 0)
                continue;
            while (r >= 0 && nums[r] % 2 == 1) {
                r -= 2;
            }
            int t = nums[i];
            nums[i] = nums[r];
            nums[r] = t;
        }
        return nums;
    }

    public static int[] sortArrayByParityII3(int[] nums) {

        /*
            i: 0 2 4 6  需要为偶数
            j: 1 3 5 7  需要为奇数
            循环获取 i 第一个为奇数的， j第一个为偶数的 然后交换
                i+2
                j+2
         */
        int i = 0, j = 1, n = nums.length;
        while (i < n) {
            if (nums[i] % 2 == 0) {
                i += 2;
            } else if (nums[j] % 2 != 0) {
                j += 2;
            } else {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i += 2;
                j += 2;
            }
        }
        return nums;
    }

    public static int[] sortArrayByParityII2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!((i % 2 == 0 && nums[i] % 2 == 0) || (i % 2 != 0 && nums[i] % 2 != 0))) {
                int r = i + 1;
                while (r < n) {
                    if (i % 2 == nums[r] % 2) {
                        int t = nums[i];
                        nums[i] = nums[r];
                        nums[r] = t;
                        break;
                    }
                    r++;
                }
            }
//            Utils.print(nums);
        }
        return nums;
    }
}
