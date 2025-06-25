package 常用数据结构.枚举技巧;

import java.util.Arrays;
import java.util.HashMap;

/*
给你一个整数数组 cards ，其中 cards[i] 表示第 i 张卡牌的 值 。如果两张卡牌的值相同，则认为这一对卡牌 匹配 。

返回你必须拿起的最小连续卡牌数，以使在拿起的卡牌中有一对匹配的卡牌。如果无法得到一对匹配的卡牌，返回 -1 。



示例 1：

输入：cards = [3,4,2,3,4,7]
输出：4
解释：拿起卡牌 [3,4,2,3] 将会包含一对值为 3 的匹配卡牌。注意，拿起 [4,2,3,4] 也是最优方案。
示例 2：

输入：cards = [1,0,5,3]
输出：-1
解释：无法找出含一对匹配卡牌的一组连续卡牌。


提示：

1 <= cards.length <= 105
0 <= cards[i] <= 106
 */
public class leetcode_2260 {
    public static void main(String[] args) {
        System.out.println(minimumCardPickup(new int[]{3, 4, 2, 3, 4, 7}));
        System.out.println(minimumCardPickup(new int[]{1, 0, 5, 3}));
        System.out.println(minimumCardPickup(new int[]{0, 0}));
        System.out.println(minimumCardPickup(new int[]{77, 10, 11, 51, 69, 83, 33, 94, 0, 42, 86, 41, 65, 40, 72, 8, 53, 31, 43, 22, 9, 94, 45, 80, 40, 0, 84, 34, 76, 28, 7, 79,
                80, 93, 20, 82, 36, 74, 82, 89, 74, 77, 27, 54, 44, 93, 98, 44, 39, 74, 36, 9, 22, 57, 70, 98, 19, 68, 33, 68, 49, 86, 20, 50, 43}));
    }

    public static int minimumCardPickup(int[] cards) {
        int max = 0;
        int len = cards.length, ans = Integer.MAX_VALUE;
        for (int card : cards) {
            max = Math.max(max, card);
        }
        int[] f = new int[max + 1];
        Arrays.fill(f, -1);
        for (int i = 0; i < len; i++) {
            int num = cards[i];
            if (f[num] != -1) {
                ans = Math.min(ans, i + 1 - f[num]);
            }
            f[num] = i;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int minimumCardPickup2(int[] cards) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = cards.length, ans = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int num = cards[i];
            if (map.containsKey(num)) {
                ans = Math.min(ans, i + 1 - map.get(num));
            }
            map.put(num, i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
