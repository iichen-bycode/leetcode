package 贪心;

import java.util.Arrays;

/*
给你一个长度为 n 的数组 apple 和另一个长度为 m 的数组 capacity 。

一共有 n 个包裹，其中第 i 个包裹中装着 apple[i] 个苹果。同时，还有 m 个箱子，第 i 个箱子的容量为 capacity[i] 个苹果。

请你选择一些箱子来将这 n 个包裹中的苹果重新分装到箱子中，返回你需要选择的箱子的 最小 数量。

注意，同一个包裹中的苹果可以分装到不同的箱子中。



示例 1：

输入：apple = [1,3,2], capacity = [4,3,1,5,2]
输出：2
解释：使用容量为 4 和 5 的箱子。
总容量大于或等于苹果的总数，所以可以完成重新分装。
示例 2：

输入：apple = [5,5,5], capacity = [2,4,2,7]
输出：4
解释：需要使用所有箱子。


提示：

1 <= n == apple.length <= 50
1 <= m == capacity.length <= 50
1 <= apple[i], capacity[i] <= 50
输入数据保证可以将包裹中的苹果重新分装到箱子中。
https://leetcode.cn/problems/apple-redistribution-into-boxes/description/
 */
public class leetcode_3074 {
    public static void main(String[] args) {
        System.out.println(minimumBoxes(new int[]{1, 3, 5}, new int[]{4, 3, 1, 5, 2}));// 2
        System.out.println(minimumBoxes(new int[]{5, 5, 5}, new int[]{2, 4, 2, 7})); // 4
    }

    // 往最大的篮子里加
    public static int minimumBoxes(int[] apple, int[] capacity) {
        /*
            1 2 3
            1 2 3 4 5

            5 5 5
            2 2 4 7
        */
        int sum = 0;
        int m = capacity.length;
        for (int j : apple) {
            sum += j;
        }
        Arrays.sort(capacity);
        for (int i = m - 1; i >= 0; i--) {
            sum -= capacity[i];
            if (sum <= 0) {
                return m - i;
            }
        }
        return 0;
    }
}
