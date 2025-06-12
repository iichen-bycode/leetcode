package 二进制;

/*
给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。



示例 1：

输入：n = 5
输出：true
解释：5 的二进制表示是：101
示例 2：

输入：n = 7
输出：false
解释：7 的二进制表示是：111.
示例 3：

输入：n = 11
输出：false
解释：11 的二进制表示是：1011.


提示：

1 <= n <= 2的31次方 - 1
https://leetcode.cn/problems/binary-number-with-alternating-bits/description/
 */
public class leetcode_693 {
    public static void main(String[] args) {
        /*
            01111
            10000

            16 8 4 2 1

            101    5
               ^
            010
                =
            1000
            1001


            0111    7
              ^
            0011
                =
            0011    3

            1100    12

            1011    11

         */
        System.out.println(hasAlternatingBits(4));
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(7));
        System.out.println(hasAlternatingBits(11));
    }

    public static boolean hasAlternatingBits(int n) {
        return false;
    }
    public static boolean hasAlternatingBits2(int n) {
        int c = n & 1;
        n = n >> 1;
        while (n != 0) {
            int t = n & 1;
            if (t == c) {
                return false;
            }
            c = t;
            n = n >> 1;
        }
        return true;
    }
}
