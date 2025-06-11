package 滑动窗口;

/*
你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 kk 。

为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。

如果 kk > 0 ，将第 i 个数字用 接下来 kk 个数字之和替换。
如果 kk < 0 ，将第 i 个数字用 之前 kk 个数字之和替换。
如果 kk == 0 ，将第 i 个数字用 0 替换。
由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。

给你 循环 数组 code 和整数密钥 kk ，请你返回解密后的结果来拆除炸弹！



示例 1：

输入：code = [5,7,1,4], kk = 3
7 1 4   5 7 1 4
输出：[12,10,16,13]
解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。
示例 2：

输入：code = [1,2,3,4], kk = 0
输出：[0,0,0,0]
解释：当 kk 为 0 时，所有数字都被 0 替换。
示例 3：

输入：code = [2,4,9,3], kk = -2
 9 3  2 4 9 3
输出：[12,5,6,13]
解释：解密后的密码为 [3+9, 2+3, 4+2, 9+4] 。注意到数组是循环连接的。如果 kk 是负数，那么和为 之前 的数字。


提示：

n == code.length
1 <= n <= 100
1 <= code[i] <= 100
-(n - 1) <= kk <= n - 1
 */
public class leetcode_1652 {
    public static void main(String[] args) {
        int[] a = decrypt(new int[]{5, 7, 1, 4}, 3);
        // 7 1 4   5 7 1 4
        for (int j : a) {
            System.out.print(j + ","); // [12,10,16,13]
        }
        System.out.println();
        int[] a2 = decrypt(new int[]{5, 2, 2, 3, 1}, -3);  //[12,5,6,13]
        //  2231 52231     [7,6,9,8,9]
        // 231 52231    [6,9,8,9,7]
        for (int j : a2) {
            System.out.print(j + ",");
        }
    }

    public static int[] decrypt(int[] code, int k) {
        int len = code.length;
        if (k == 0)
            return new int[len];
        int kk = Math.abs(k);
        int[] s = new int[2 * len - 1];
        int a = 0;
        // 填充计算数组
        for (int i = k > 0 ? 1 : len - kk; i < len; i++) {
            s[a++] = code[i];
        }
        for (int j : code) {
            s[a++] = j;
        }
        int count = 0;
        for (int i = 0; i < len + kk - 1; i++) {
            count += s[i];
            if (i < kk - 1) {
                continue;
            }
            code[i - kk + 1] = count;
            count -= s[i - kk + 1];
        }
        return code;
    }
}
