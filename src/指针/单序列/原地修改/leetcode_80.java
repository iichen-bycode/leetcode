package 指针.单序列.原地修改;
/*
给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。



说明：

为什么返回数值是整数，但输出的答案是数组呢？

请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

你可以想象内部操作如下:

// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}


示例 1：

输入：nums = [1,1,1,2,2,3]
输出：5, nums = [1,1,2,2,3]
解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
示例 2：

输入：nums = [0,0,1,1,1,1,2,3,3]
输出：7, nums = [0,0,1,1,2,3,3]
解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。


提示：

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums 已按升序排列
 */

import helper.Utils;

// 删除有序数组中的重复项 II
public class leetcode_80 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(a));
        Utils.print(a);
        /*
            1 1 1 2 2 3 index = 2

            1 1 2 2 3 3
         */

        int[] b = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        /*
            0 0
         */
        System.out.println(removeDuplicates(b));
        Utils.print(b);

        int[] c = new int[]{0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(c));
        Utils.print(c);
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
    public static int removeDuplicates2(int[] nums) {
        int n = nums.length, index = 2;
        // 前两个默认添加
        for (int i = 2; i < n; i++) {
            // 不等需要加入并 增加index
            if (nums[i] != nums[i - 2]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
