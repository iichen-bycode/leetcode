package 指针.单序列.原地修改;
/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

请注意 ，必须在不复制数组的情况下原地对数组进行操作。



示例 1:

输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
示例 2:

输入: nums = [0]
输出: [0]


提示:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1


进阶：你能尽量减少完成的操作次数吗？
 */


import helper.Utils;

// 移动零
public class leetcode_283 {
    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 0, 3, 12};
//        int[] a = new int[]{2, 1};
//        int[] a = new int[]{9, 0, 1, 2, 5, 4, 0, 0, 0, 494, 5, 2};
        /*
            1 0 0 3 12
            1 3 0 0 12
            1 3 12 0 0
         */
        moveZeroes(a);
        Utils.print(a);


    }

    public static void moveZeroes(int[] nums) {
//        int index = nums[0] == 0 ? 0 : 1;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int t = nums[index];
                nums[index++] = nums[i];
                nums[i] = t;
            }
        }
    }
}
