package 指针.单序列.相向;

/*
编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。



示例 1：

输入：s = ['h','e','l','l','o']
输出：['o','l','l','e','h']
示例 2：

输入：s = ['H','a','n','n','a','h']
输出：['h','a','n','n','a','H']


提示：

1 <= s.length <= 105
s[i] 都是 ASCII 码表中的可打印字符
 */
public class leetcode_344 {
    public static void main(String[] args) {
        reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
        reverseString(new char[]{'H', 'a', 'n', 'n', 'a', 'h'});
    }

    public static void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--;
        }
    }
}
