package 常用数据结构.枚举技巧;

/*
给你一个整数数组 nums 。

如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。

返回好数对的数目。



示例 1：

输入：nums = [1,2,3,1,1,3]
输出：4
解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
示例 2：

输入：nums = [1,1,1,1]
输出：6
解释：数组中的每组数字都是好数对
示例 3：

输入：nums = [1,2,3]
输出：0


提示：

1 <= nums.length <= 100
1 <= nums[i] <= 100
https://leetcode.cn/problems/number-of-good-pairs/
 */
public class leetcode_1512 {
    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println(numIdenticalPairs(new int[]{1, 1, 1, 1}));
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3}));
    }

    public static int numIdenticalPairs(int[] nums) {
        // 值最大为100
        int max = 0;
        for (int j : nums) {
            max = Math.max(max, j);
        }
        int[] f = new int[max + 1];
        int ans = 0;
        for (int num : nums) {
            ans += f[num];
            f[num] += 1;
        }
        return ans;
    }
}
