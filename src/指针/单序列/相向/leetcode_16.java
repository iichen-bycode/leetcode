package 指针.单序列.相向;
/*
给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。

返回这三个数的和。

假定每组输入只存在恰好一个解。



示例 1：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)。
示例 2：

输入：nums = [0,0,0], target = 1
输出：0
解释：与 target 最接近的和是 0（0 + 0 + 0 = 0）。


提示：

3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-10^4 <= target <= 10^4
 */

import java.util.Arrays;

// 最接近的三数之和  类同15
public class leetcode_16 {
    public static void main(String[] args) {
        // nums = [-1,2,1,-4], target = 1       2
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(threeSumClosest(new int[]{0, 1, 2}, 3));
        // nums = [0,0,0], target = 1           0
        System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        /*
            -4 -1 1 2       target=1

            -4: (-4-1 = -5)
                -1 + 2 - 5 = -4 > -5 则 l++
                1 +2 - 5 > -2 >-5 l++
                min = -2

           -1:  (-1-1 = -2)
                1  + 2 -2 = 1 >-2
                min = 1

            ans = abs(min) = 1
            Math.min(nums[i] + nums[j] + nums[k] - target)


            1 2 3 4  1

            2


         */
        Arrays.sort(nums);
        int ans = 0, min = Integer.MAX_VALUE, n = nums.length, l = 0, r = n - 1;
        for (int i = 0; i < n; i++) {
//            -4 -1 1 2       target=1
            l = i + 1;
            r = n - 1;
            // 优化重复的
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[l + 1];
                if(sum > target) { // 最左边的三个值都大于目标了 r指针就不用了
                    int abs = Math.abs(sum - target);
                    if(abs <= min) {
                        min = abs;
                        ans = sum;
                    }
                    break;
                }
                sum = nums[i] + nums[r] + nums[r-1]; // 最右侧最大的 都小于目标了 l指针就不要了
                if(sum < target) {
                    int abs = Math.abs(sum - target);
                    if(abs <= min) {
                        min = abs;
                        ans = sum;
                    }
                    break;
                }

                // 初版直接这里就行 上边额外 判断的
                sum = nums[i] + nums[l] + nums[r];
                int abs = Math.abs(sum - target);
                if (abs <= min) {
                    min = abs;
                    ans = sum;
                }
                // 关键这里 总和大于目标 像更接近 目标 则需要 r--,
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    return sum;
                }
            }
        }
        return ans;
    }
}
