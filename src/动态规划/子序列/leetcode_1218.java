package 动态规划.子序列;
/*
给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。

子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。



示例 1：

输入：arr = [1,2,3,4], difference = 1
输出：4
解释：最长的等差子序列是 [1,2,3,4]。
示例 2：

输入：arr = [1,3,5,7], difference = 1
输出：1
解释：最长的等差子序列是任意单个元素。
示例 3：

输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
输出：4
解释：最长的等差子序列是 [7,5,3,1]。


提示：

1 <= arr.length <= 105
-104 <= arr[i], difference <= 104
 */

import java.util.HashMap;

// 最长定差子序列
public class leetcode_1218 {
    public static void main(String[] args) {
        System.out.println(longestSubsequence(new int[]{1, 2, 3, 4}, 1));
        System.out.println(longestSubsequence(new int[]{1, 3, 5, 7}, 1));
        System.out.println(longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
    }

    public static int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int a : arr) {
            /*
                1, 2, 3, 4
                对于当前值 如： 3 判断之前的 a - difference => 3 - 1 = 2 为结尾的序列长度
             */
            map.put(a, map.getOrDefault(a - difference, 0) + 1);
            ans = Math.max(ans, map.get(a));
        }
        return ans;
    }

    // 超时
    public static int longestSubsequence2(int[] arr, int difference) {
        int ans = 0, len = arr.length;
        int[] f = new int[len];
        for (int i = 0; i < len; i++) {
            f[i] = 1;
            // 这一层for就是寻找 之前与当前组成等差的元素  使用map存储之前的元素 然后对于当前元素直接map.get(a - diff) 就可以获取之前等差的那个元素为结尾的序列长度了
            for (int j = 0; j < i; j++) {
                if (arr[j] + difference == arr[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}
