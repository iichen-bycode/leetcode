package 常用数据结构.单调栈;
/*
给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。

数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。



示例 1:

输入: nums = [1,2,1]
输出: [2,-1,2]
解释: 第一个 1 的下一个更大的数是 2；
数字 2 找不到下一个更大的数；
第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
示例 2:

输入: nums = [1,2,3,4,3]
输出: [2,3,4,-1,4]


提示:

1 <= nums.length <= 104
-109 <= nums[i] <= 109
 */

import helper.Utils;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// 下一个更大元素 II
public class leetcode_503 {
    public static void main(String[] args) {
        Utils.print(nextGreaterElements(new int[]{1, 2, 1}));
        /*
            1   2   1   1   2   1

             2 2 1

         */
        Utils.print(nextGreaterElements(new int[]{1, 2, 3, 4, 3}));
        // [-2,1,-3,4,-1,2,1,-5,4]
        Utils.print(nextGreaterElements(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        deque.push(0);
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < 2 * n; i++) {
            while (!deque.isEmpty() && nums[deque.peek() % n] < nums[i % n]) {
                ans[deque.peek() % n] = nums[i % n];
                deque.pop();
            }
            deque.push(i);
        }
        return ans;
    }
}
