package 动态规划;

/*
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。



示例 1：

输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2：

输入：nums = [1,2,3,1]
输出：4
解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 3：

输入：nums = [1,2,3]
输出：3


提示：

1 <= nums.length <= 100
0 <= nums[i] <= 1000
 */
public class leetcode_213 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2}));
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{1, 2, 3}));
    }

    public static int rob(int[] nums) {
        return Math.max(nums[0] + rob198(nums, 2, nums.length - 1), rob198(nums, 1, nums.length));
    }

    public static int rob198(int[] nums, int start, int end) {
        /*
            dp[i]:
                i偷  ：dp[i-2] + nums[i]
                i不偷: dp[i-1]
            dp[i] = max(dp[i-2] + nums[i],dp[i-1])
         */
        int len = nums.length;
        int a1 = 0;
        int a2 = 0;
        for (int i = start; i < end; i++) {
            int a3 = Math.max(a1 + nums[i], a2);
            a1 = a2;
            a2 = a3;
        }
        return a2;
    }
}
