package 动态规划;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
一个魔法师有许多不同的咒语。

给你一个数组 power ，其中每个元素表示一个咒语的伤害值，可能会有多个咒语有相同的伤害值。

已知魔法师使用伤害值为 power[i] 的咒语时，他们就 不能 使用伤害为 power[i] - 2 ，power[i] - 1 ，power[i] + 1 或者 power[i] + 2 的咒语。

每个咒语最多只能被使用 一次 。

请你返回这个魔法师可以达到的伤害值之和的 最大值 。



示例 1：

输入：power = [1,1,3,4]

输出：6

解释：

可以使用咒语 0，1，3，伤害值分别为 1，1，4，总伤害值为 6 。

示例 2：

输入：power = [7,1,6,6]

输出：13

解释：

可以使用咒语 1，2，3，伤害值分别为 1，6，6，总伤害值为 13 。



提示：

1 <= power.length <= 105
1 <= power[i] <= 109
https://leetcode.cn/problems/maximum-total-damage-with-spell-casting/description/
 */
public class leetcode_3186 {
    public static void main(String[] args) {
        System.out.println(maximumTotalDamage(new int[]{1, 1, 3, 4}));  // 6
        System.out.println(maximumTotalDamage(new int[]{7,1,6,6}));// 13
    }

    public static long maximumTotalDamage(int[] power) {
        // 已知魔法师使用伤害值为 power[i] 的咒语时，他们就 不能 使用伤害为 power[i] - 2 ，power[i] - 1 ，power[i] + 1 或者 power[i] + 2 的咒语。
        /*
            dp[i]  表示 从 0-i 获取的最大伤害
         */
        Map<Integer,Integer> map = new HashMap<>();
        for (int j : power) {
            // 记录重复值 个数 变成 单个数集合
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        int n = map.size();
        // 记录 相当于去重的有序数据
        int[] a = new int[n];int k = 0;
        for (int x : map.keySet()) {
            a[k++] = x;
        }
        Arrays.sort(a);
        int j = 0;
        long[] dp = new long[n + 1];
        for (int i = 0; i < a.length; i++) {
            // 当前值
            int cur = a[i];
            while (a[j] < cur - 2) {
                j++;
            }
            // a[i] 不选 则 0-i最大值 就是0- i-1之间的
            // a[i] 选 则 当前a[i]的个数*a[i] + 在 满足a[i] - 2的 最区间最大值dp[j]
            dp[i+1] = Math.max(dp[i],dp[j] + (long) map.get(cur) * cur);
        }
        return dp[n];
    }
}
