package 常用数据结构.前缀和;

import helper.Utils;

/*
给你两个长度相同的字符串 s 和 t ，以及两个整数数组 nextCost 和 previousCost 。

一次操作中，你可以选择 s 中的一个下标 i ，执行以下操作 之一 ：

将 s[i] 切换为字母表中的下一个字母，如果 s[i] == 'z' ，切换后得到 'a' 。操作的代价为 nextCost[j] ，其中 j 表示 s[i] 在字母表中的下标。
将 s[i] 切换为字母表中的上一个字母，如果 s[i] == 'a' ，切换后得到 'z' 。操作的代价为 previousCost[j] ，其中 j 是 s[i] 在字母表中的下标。
切换距离 指的是将字符串 s 变为字符串 t 的 最少 操作代价总和。

请你返回从 s 到 t 的 切换距离 。



示例 1：

输入：s = "abab", t = "baba", nextCost = [100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0], previousCost = [1,100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
    1 0 0 ... 0

    ->  0 1 1 1  ... 1 1 1
            a -> b
            b -> a

    <-  0 0 0 0  ... 0 0 1


输出：2

解释：

选择下标 i = 0 并将 s[0] 向前切换 25 次，总代价为 1 。
选择下标 i = 1 并将 s[1] 向后切换 25 次，总代价为 0 。
选择下标 i = 2 并将 s[2] 向前切换 25 次，总代价为 1 。
选择下标 i = 3 并将 s[3] 向后切换 25 次，总代价为 0 。
示例 2：
abcde fghij klmnop qrstu vwxyz
输入：s = "leet", t = "code", nextCost = [1,1,1,1,1 ,1,1,1,1,1 ,1,1,1,1,1 ,1,1,1,1,1 ,1,1,1,1,1 ,1], previousCost = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
    1 1 .... 1 1
    -> 0 1 2 3 4 .... 26

    <- 0 1 2 3 4 .... 26
        l->c  11 - 2
        e->o  14 - 4
        e->d  4-3
        t->e  19 - 4   6 + 4 + 1
输出：31

解释：

选择下标 i = 0 并将 s[0] 向前切换 9 次，总代价为 9 。
选择下标 i = 1 并将 s[1] 向后切换 10 次，总代价为 10 。
选择下标 i = 2 并将 s[2] 向前切换 1 次，总代价为 1 。
选择下标 i = 3 并将 s[3] 向后切换 11 次，总代价为 11 。


提示：

1 <= s.length == t.length <= 105
s 和 t 都只包含小写英文字母。
nextCost.length == previousCost.length == 26
0 <= nextCost[i], previousCost[i] <= 109
 */
// 两个字符串的切换距离
public class leetcode_3361 {
    public static void main(String[] args) {
        System.out.println(shiftDistance("abab", "baba", new int[]{100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new int[]{1, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        System.out.println(shiftDistance("leet", "code", new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
    }

    public static long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        int n = nextCost.length;
        // a-z的前缀和数组 使得成为环形
        long[] f1 = new long[2 * n + 1];
        long[] f2 = new long[2 * n + 1];
        for (int i = 0; i < 2 * n; i++) {
            f1[i + 1] = f1[i] + nextCost[i % n];
            f2[i + 1] = f2[i] + previousCost[i % n];
        }
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            int y = t.charAt(i) - 'a';
            // 往下找的时候不用管 accumulate 最前面加的0 而 pre_sum 向前找需要管最前进添加的0
            ans += Math.min(f1[y < x ? y + n : y] - f1[x],
                    f2[(x < y ? x + n : x) + 1] - f2[y + 1]);
        }
        return ans;
    }
}
