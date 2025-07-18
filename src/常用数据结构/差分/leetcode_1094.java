package 常用数据结构.差分;

/*
车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）

给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。

当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。



示例 1：

输入：trips = [[2,1,5],[3,3,7]], capacity = 4
输出：false
示例 2：

输入：trips = [[2,1,5],[3,3,7]], capacity = 5
输出：true


提示：

1 <= trips.length <= 1000
trips[i].length == 3
1 <= numPassengersi <= 100
0 <= fromi < toi <= 1000
1 <= capacity <= 105
https://leetcode.cn/problems/car-pooling/description/
 */
public class leetcode_1094 {
    public static void main(String[] args) {
        /*
            输入：trips = [[2,1,5],[3,3,7]], capacity = 4
            输出：false
            示例 2：
            
            输入：trips = [[2,1,5],[3,3,7]], capacity = 5
            输出：true
         */
        System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));
        System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        // from 上车 对i区间+, to对i区间-
        int[] d = new int[1001]; // 1000个站点
        for (int[] trip : trips) {
            d[trip[1]] += trip[0];
            d[trip[2]] -= trip[0];
        }
        // 累加获取原数组大小
        int count = 0;
        for (int j : d) {
            count += j;
            if (count > capacity) {
                return false;
            }
        }
        return true;
    }
}
