package 滑动窗口;

/*
    给你一个 二进制 字符串 s 和一个整数 k。

如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：

字符串中 0 的数量最多为 k。
字符串中 1 的数量最多为 k。
返回一个整数，表示 s 的所有满足 k 约束 的子字符串的数量。



示例 1：

输入：s = "10101", k = 1

输出：12

解释：

s 的所有子字符串中，除了 "1010"、"10101" 和 "0101" 外，其余子字符串都满足 k 约束。

示例 2：

输入：s = "1010101", k = 2

输出：25

解释：

s 的所有子字符串中，除了长度大于 5 的子字符串外，其余子字符串都满足 k 约束。

示例 3：

输入：s = "11111", k = 1

输出：15

解释：

s 的所有子字符串都满足 k 约束。



提示：

1 <= s.length <= 50
1 <= k <= s.length
s[i] 是 '0' 或 '1'。
 */
public class leetcode_3258 {
    public static void main(String[] args) {
        /*
        10101    1      12
            1 01 10 101 010 0
            1 + 2 + 3 + 3 + 3

        11111    1      15

         */
        System.out.println(countKConstraintSubstrings("10101",1));
        System.out.println(countKConstraintSubstrings("1010101",2));
        System.out.println(countKConstraintSubstrings("11111",1));

        // 12 25 15
    }

    public static int countKConstraintSubstrings(String s, int k) {
//        10101    1      12
//        1 + 2 + 3 + 3 + 3
        // 越短越好

        int[] cache = new int[2];
        char[] c = s.toCharArray();
        int ans = 0, len = c.length, l = 0;
        for (int i = 0; i < len; i++) {
            cache[c[i] - '0'] += 1;
            while (cache[0] > k && cache[1] > k) {
                cache[c[l++] - '0'] -= 1;
            }
            ans += i - l + 1;
        }
        return ans;
    }
}
