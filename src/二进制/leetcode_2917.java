package 二进制;

/*
给你一个整数数组 nums 和一个整数 k 。让我们通过扩展标准的按位或来介绍 K-or 操作。在 K-or 操作中，如果在 nums 中，至少存在 k 个元素的第 i 位值为 1 ，那么 K-or 中的第 i 位的值是 1 。

返回 nums 的 K-or 值。



示例 1：

输入：nums = [7,12,9,8,9,15], k = 4
输出：9
解释：
用二进制表示 numbers：
Number	Bit 3	Bit 2	Bit 1	Bit 0
7	0	1	1	1
12	1	1	0	0
9	1	0	0	1
8	1	0	0	0
9	1	0	0	1
15	1	1	1	1
Result = 9	1	0	0	1
位 0 在 7, 9, 9, 15 中为 1。位 3 在 12, 9, 8, 9, 15 中为 1。 只有位 0 和 3 满足。结果是 (1001)2 = 9。
示例 2：

输入：nums = [2,12,1,11,4,5], k = 6
输出：0
解释：没有位在所有 6 个数字中都为 1，如 k = 6 所需要的。所以，答案为 0。
示例 3：

输入：nums = [10,8,5,9,11,6,8], k = 1
输出：15
解释：因为 k == 1 ，数组的 1-or 等于其中所有元素按位或运算的结果。因此，答案为 10 OR 8 OR 5 OR 9 OR 11 OR 6 OR 8 = 15 。


提示：

1 <= nums.length <= 50
0 <= nums[i] < 231
1 <= k <= nums.length
https://leetcode.cn/problems/find-the-k-or-of-an-array/description/
 */
public class leetcode_2917 {
    public static void main(String[] args) {
//        System.out.println(findKOr(new int[]{7, 12, 9, 8, 9, 15}, 4));
//        System.out.println(findKOr(new int[]{2, 12, 1, 11, 4, 5}, 6));
//        System.out.println(findKOr(new int[]{10, 8, 5, 9, 11, 6, 8}, 1));
        /*
            5   101
            3   100

                101

            16 8 4 2 1
         */
        System.out.println(5 | (1 << 3));
        System.out.println(3 | (1<<3));
    }

    public static int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            int count = 0;
            for (int num : nums) {
                count += num >> i & 1;
            }
            if (count >= k) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

    public static int findKOr2(int[] nums, int k) {
        int max = Integer.MIN_VALUE, index = -1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        int step = 0;
        while (nums[index] != 0) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0 && (nums[i] & 1) == 1) {
                    count++;
                }
                nums[i] = nums[i] >> 1;
            }
            if (count >= k) {
//                ans += helper(step);
                ans |= (1 << step);
            }
            step++;
        }
        return ans;
    }

    public static int helper(int step) {
        int res = 1;
        while (step-- > 0) {
            res *= 2;
        }
        return res;
    }
}
