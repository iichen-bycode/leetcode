package 指针.单序列.相向;
/*
小力将 N 个零件的报价存于数组 nums。小力预算为 target，假定小力仅购买两个零件，要求购买零件的花费不超过预算，请问他有多少种采购方案。

注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1

示例 1：

输入：nums = [2,5,3,5], target = 6

输出：1

解释：预算内仅能购买 nums[0] 与 nums[2]。

示例 2：

输入：nums = [2,2,1,9], target = 10

输出：4

解释：符合预算的采购方案如下： nums[0] + nums[1] = 4 nums[0] + nums[2] = 3 nums[1] + nums[2] = 3 nums[2] + nums[3] = 10

提示：

2 <= nums.length <= 10^5
1 <= nums[i], target <= 10^5
 */

import java.util.Arrays;

//采购方案 同2824
public class leetcode_28 {
    public static void main(String[] args) {
        System.out.println(purchasePlans(new int[]{2, 5, 3, 5}, 6));    // 1
        System.out.println(purchasePlans(new int[]{2, 2, 1, 9}, 10));   // 4
    }

    public static int purchasePlans2(int[] nums, int target) {
        int MOD = 1_000_000_007;
        Arrays.sort(nums);
        // 1 2 2 9
        int l = 0, n = nums.length, r = n - 1, ans = 0;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum > target) {
                r--;
            } else {
                ans = (ans + r - l) % MOD;
                l++;
            }
        }
        return ans;
    }



    public static int purchasePlans(int[] nums, int target) {
        int[] prefixSum = new int[target];

        for (int num : nums) {
            if (num < target) {
                prefixSum[num]++;
            }
        }
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }
        /*
            1   2   2   9       target = 6

            0   1   2   3   4   5
            0   1   2   0   0   0

        prefixSum    0   1   3   3   3   3
         */
        long ans = 0;
        for (int num : nums) {
            // 2 2 1 9      target = 6
            if (num >= target) {
                continue;
            }
            ans += prefixSum[target - num];
            if (num <= target - num) {
                ans--;
            }
        }
        return (int) ((ans >> 1) % 1000000007);
    }
}
