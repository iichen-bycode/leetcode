package 二进制;

/*
给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。

如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。



示例 1：

输入：n = 1
输出：true
解释：20 = 1
示例 2：

输入：n = 16
输出：true
解释：24 = 16
示例 3：

输入：n = 3
输出：false


提示：

-231 <= n <= 231 - 1


进阶：你能够不使用循环/递归解决此问题吗？
 */
public class leetcode_231 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfTwo(-2147483648));
    }

    public static boolean isPowerOfTwo(int n) {
        /*
            8   4   2   1

            0001
           10000
            0011

            1 2 4 8 16 32
            0001
            0010
            0100
            1000
           10000
          100000
         */
        return n >= 0 && Integer.bitCount(n) == 1;
    }
}
