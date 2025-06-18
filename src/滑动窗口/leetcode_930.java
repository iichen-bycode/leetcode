package 滑动窗口;

import java.util.HashMap;

/*
给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。

子数组 是数组的一段连续部分。



示例 1：

输入：nums = [1,0,1,0,1], goal = 2
// 0 1 1 2 2 3
输出：4
解释：
有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
示例 2：

输入：nums = [0,0,0,0,0], goal = 0
输出：15


提示：

1 <= nums.length <= 3 * 104
nums[i] 不是 0 就是 1
0 <= goal <= nums.length
 */
public class leetcode_930 {
    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
        System.out.println(numSubarraysWithSum2(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(numSubarraysWithSum2(new int[]{0, 0, 0, 0, 0}, 0));
    }

    // 前缀和数组
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int len = nums.length, ans = 0;
        int[] sums = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sums[i + 1] = nums[i] + sums[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // 即nums中存在一个数就是 goal
        map.put(0, 1);
        for (int i = 0; i < len; i++) {
            int j = sums[i + 1], t = j - goal;
            // 某个和出现的次数 即需要的合法t出现次数 累加答案
            ans += map.getOrDefault(t, 0);
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
//        for (int i = 0; i < len + 1; i++) {
//            //   1, 0, 1, 0, 1
//            // 0 1  1  2  2  3
//            for (int j = i + 1; j < len + 1; j++) {
//                if (sums[j] - sums[i] == goal) {
//                    ans += 1;
//                }
//            }
//        }
        return ans;
    }

    // 恰好型滑动窗口
    public static int numSubarraysWithSum2(int[] nums, int goal) {
        int l1 = 0, l2 = 0, len = nums.length, ans = 0, s1 = 0, s2 = 0;
        for (int i = 0; i < len; i++) {
            s1 += nums[i];
            s2 += nums[i];
            while (s1 > goal && l1 <= i) {
                s1 -= nums[l1++];
            }
            while (s2 >= goal && l2 <= i) {
                s2 -= nums[l2++];
            }
            ans += l2 - l1;
        }
        return ans;
    }
}
