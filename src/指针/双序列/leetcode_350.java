package 指针.双序列;

/*
给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。



示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]
示例 2:

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]


提示：

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000


进阶：

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小，哪种方法更优？
如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

 */

import helper.Utils;

import java.util.*;

//两个数组的交集 II
public class leetcode_350 {
    public static void main(String[] args) {
        Utils.print(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        Utils.print(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        /*
        4   5   9
        4   4   8   9   9

            4   9
         */
        int m = nums1.length, n = nums2.length, index = 0;
        int[] cache = new int[1001];
        for (int a : nums1) {
            cache[a]++;
        }
        int[] ans = new int[Math.min(m,n)];
        for (int a : nums2) {
            if (cache[a] > 0) {
                ans[index++] = a;
                cache[a]--;
            }
        }
        return Arrays.copyOf(ans,index);
    }
}









