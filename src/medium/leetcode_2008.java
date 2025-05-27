package medium;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

/*
你驾驶出租车行驶在一条有 n 个地点的路上。这 n 个地点从近到远编号为 1 到 n ，你想要从 1 开到 n ，通过接乘客订单盈利。你只能沿着编号递增的方向前进，不能改变方向。

乘客信息用一个下标从 0 开始的二维数组 rides 表示，其中 rides[i] = [starti, endi, tipi] 表示第 i 位乘客需要从地点 starti 前往 endi ，愿意支付 tipi 元的小费。

每一位 你选择接单的乘客 i ，你可以 盈利 endi - starti + tipi 元。你同时 最多 只能接一个订单。

给你 n 和 rides ，请你返回在最优接单方案下，你能盈利 最多 多少元。

注意：你可以在一个地点放下一位乘客，并在同一个地点接上另一位乘客。



示例 1：

输入：n = 5, rides = [[2,5,4],[1,5,1]]
输出：7
解释：我们可以接乘客 0 的订单，获得 5 - 2 + 4 = 7 元。
示例 2：

输入：n = 20, rides = [[1,6,1],[3,10,2],[10,12,3],[11,12,2],[12,15,2],[13,18,1]]
输出：20
解释：我们可以接以下乘客的订单：
- 将乘客 1 从地点 3 送往地点 10 ，获得 10 - 3 + 2 = 9 元。
- 将乘客 2 从地点 10 送往地点 12 ，获得 12 - 10 + 3 = 5 元。
- 将乘客 5 从地点 13 送往地点 18 ，获得 18 - 13 + 1 = 6 元。
我们总共获得 9 + 5 + 6 = 20 元。


提示：

1 <= n <= 105
1 <= rides.length <= 3 * 104
rides[i].length == 3
1 <= starti < endi <= n
1 <= tipi <= 105
 */
// 动态规划
public class leetcode_2008 {
    public static void main(String[] args) {
        long res = maxTaxiEarnings(20,new int[][]{new int[]{1,6,1},new int[]{3,10,2},new int[]{10,12,3},new int[]{11,12,2},new int[]{12,15,2},new int[]{13,18,1}});
//        long res = maxTaxiEarnings(5,new int[][]{new int[]{2,5,4},new int[]{1,5,1}});
        System.out.println(res);
    }

    /*
        dp[i]表示从i上车 赚的钱则：
            i没人下车则 dp[i] = dp[i-1]
            i有人下车则 需要考虑当前i下次的对应的 start上车时可以赚钱的钱 {start,end,tip}： dp[start] + end + tip - start
        所以 dp[i] = max(dp[i],dp[start] + end + tip - start)
     */
    public static long maxTaxiEarnings(int n, int[][] rides) {
        // 注意使用long
        long[] dp = new long[n+1];
        // 存储每个节点
        ArrayList<int []>[] cache = new ArrayList[n+1];
        for (int[] ride : rides) {
            int start = ride[0];
            int end = ride[1];
            int tip = ride[2];
            if(cache[end] == null) {
                cache[end] = new ArrayList<>();
            }
            cache[end].add(new int[]{start,tip});
        }
        // 遍历 n个上车点
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            if(cache[i] != null) {
                for (int[] p : cache[i]) {
                    int start = p[0];
                    int tip = p[1];
                    dp[i] = Math.max(dp[i], dp[start] + i + tip - start);
                }
            }
        }
        return dp[n];
    }
}
