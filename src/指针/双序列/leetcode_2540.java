package 指针.双序列;
/*
给你两个整数数组 nums1 和 nums2 ，它们已经按非降序排序，请你返回两个数组的 最小公共整数 。如果两个数组 nums1 和 nums2 没有公共整数，请你返回 -1 。

如果一个整数在两个数组中都 至少出现一次 ，那么这个整数是数组 nums1 和 nums2 公共 的。



示例 1：

输入：nums1 = [1,2,3], nums2 = [2,4]
输出：2
解释：两个数组的最小公共元素是 2 ，所以我们返回 2 。
示例 2：

输入：nums1 = [1,2,3,6], nums2 = [2,3,4,5]
输出：2
解释：两个数组中的公共元素是 2 和 3 ，2 是较小值，所以返回 2 。


提示：

1 <= nums1.length, nums2.length <= 105
1 <= nums1[i], nums2[j] <= 109
nums1 和 nums2 都是 非降序 的。
 */

// 最小公共值
public class leetcode_2540 {
    public static void main(String[] args) {
        System.out.println(getCommon(new int[]{1, 2, 3}, new int[]{2, 4}));
        System.out.println(getCommon(new int[]{1, 2, 3, 6}, new int[]{2, 3, 4, 5}));
    }

    public static int getCommon(int[] nums1, int[] nums2) {
        int l = 0, r = 0, m = nums1.length, n = nums2.length;
        while (l < m && r < n) {
            int a = nums1[l];
            int b = nums2[r];
            if (a == b) {
//                if (m > n) {
//                    l++;
//                } else {
//                    r++;
//                }
                return a;
            } else if (a > b) {
                r++;
            } else {
                l++;
            }
        }
        return -1;
    }
}
