package 指针.单序列.相向;

/*
给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：

0 <= a, b, c, d < n
a、b、c 和 d 互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案 。



示例 1：

输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
示例 2：

输入：nums = [2,2,2,2,2], target = 8
输出：[[2,2,2,2]]


提示：

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
 */

import helper.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 四数之和
public class leetcode_18 {
    public static void main(String[] args) {
        /*
        输入：nums = [1,0,-1,0,-2,2], target = 0
        输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        示例 2：

        输入：nums = [2,2,2,2,2], target = 8
        输出：[[2,2,2,2]]
         */
//        Utils.printList2(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
//        Utils.printList2(fourSum(new int[]{2, 2, 2, 2, 2}, 8));
        Utils.printList2(fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11));
        Utils.printList2(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int l = 0, r = 0, n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if (nums[0] > 0 && nums[0] > target)
            return ans;
        /*
            -2 -1 0 0 1 2       0

             2 2 2 2 2          8

            -12
             -5 -4 -3 -2 1 3 3 5    -11
             [[-5,-4,-3,1]]
         */
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[n - 1] + nums[n - 2] + nums[n - 3] + nums[n - 4] < target) {
                continue;
            }
            for (int j = i + 1; j < n  - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) {
                    continue;
                }
                l = j + 1;
                r = n - 1;
                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        ans.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[r] == nums[r - 1])
                            r--;
                        while (l < r && nums[l] == nums[l + 1])
                            l++;
                        l++;
                        r--;
                    } else if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return ans;
    }
}
