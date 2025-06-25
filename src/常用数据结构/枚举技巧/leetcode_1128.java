package 常用数据结构.枚举技巧;

import java.util.HashMap;
import java.util.HashSet;

/*
给你一组多米诺骨牌 dominoes 。

形式上，dominoes[i] = [a, b] 与 dominoes[j] = [c, d] 等价 当且仅当 (a == c 且 b == d) 或者 (a == d 且 b == c) 。即一张骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌。

在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。



示例 1：

输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
输出：1
示例 2：

输入：dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
输出：3


提示：

1 <= dominoes.length <= 4 * 104
dominoes[i].length == 2
1 <= dominoes[i][j] <= 9

https://leetcode.cn/problems/number-of-equivalent-domino-pairs/description/
 */
public class leetcode_1128 {
    public static void main(String[] args) {
        //[[1,2],[2,1],[3,4],[5,6]]
        //[[1,2],[1,2],[1,1],[1,2],[2,2]]
        System.out.println(numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}));
        System.out.println(numEquivDominoPairs(new int[][]{{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}}));
        // [1,1],[2,2],[1,1],[1,2],[1,2],[1,1]
        System.out.println(numEquivDominoPairs(new int[][]{{1, 1}, {2, 2}, {1, 1}, {1, 2}, {1, 2}, {1, 1}}));
        //[2,1],[1,2],[1,2],[1,2],[2,1],[1,1],[1,2],[2,2]
        System.out.println(numEquivDominoPairs(new int[][]{{2, 1}, {1, 2}, {1, 2}, {1, 2}, {2, 1}, {1, 1}, {1, 2}, {2, 2}}));
    }

    // 1 3 4 15
    public static int numEquivDominoPairs(int[][] dominoes) {
        int[] f = new int[100];
        int ans = 0;
        for (int[] dominoe : dominoes) {
            int max = Math.max(dominoe[0], dominoe[1]);
            int min = Math.min(dominoe[0], dominoe[1]);
            int index = max * 10 + min;
            ans += f[index];
            f[index] += 1;
        }
        return ans;
    }

    public static int numEquivDominoPairs2(int[][] dominoes) {
        int ans = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int[] dominoe : dominoes) {
            String c = dominoe[0] >= dominoe[1] ? dominoe[0] + String.valueOf(dominoe[1]) : dominoe[1] + String.valueOf(dominoe[0]);
            if (map.containsKey(c)) {
                ans += map.get(c);
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return ans;
    }
}
