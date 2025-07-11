package 指针.单序列.相向;

import helper.Utils;

import java.util.Arrays;

/*
给你一个整数数组 arr 和一个整数 k 。

设 m 为数组的中位数，只要满足下述两个前提之一，就可以判定 arr[i] 的值比 arr[j] 的值更强：

 |arr[i] - m| > |arr[j] - m|
 |arr[i] - m| == |arr[j] - m|，且 arr[i] > arr[j]
请返回由数组中最强的 k 个值组成的列表。答案可以以 任意顺序 返回。

中位数 是一个有序整数列表中处于中间位置的值。形式上，如果列表的长度为 n ，那么中位数就是该有序列表（下标从 0 开始）中位于 ((n - 1) / 2) 的元素。

例如 arr = [6, -3, 7, 2, 11]，n = 5：数组排序后得到 arr = [-3, 2, 6, 7, 11] ，数组的中间位置为 m = ((5 - 1) / 2) = 2 ，中位数 arr[m] 的值为 6 。
例如 arr = [-7, 22, 17, 3]，n = 4：数组排序后得到 arr = [-7, 3, 17, 22] ，数组的中间位置为 m = ((4 - 1) / 2) = 1 ，中位数 arr[m] 的值为 3 。


示例 1：

输入：arr = [1,2,3,4,5], k = 2
输出：[5,1]
解释：中位数为 3，按从强到弱顺序排序后，数组变为 [5,1,4,2,3]。最强的两个元素是 [5, 1]。[1, 5] 也是正确答案。
注意，尽管 |5 - 3| == |1 - 3| ，但是 5 比 1 更强，因为 5 > 1 。
示例 2：

输入：arr = [1,1,3,5,5], k = 2
输出：[5,5]
解释：中位数为 3, 按从强到弱顺序排序后，数组变为 [5,5,1,1,3]。最强的两个元素是 [5, 5]。
示例 3：

输入：arr = [6,7,11,7,6,8], k = 5
        6 6 7 7 8 11    mid = 7
        1 1   0 1 4

输出：[11,8,6,6,7]
解释：中位数为 7, 按从强到弱顺序排序后，数组变为 [11,8,6,6,7,7]。
[11,8,6,6,7] 的任何排列都是正确答案。


提示：

1 <= arr.length <= 105
-105 <= arr[i] <= 105
1 <= k <= arr.length

https://leetcode.cn/problems/the-k-strongest-values-in-an-array/
 */
public class leetcode_1471 {
    public static void main(String[] args) {
        int[] a = getStrongest(new int[]{1, 2, 3, 4, 5}, 2);
        Utils.print(a);
        int[] b = getStrongest(new int[]{1, 2}, 2);
        Utils.print(b);
        int[] c = getStrongest(new int[]{6, 7, 11, 7, 6, 8}, 5);
        // mid 11   5 4  4 5 3
        Utils.print(c);
        // [5,1]
        // [5,5]
        // [11,8,6,6,7]
    }

    public static int[] getStrongest(int[] arr, int k) {
        int l = 0, n = arr.length, r = n - 1, index = 0;
        int[] ans = new int[k];
        Arrays.sort(arr);
        int mid = arr[(n - 1) / 2];
        while (l <= r && index < k) {
            if ((arr[r] - mid) >= (mid - arr[l])) {
                ans[index++] = arr[r];
                r--;
            } else {
                ans[index++] = arr[l];
                l++;
            }
        }
        return ans;
    }
}
