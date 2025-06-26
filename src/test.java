import helper.Utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        /*
            8   4   2   1
            3:  11
            4: 100
         */
//        System.out.println(1 << 2);
//        System.out.println(1 << 3);
//        System.out.println((1 << 2) & (1 << 3));
//        System.out.println(numberOfSubstrings("abcabbb"));
        // 16 8 4 2 1
        /*
            1000

            1111
         */
        //        [[4,8],[3,6],[10,20],[15,30]]
//        [[4,5],[7,8]]
        int[] l = new int[26];
        int[] r = new int[26];
        l[0] = 2;
        l[1] = 2;
        r[0] = 2;
        r[1] = 2;
        int[] res = Arrays.stream(l).filter(x -> Arrays.stream(r).anyMatch(y -> y!= 0 && y == x)).distinct().toArray();
        Utils.print(res);

        // 0    1   2   3   4
        /*
            0000
            0001
            0010
            0011
         */
    }


    public static int numberOfSubstrings(String S) {
        char[] s = S.toCharArray();

        int ans = 0;
        int left = 0;
        int[] cnt = new int[3];
        for (char c : s) {
            cnt[c - 'a']++;
            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                cnt[s[left] - 'a']--;
                left++;
            }
            ans += left;
        }
        return ans;
    }
}
