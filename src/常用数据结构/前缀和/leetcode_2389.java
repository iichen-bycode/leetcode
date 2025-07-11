package 常用数据结构.前缀和;
/*
给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。

返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度  。

子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。



示例 1：

输入：nums = [4,5,2,1], queries = [3,10,21]
输出：[2,3,4]
解释：queries 对应的 answer 如下：
- 子序列 [2,1] 的和小于或等于 3 。可以证明满足题目要求的子序列的最大长度是 2 ，所以 answer[0] = 2 。
- 子序列 [4,5,1] 的和小于或等于 10 。可以证明满足题目要求的子序列的最大长度是 3 ，所以 answer[1] = 3 。
- 子序列 [4,5,2,1] 的和小于或等于 21 。可以证明满足题目要求的子序列的最大长度是 4 ，所以 answer[2] = 4 。
示例 2：

输入：nums = [2,3,4,5], queries = [1]
输出：[0]
解释：空子序列是唯一一个满足元素和小于或等于 1 的子序列，所以 answer[0] = 0 。


提示：

n == nums.length
m == queries.length
1 <= n, m <= 1000
1 <= nums[i], queries[i] <= 106
 */

import helper.Utils;

import java.util.Arrays;

// 和有限的最长子序列
public class leetcode_2389 {
    public static void main(String[] args) {
        Utils.print(answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21}));
        /*
            1   2   4   5
            1 3 7 12
         */
        Utils.print(answerQueries(new int[]{2, 3, 4, 5}, new int[]{1}));
        Utils.print(answerQueries(new int[]{736411, 184882, 914641, 37925, 214915}, new int[]{331244, 273144, 118983, 118252, 305688, 718089, 665450}));
    }

    public static int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        int[] ans = new int[m];
        Arrays.sort(nums);
        int[] f = new int[n];
        f[0] = nums[0];
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] + nums[i];
        }
        for (int i = 0; i < m; i++) {
            ans[i] = lowerBound(f,queries[i]);
        }
        return ans;
    }

    private static int lowerBound(int[] f, int t) {
        int l = 0,r = f.length,mid = l + (r - l ) / 2;
        while (l < r) {
            // 找到第一个 > t 的下标
            if(f[mid] <= t) {
                l = mid + 1;
            } else {
                r = mid;
            }
            mid = l + (r - l) / 2;
        }
        return l;
    }
}
