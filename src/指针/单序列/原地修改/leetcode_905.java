package 指针.单序列.原地修改;
/*
给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。

返回满足此条件的 任一数组 作为答案。



示例 1：

输入：nums = [3,1,2,4]
输出：[2,4,3,1]
解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
示例 2：

输入：nums = [0]
输出：[0]


提示：

1 <= nums.length <= 5000
0 <= nums[i] <= 5000
 */


import helper.Utils;

// 按奇偶排序数组
public class leetcode_905 {
    public static void main(String[] args) {
        Utils.print(sortArrayByParity(new int[]{3, 1, 2, 4}));
        Utils.print(sortArrayByParity(new int[]{0}));
        Utils.print(sortArrayByParity(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    public static int[] sortArrayByParity(int[] nums) {
        // 看成一个栈 逐个放置元素
        int index = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                int t = nums[index];
                nums[index++] = nums[i];
                nums[i] = t;
            }
        }
        return nums;
    }
}
