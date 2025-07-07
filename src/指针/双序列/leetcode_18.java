package 指针.双序列;
/*
小扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，一维整型数组 drinks 中记录了每种饮料的价格。小扣的计划选择一份主食和一款饮料，且花费不超过 x 元。请返回小扣共有多少种购买方案。

注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1

示例 1：

输入：staple = [10,20,5], drinks = [5,5,2], x = 15

输出：6

解释：小扣有 6 种购买方案，所选主食与所选饮料在数组中对应的下标分别是： 第 1 种方案：staple[0] + drinks[0] = 10 + 5 = 15； 第 2 种方案：staple[0] + drinks[1] = 10 + 5 = 15； 第 3 种方案：staple[0] + drinks[2] = 10 + 2 = 12； 第 4 种方案：staple[2] + drinks[0] = 5 + 5 = 10； 第 5 种方案：staple[2] + drinks[1] = 5 + 5 = 10； 第 6 种方案：staple[2] + drinks[2] = 5 + 2 = 7。

示例 2：

输入：staple = [2,1,1], drinks = [8,9,5,1], x = 9

输出：8

解释：小扣有 8 种购买方案，所选主食与所选饮料在数组中对应的下标分别是： 第 1 种方案：staple[0] + drinks[2] = 2 + 5 = 7； 第 2 种方案：staple[0] + drinks[3] = 2 + 1 = 3； 第 3 种方案：staple[1] + drinks[0] = 1 + 8 = 9； 第 4 种方案：staple[1] + drinks[2] = 1 + 5 = 6； 第 5 种方案：staple[1] + drinks[3] = 1 + 1 = 2； 第 6 种方案：staple[2] + drinks[0] = 1 + 8 = 9； 第 7 种方案：staple[2] + drinks[2] = 1 + 5 = 6； 第 8 种方案：staple[2] + drinks[3] = 1 + 1 = 2；

提示：

1 <= staple.length <= 10^5
1 <= drinks.length <= 10^5
1 <= staple[i],drinks[i] <= 10^5
1 <= x <= 2*10^5
 */

import java.util.Arrays;

// 早餐组合
public class leetcode_18 {
    public static void main(String[] args) {
        /*
        输入：staple = [10,20,5], drinks = [5,5,2], x = 15

        输出：6

        输入：staple = [2,1,1], drinks = [8,9,5,1], x = 9

        输出：8
         */
        System.out.println(breakfastNumber(new int[]{10, 20, 5}, new int[]{5, 5, 2}, 15));
        System.out.println(breakfastNumber(new int[]{2, 1, 1}, new int[]{8, 9, 5, 1}, 9));
    }

    public static int breakfastNumber2(int[] staple, int[] drinks, int x) {

        int MOD = 1_000_000_007;
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int lastValIndex = -1;
        int ans = 0;
        for (int s : staple) {
            int r = lastValIndex == -1 ? drinks.length - 1 : lastValIndex;
            if (s >= x)
                continue;
            while (r >= 0 && drinks[r] > x - s) {
                r--;
            }
            lastValIndex = r;
            ans = (ans + r + 1) % MOD;
        }
        return ans;
    }

    public static int breakfastNumber(int[] staple, int[] drinks, int x) {
      /*
            前缀和：
            2, 1, 1         8, 9, 5, 1
            0 2 1 0 0 0 0 0 0 0
            0 2 3 3 3 3 3 3 3 3

         */
        int count = 0;
        //记录staple价格为p的方案
        int[] dict = new int[x + 1];
        for (int p : staple) {
            if (p <= x) {
                dict[p]++;
            }
        }
        int sum = 0;
        //计算前缀和，得到staple中价格低于等于i的方案数量
        for (int i = 1; i < x + 1; i++) {
            dict[i] += dict[i - 1];
        }
        //根据前缀和，返回dict中价格低于等于x - p可行的方案数量
        for (int p : drinks) {
            if (p <= x) {
                count += dict[x - p];
                //减少取余次数小技巧
                if (count >= 1000000007) {
                    count -= 1000000007;
                }
                // count %= 1000000007;
            }
        }
        return count;
    }
}
