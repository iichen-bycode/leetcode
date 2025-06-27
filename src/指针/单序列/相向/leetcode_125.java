package 指针.单序列.相向;

/*
如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。

字母和数字都属于字母数字字符。

给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。



示例 1：

输入: s = "A man, a plan, a canal: Panama"
输出：true
解释："amanaplanacanalpanama" 是回文串。
示例 2：

输入：s = "race a car"
输出：false
解释："raceacar" 不是回文串。
示例 3：

输入：s = " "
输出：true
解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
由于空字符串正着反着读都一样，所以是回文串。


提示：

1 <= s.length <= 2 * 105
s 仅由可打印的 ASCII 字符组成
 */
public class leetcode_125 {
    public static void main(String[] args) {
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(isPalindrome("race a car"));
//        System.out.println(isPalindrome(" "));
//        System.out.println(isPalindrome("aaa.,uuuu"));
        System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {
        /*
            a = 97      A = 65 32
            z = 122     Z = 90
         */
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char lc = s.charAt(l);
            while (!(65 <= lc && lc <= 90 || 97 <= lc && lc <= 122 || 48 <= lc && lc <= 57) && l < r) {
                l++;
                lc = s.charAt(l);
            }
            char rc = s.charAt(r);
            while (!(65 <= rc && rc <= 90 || 97 <= rc && rc <= 122 || 48 <= rc && rc <= 57) && l < r) {
                r--;
                rc = s.charAt(r);
            }
            boolean lcIsNumber = isNumber(lc);
            boolean rcIsNumber = isNumber(rc);
            if (!(lc == rc || (!lcIsNumber && !rcIsNumber && (lc + 32 == rc || lc == 32 + rc)))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static boolean isNumber(int num) {
        return 48 <= num && num <= 57;
    }
}
