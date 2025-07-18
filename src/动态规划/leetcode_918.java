package 动态规划;
/*
给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。

环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。

子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。



示例 1：

输入：nums = [1,-2,3,-2]
输出：3
解释：从子数组 [3] 得到最大和 3
示例 2：

输入：nums = [5,-3,5]
输出：10
解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
示例 3：

输入：nums = [3,-2,2,-3]
输出：3
解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3


提示：

n == nums.length
1 <= n <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
 */

import java.util.Deque;
import java.util.LinkedList;

// 环形子数组的最大和
public class leetcode_918 {
    public static void main(String[] args) {
//        System.out.println(maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(maxSubarraySumCircular(new int[]{5, -3, 5}));
        /*
            5 -3 5 5 -3 5
            0 1  2 3 4  5


            5
            2
            2 7
            2 7 14
            2 7 11
            2 7 15
         */
//        System.out.println(maxSubarraySumCircular(new int[]{3, -2, 2, -3}));
    }

    // 单调栈做法
    public static int maxSubarraySumCircular(int[] nums) {
        int n = nums.length, ans = nums[0], sum = nums[0];
        Deque<int[]> deque = new LinkedList<>();
        deque.offerLast(new int[]{0, nums[0]});
        for (int i = 1; i < 2 * n; i++) {
            // 超出 n大小移除 元素保持队列单调栈元素 为n个
            while (!deque.isEmpty() && deque.peekFirst()[0] < i - n) {
                deque.pollFirst();
            }
            sum += nums[i % n];
            // 前缀和 S(i) - S(j)  所以S(j) 要越小越好 所哟下面是剔除大的值
            ans = Math.max(ans, sum - deque.peekFirst()[1]);
            while (!deque.isEmpty() && deque.peekLast()[1] >= sum) {
                deque.pollLast();
            }
            deque.offerLast(new int[]{i, sum});
        }

        return ans;
    }


    public static int maxSubarraySumCircular2(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE, min = 0, cmin = 0, cmax = 0;
        /*
            分情况：
                在中间 直接同53
                在两侧即跨循环，则 sum - 中间最小和
         */
        for (int num : nums) {
            // 记录当前最小和
            cmin = Math.min(cmin, 0) + num;
            min = Math.min(min, cmin);
            // 记录当前最大和
            cmax = Math.max(cmax, 0) + num;
            max = Math.max(max, cmax);
            sum += num;
        }
        return sum == min ? max : Math.max(sum - min, max);
    }
}
