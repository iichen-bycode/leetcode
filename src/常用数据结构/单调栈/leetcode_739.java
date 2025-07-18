package 常用数据结构.单调栈;
/*
给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。



示例 1:

输入: temperatures = [73,74,75,71,69,72,76,73]
输出: [1,1,4,2,1,1,0,0]
示例 2:

输入: temperatures = [30,40,50,60]
输出: [1,1,1,0]
示例 3:

输入: temperatures = [30,60,90]
输出: [1,1,0]


提示：

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100
 */

import helper.Utils;
import jdk.jshell.execution.Util;

import java.util.Deque;
import java.util.LinkedList;

// 每日温度
public class leetcode_739 {
    public static void main(String[] args) {
        Utils.print(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        Utils.print(dailyTemperatures(new int[]{30, 40, 50, 60}));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new LinkedList<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && temperatures[deque.peekLast()] <= temperatures[i]) {
                deque.pollLast();
            }
            ans[i] = deque.isEmpty() ? 0 : deque.peekLast() - i;
            deque.offerLast(i);
        }
        return ans;
    }

    public static int[] dailyTemperatures3(int[] temperatures) {
        Deque<Integer> deque = new LinkedList<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        int index = 0;
        deque.offerLast(0);
        for (int i = 1; i < n; i++) {
            while (!deque.isEmpty()) {
                if (temperatures[deque.peekFirst()] < temperatures[i]) {
                    ans[index++] = i - deque.peekFirst();
                    deque.pollFirst();
                } else {
                    break;
                }
            }
            deque.offerLast(i);
        }
        return ans;
    }

    public static int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int r = i + 1;
            while (r < n) {
                if (temperatures[r] > temperatures[i]) {
                    ans[i] = r - i;
                    break;
                }
                r++;
            }
        }
        return ans;
    }
}
