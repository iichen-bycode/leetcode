package 二进制;

/*
https://leetcode.cn/problems/number-of-steps-to-reduce-a-number-to-zero/description/
给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。



示例 1：

输入：num = 14
输出：6
解释：
步骤 1) 14 是偶数，除以 2 得到 7 。
步骤 2） 7 是奇数，减 1 得到 6 。
步骤 3） 6 是偶数，除以 2 得到 3 。
步骤 4） 3 是奇数，减 1 得到 2 。
步骤 5） 2 是偶数，除以 2 得到 1 。
步骤 6） 1 是奇数，减 1 得到 0 。
示例 2：

输入：num = 8
输出：4
解释：
步骤 1） 8 是偶数，除以 2 得到 4 。
步骤 2） 4 是偶数，除以 2 得到 2 。
步骤 3） 2 是偶数，除以 2 得到 1 。
步骤 4） 1 是奇数，减 1 得到 0 。
示例 3：

输入：num = 123
输出：12


提示：

0 <= num <= 10^6
 */
public class leetcode_1342 {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
        System.out.println(numberOfSteps(8));
        /*
         32 16  8 4 2 1

            1110
            1000
         */
        System.out.println(numberOfSteps(123));
    }

    public static int numberOfSteps(int num) {
//        int ans = 0;
//        while (num != 0) {
//            if (num % 2 == 0) {
//                num = num >> 1;
//            } else {
//                num -= 1;
//            }
//            ans++;
//        }
//        return ans;
        // 右移 bitcount-1次，且恰好需要 二进制中1的个数 的 减一操作
        return num == 0 ? 0 : 31 - Integer.numberOfLeadingZeros(num) + Integer.bitCount(num);
    }
}
