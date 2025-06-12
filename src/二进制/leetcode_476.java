package 二进制;

/*
https://leetcode.cn/problems/number-complement/description/
对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。

例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
给你一个整数 num ，输出它的补数。

101  ^
111

010


示例 1：

输入：num = 5
输出：2
解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
示例 2：

输入：num = 1
输出：0
解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。

01
11

提示：

1 <= num < 231
 */
public class leetcode_476 {
    public static void main(String[] args) {
        System.out.println(findComplement(5));
        System.out.println(findComplement(1));
    }

    public static int findComplement(int num) {
        // 取反需要与有效位数取反
        // 5 是 000000000000000000000000000101 不能呢个直接和1异或 需要 000000000000000000000000000111
        // 100 011
//        return num ^ ((Integer.highestOneBit(num) << 1) - 1);
        return num ^ ((1 << (32 - Integer.numberOfLeadingZeros(num))) - 1);
    }
}
