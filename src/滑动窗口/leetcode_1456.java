package 滑动窗口;

/*
给你字符串 s 和整数 k 。

请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。

英文中的 元音字母 为（a, e, i, o, u）。



示例 1：

输入：s = "abciiidef", k = 3
输出：3
解释：子字符串 "iii" 包含 3 个元音字母。
示例 2：

输入：s = "aeiou", k = 2
输出：2
解释：任意长度为 2 的子字符串都包含 2 个元音字母。
示例 3：

输入：s = "leetcode", k = 3
输出：2
解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
示例 4：

输入：s = "rhythms", k = 4
输出：0
解释：字符串 s 中不含任何元音字母。
示例 5：

输入：s = "tryhard", k = 4
输出：1


提示：

1 <= s.length <= 10^5
s 由小写英文字母组成
1 <= k <= s.length
 */
public class leetcode_1456 {
    public static void main(String[] args) {
        // 英文中的 元音字母 为（a, e, i, o, u）。
        System.out.println(maxVowels2("abciiidef", 3));
        System.out.println(maxVowels2("aeiou", 2));
        System.out.println(maxVowels2("leetcode", 3));
        System.out.println(maxVowels2("rhythms", 4));
        System.out.println(maxVowels2("tryhard", 4));
        System.out.println(maxVowels2("weallloveyou", 7));
    }

    public static int maxVowels2(String s, int k) {
        int ans = 0,cur = 0;
        int left = 0,right = 0,n = s.length();
        while (right < n) {
            char c = s.charAt(right);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cur++;
            }
            while (right - left >= k - 1) {
                ans = Math.max(ans,cur);
                char c1 = s.charAt(left);
                if (c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u') {
                    cur--;
                }
                left++;
            }
            right++;
        }
        return ans;
    }
    public static int maxVowels(String s, int k) {
        int ans = 0,cur = 0;
        for (int l = 0; l < s.length(); l++) {
            char c = s.charAt(l);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cur++;
            }
            if(l < k - 1) {
                continue;
            }
            ans = Math.max(ans,cur);
            if(ans == k)
                break;
            // 最开始的一个元素 即移除 k 窗口的元素
            char last = s.charAt(l - k + 1);
            if (last == 'a' || last == 'e' || last == 'i' || last == 'o' || last == 'u') {
                cur--;
            }
        }
        return ans;
    }
}
