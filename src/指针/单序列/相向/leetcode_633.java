package 指针.单序列.相向;
/*
给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。



示例 1：

输入：c = 5
输出：true
解释：1 * 1 + 2 * 2 = 5
示例 2：

输入：c = 3
输出：false


提示：

0 <= c <= 231 - 1
 */

// 平方数之和
public class leetcode_633 {
    public static void main(String[] args) {
//        System.out.println(judgeSquareSum(2));
//        System.out.println(judgeSquareSum(4));
//        System.out.println(judgeSquareSum(5));
//        System.out.println(judgeSquareSum(3));
//        System.out.println(judgeSquareSum(Integer.MAX_VALUE));
//        System.out.println(judgeSquareSum(948124));
        System.out.println(judgeSquareSum(2147483600));
    }

    public static boolean judgeSquareSum(int c) {
        int l = 0, r = (int) Math.sqrt(c);
        System.out.println(">>>>>>> " + r);
        while (l <= r) {
            long sum = (long) l * l + (long) r * r;
            System.out.println(">>>>>>> " + sum);
            if (sum == c)
                return true;
            if (sum > c) {
                r--;
            }
            if (sum < c) {
                l++;
            }
        }
        return false;
    }
}
