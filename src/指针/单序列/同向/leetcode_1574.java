package 指针.单序列.同向;
/*
给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。

一个子数组指的是原数组中连续的一个子序列。

请你返回满足题目要求的最短子数组的长度。



示例 1：

输入：arr = [1,2,3,10,4,2,3,5]

输出：3
解释：我们需要删除的最短子数组是 [10,4,2] ，长度为 3 。剩余元素形成非递减数组 [1,2,3,3,5] 。
另一个正确的解为删除子数组 [3,10,4] 。
示例 2：

输入：arr = [5,4,3,2,1]
输出：4
解释：由于数组是严格递减的，我们只能保留一个元素。所以我们需要删除长度为 4 的子数组，要么删除 [5,4,3,2]，要么删除 [4,3,2,1]。
示例 3：

输入：arr = [1,2,3]
输出：0
解释：数组已经是非递减的了，我们不需要删除任何元素。
示例 4：

输入：arr = [1]
输出：0


提示：

1 <= arr.length <= 10^5
0 <= arr[i] <= 10^9
 */


// 删除最短的子数组使剩余数组有序
public class leetcode_1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        /*
            1,2,3,10,4,2,3,5

            4不在任何一个 直接删除
            左侧非递减前缀： 1 2 3 10
            右侧非递减后缀： 2 3 5

            枚举左侧
                arr[l]:
                    1   则右侧删除的位置arr[r]< arr[l]  结果：1 2 3 5 删除 2 3 10 4
                    2   则右侧删除的位置arr[r]< arr[l]  结果：1  2 2 3 5 删除 3 10 4
                    3   则右侧删除的位置arr[r]< arr[l]  结果：1  2 3 3 5 删除 10 4 2
                    10   则右侧删除的位置arr[r]< arr[l]  结果：1  2 3 10 删除 4 2 3 5
         */

        int n = arr.length, right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right])
            --right;
        if (right == 0) return 0; // arr 已经是非递减数组
        // 此时 arr[right-1] > arr[right]
        int ans = right; // 删除 0 到 right-1

        // 枚举左侧非递减
        for (int left = 0; left == 0 || arr[left - 1] <= arr[left]; ++left) {
            while (right < n && arr[right] < arr[left])
                ++right;
            // 此时 arr[left] <= arr[right]，从 left+1 到 right-1 可以删除
            ans = Math.min(ans, right - left - 1);
        }
        return ans;
    }
}
