package 动态规划.子序列;

/*
给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。

注意 这个数列必须是 严格 递增的。



示例 1:

输入: [1,3,5,4,7]
输出: 2
解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
示例 2:

输入: [2,2,2,2,2]
输出: 5
解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。


提示:

1 <= nums.length <= 2000
-106 <= nums[i] <= 106
 */

// 最长递增子序列的个数
public class leetcode_673 {
    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
    }

    public static int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] f = new int[len];
        f[0] = 1;
        int ans = 0,max = 0;
        // cnt[i] 记录以i结尾的最长序列的个数
        int[] cnt = new int[len];
        for (int i = 0; i < len; i++) {
            f[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if(f[j] + 1 > f[i]) { // 新增长度了 则需要重置 个数
                        f[i] = f[j] + 1;
                        cnt[i] = cnt[j];
                    } else if(f[j] + 1 == f[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if(f[i] > max) {
                max = f[i];
                ans = cnt[i];
            } else if(f[i] == max){
                ans += cnt[i];
            }
        }
        return ans;
    }
}
