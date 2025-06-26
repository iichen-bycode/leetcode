package 二进制;

/*
给你一个正整数 n。

返回 大于等于 n 且二进制表示仅包含 置位 位的 最小 整数 x 。

置位 位指的是二进制表示中值为 1 的位。



示例 1：

输入： n = 5

输出： 7

解释：

7 的二进制表示是 "111"。

示例 2：

输入： n = 10

输出： 15

解释：
    8   4   2   1
    1010
15 的二进制表示是 "1111"。

示例 3：

输入： n = 3

输出： 3

解释：

3 的二进制表示是 "11"。



提示：

1 <= n <= 1000

https://leetcode.cn/problems/smallest-number-with-all-set-bits/description/
 */
public class leetcode_3370 {
    public static void main(String[] args) {
        System.out.println(smallestNumber(5));
        System.out.println(smallestNumber(10));
        System.out.println(smallestNumber(3));
        // 7 15 3
    }

    public static int smallestNumber(int n) {
        // 8 4 2 1
        /*
            5   101
         */
        int ans = 1;
        int index = 0;
        while (n != 0) {
            n = n >> 1;
            ans |= 1 << index++;
        }
        return ans;
    }
}
