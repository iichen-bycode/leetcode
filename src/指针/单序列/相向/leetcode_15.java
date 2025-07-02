package 指针.单序列.相向;
/*
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。





示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
示例 2：

输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。
示例 3：

输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。


提示：

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */

import helper.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 三数之和
public class leetcode_15 {
    public static void main(String[] args) {
        // -1,0,1,2,-1,-4       [[-1,-1,2],[-1,0,1]]
        // [0,1,1]      []
        //[0,0,0]      [[0,0,0]]
        Utils.printList2(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println("-----------------------------------");
        Utils.printList2(threeSum(new int[]{0, 0, 0, 0}));
        System.out.println("-----------------------------------");
        Utils.printList2(threeSum(new int[]{0, 1, 1}));
        System.out.println("-----------------------------------");
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        return new ArrayList<>(new ArrayList<>());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1;
            int r = n;
            // 0 0 0 0
            // -4 -1 -1 0 1 2
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(List.of(nums[i], nums[l], nums[r]));
                    while (r > l && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    while (r > l && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    // nums[l] 与 nums[r]  且重复数据处理后，则下一个就是 l++ r--的元素匹配
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }


}
