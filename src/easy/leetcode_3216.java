package easy;

/**
 * 给你一个仅由数字组成的字符串 s，在最多交换一次 相邻 且具有相同 奇偶性 的数字后，返回可以得到的字典序最小的字符串。
 *
 * 如果两个数字都是奇数或都是偶数，则它们具有相同的奇偶性。例如，5 和 9、2 和 4 奇偶性相同，而 6 和 9 奇偶性不同。
 *
 *
 *
 * 示例 1：
 *
 * 输入： s = "45320"
 *
 * 输出： "43520"
 *
 * 解释：
 *
 * s[1] == '5' 和 s[2] == '3' 都具有相同的奇偶性，交换它们可以得到字典序最小的字符串。
 *
 * 示例 2：
 *
 * 输入： s = "001"
 *
 * 输出： "001"
 *
 * 解释：
 *
 * 无需进行交换，因为 s 已经是字典序最小的。
 *
 *
 *
 * 提示：
 *
 * 2 <= s.length <= 100
 * s 仅由数字组成。
 */
public class leetcode_3216 {
    public static void main(String[] args) {
//        String s = "45320";
        String s = "10";
        System.out.println(getSmallestString(s));
    }

    public static String getSmallestString(String s) {
        if(s.length() <= 1)
            return s;
        char[] array = s.toCharArray();
        for (int i = 1; i < array.length; i++) {
            char one = array[i - 1];
            char cur = array[i];
            if(cur < one && (cur % 2 == one % 2)) {
                char t = array[i - 1];
                array[i - 1] = array[i];
                array[i] = t;
                break;
            }
        }
        return String.valueOf(array);
    }
}
