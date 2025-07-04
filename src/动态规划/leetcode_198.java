package 动态规划;

/*
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。



示例 1：

输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 2：

输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。


提示：

1 <= nums.length <= 100
0 <= nums[i] <= 400
 */
public class leetcode_198 {
    public static void main(String[] args) {
//        System.out.println(rob(new int[]{1, 2, 3, 1}));
//        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));

        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{1, 2, 3}));
        System.out.println(rob(new int[]{2, 3, 2}));
        System.out.println(rob(new int[]{1, 2, 1, 1}));
    }

    public static int rob(int[] nums) {
        /*
            dp[i]:
                i偷  ：dp[i-2] + nums[i]
                i不偷: dp[i-1]
            dp[i] = max(dp[i-2] + nums[i],dp[i-1])
         */
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int a1 = nums[0];
        int a2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
//            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
//            ans = Math.max(ans, dp[i]);
            int a3 = Math.max(a1 + nums[i], a2);
            a1 = a2;
            a2 = a3;
        }
        return a2;
    }
}
