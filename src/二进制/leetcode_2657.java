package 二进制;

import java.util.HashMap;
import java.util.HashSet;

/*
给你两个下标从 0 开始长度为 n 的整数排列 A 和 B 。

A 和 B 的 前缀公共数组 定义为数组 C ，其中 C[i] 是数组 A 和 B 到下标为 i 之前公共元素的数目。

请你返回 A 和 B 的 前缀公共数组 。

如果一个长度为 n 的数组包含 1 到 n 的元素恰好一次，我们称这个数组是一个长度为 n 的 排列 。



示例 1：

输入：A = [1,3,2,4], B = [3,1,2,4]
输出：[0,2,3,4]
解释：i = 0：没有公共元素，所以 C[0] = 0 。
i = 1：1 和 3 是两个数组的前缀公共元素，所以 C[1] = 2 。
i = 2：1，2 和 3 是两个数组的前缀公共元素，所以 C[2] = 3 。
i = 3：1，2，3 和 4 是两个数组的前缀公共元素，所以 C[3] = 4 。
示例 2：

输入：A = [2,3,1], B = [3,1,2]
输出：[0,1,3]
解释：i = 0：没有公共元素，所以 C[0] = 0 。
i = 1：只有 3 是公共元素，所以 C[1] = 1 。
i = 2：1，2 和 3 是两个数组的前缀公共元素，所以 C[2] = 3 。


提示：

1 <= A.length == B.length == n <= 50
1 <= A[i], B[i] <= n
题目保证 A 和 B 两个数组都是 n 个元素的排列。
https://leetcode.cn/problems/find-the-prefix-common-array-of-two-arrays/description/
 */
public class leetcode_2657 {
    public static void main(String[] args) {
//        int[] a = findThePrefixCommonArray(new int[]{1, 3, 2, 4}, new int[]{3, 1, 2, 4});
        /*
            2 010       0100
            3 011       1000
         */
        int[] a = findThePrefixCommonArray(new int[]{2, 3, 1}, new int[]{3, 1, 2});
        for (int j : a) {
            System.out.print(j + ",");
        }
    }

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B[i];
            if (a == b) {
                count++;
            } else if (set.contains(a) && set.contains(b)) {
                count += 2;
                set.remove(a);
                set.remove(b);
            } else if (set.contains(a)) {
                set.remove(a);
                set.add(b);
                count++;
            } else if (set.contains(b)) {
                set.remove(b);
                set.add(a);
                count++;
            } else {
                set.add(a);
                set.add(b);
            }
            ans[i] = count;
        }
        return ans;
    }
}
