package 指针.单序列.相向;

import helper.Utils;

import java.util.ArrayList;
import java.util.List;

/*
给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。

整数 a 比整数 b 更接近 x 需要满足：

|a - x| < |b - x| 或者
|a - x| == |b - x| 且 a < b


示例 1：

输入：arr = [1,2,3,4,5], k = 4, x = 3
输出：[1,2,3,4]
示例 2：

输入：arr = [1,1,2,3,4,5], k = 4, x = -1
输出：[1,1,2,3]


提示：

1 <= k <= arr.length
1 <= arr.length <= 104
arr 按 升序 排列
-104 <= arr[i], x <= 104

https://leetcode.cn/problems/find-k-closest-elements/description/
 */
public class leetcode_658 {
    public static void main(String[] args) {
        List<Integer> a = findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);
        //输出：[1,2,3,4]
        Utils.printList(a);
        List<Integer> b = findClosestElements(new int[]{1}, 1, 1);
        List<Integer> b2 = findClosestElements(new int[]{-2,-1,1,2,3,4,5}, 7, 3);
        // 5 4 2 1 0 1 2
        Utils.printList(b2);
        Utils.printList(b);
//        // 4 2 1 0 1 2 3
//        //输出：[1,2,3,4]
        List<Integer> c = findClosestElements(new int[]{1, 1, 2, 3, 4, 5}, 4, -1);
        //输出：[1,1,2,3]
        Utils.printList(c);
        // 2 2 4 3 5 6
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int l = 0, n = arr.length, r = n - 1;
        while (l < r) {
            if (r - l + 1 == k)
                break;
            if (Math.abs(x - arr[r]) >= Math.abs(x - arr[l])) {
                r--;
            } else {
                l++;
            }
        }
        for (int i = l; i <= r; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
