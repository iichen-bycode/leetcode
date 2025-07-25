package 常用数据结构.单调栈;
/*
给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。

商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。

请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。



示例 1：

输入：prices = [8,4,6,2,3]
输出：[4,2,4,2,3]
解释：
商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
商品 3 和 4 都没有折扣。
示例 2：

输入：prices = [1,2,3,4,5]
输出：[1,2,3,4,5]
解释：在这个例子中，所有商品都没有折扣。
示例 3：

输入：prices = [10,1,1,6]
输出：[9,0,1,6]


提示：

1 <= prices.length <= 500
1 <= prices[i] <= 10^3
 */

import helper.Utils;
import jdk.jshell.execution.Util;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// 商品折扣后的最终价格
public class leetcode_1475 {
    public static void main(String[] args) {
        Utils.print(finalPrices(new int[]{8, 4, 6, 2, 3}));
        Utils.print(finalPrices(new int[]{10, 1, 1, 6}));
        Utils.print(finalPrices(new int[]{8, 4, 6, 2, 3})); //4,2,4,2,3
        Utils.print(finalPrices(new int[]{1,2,3,4,5})); //4,2,4,2,3
    }

    public static int[] finalPrices2(int[] prices) {
        int n = prices.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && prices[deque.peek()] > prices[i]) {
                deque.pop();
            }
            if (!deque.isEmpty()) {
                ans[i] = prices[i] - prices[deque.peek()];
            }
            ans[i] = prices[i];
            deque.push(i);
        }
        return ans;
    }

    public static int[] finalPrices(int[] prices) {
        int n = prices.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty()) {
                if (prices[deque.peek()] >= prices[i]) {
                    prices[deque.peek()] = prices[deque.peek()] - prices[i];
                    deque.pop();
                } else {
                    break;
                }
            }
            deque.push(i);
        }
        return prices;
    }
}
