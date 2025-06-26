package 常用数据结构.枚举技巧;

import java.util.HashMap;
import java.util.Map;

/*
给你一个整数数组 nums。

特殊三元组 定义为满足以下条件的下标三元组 (i, j, k)：

0 <= i < j < k < n，其中 n = nums.length
nums[i] == nums[j] * 2
nums[k] == nums[j] * 2
返回数组中 特殊三元组 的总数。

由于答案可能非常大，请返回结果对 109 + 7 取余数后的值。



示例 1：

输入： nums = [6,3,6]

输出： 1

解释：

唯一的特殊三元组是 (i, j, k) = (0, 1, 2)，其中：

nums[0] = 6, nums[1] = 3, nums[2] = 6
nums[0] = nums[1] * 2 = 3 * 2 = 6
nums[2] = nums[1] * 2 = 3 * 2 = 6
示例 2：

输入： nums = [0,1,0,0]

输出： 1

解释：

唯一的特殊三元组是 (i, j, k) = (0, 2, 3)，其中：

nums[0] = 0, nums[2] = 0, nums[3] = 0
nums[0] = nums[2] * 2 = 0 * 2 = 0
nums[3] = nums[2] * 2 = 0 * 2 = 0
示例 3：

输入： nums = [8,4,2,8,4]

输出： 2

解释：

共有两个特殊三元组：

(i, j, k) = (0, 1, 3)
nums[0] = 8, nums[1] = 4, nums[3] = 8
nums[0] = nums[1] * 2 = 4 * 2 = 8
nums[3] = nums[1] * 2 = 4 * 2 = 8
(i, j, k) = (1, 2, 4)
nums[1] = 4, nums[2] = 2, nums[4] = 4
nums[1] = nums[2] * 2 = 2 * 2 = 4
nums[4] = nums[2] * 2 = 2 * 2 = 4


提示：

3 <= n == nums.length <= 105
0 <= nums[i] <= 105

https://leetcode.cn/problems/count-special-triplets/description/
 */
public class leetcode_3583 {
    public static void main(String[] args) {
        System.out.println(specialTriplets2(new int[]{6, 3, 6}));
        System.out.println(specialTriplets2(new int[]{0, 1, 0, 0, 0}));
        System.out.println(specialTriplets2(new int[]{8, 4, 2, 8, 4}));
        System.out.println(specialTriplets2(new int[]{54, 27, 54, 49}));
        System.out.println(specialTriplets2(new int[]{9060, 4530, 9060}));
    }

    public static int specialTriplets3(int[] nums) {
        final int MOD = 1_000_000_007;
        Map<Integer, Integer> cnt1 = new HashMap<>();
        Map<Integer, Long> cnt12 = new HashMap<>();
        long cnt123 = 0;
        for (int x : nums) {
            if (x % 2 == 0) {
                cnt123 += cnt12.getOrDefault(x / 2, 0L); // 把 x 当作 nums[k]
            }
            cnt12.merge(x, (long) cnt1.getOrDefault(x * 2, 0), Long::sum); // 把 x 当作 nums[j]
            cnt1.merge(x, 1, Integer::sum); // 把 x 当作 nums[i]
        }
        return (int) (cnt123 % MOD);
    }

    public static int specialTriplets(int[] nums) {
        final int MOD = 1_000_000_007;
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }

        int[] suf = new int[mx + 1];
        for (int x : nums) {
            suf[x]++;
        }

        long ans = 0;
        int[] pre = new int[mx + 1];
        for (int x : nums) {
            suf[x]--;
            if (x * 2 <= mx) {
                ans += (long) pre[x * 2] * suf[x * 2];
            }
            pre[x]++;
        }
        return (int) (ans % MOD);
    }

    public static int specialTriplets2(int[] nums) {
        int len = nums.length, MOD = 1_000_000_007;
        long ans = 0;
        // 记录i 前符合条件的数目
        int[] f = new int[len];
        // 统计 每个元素出现的数目
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }
        int[] t = new int[mx + 1];
        // 处理i<j的部分
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num * 2 <= mx) {
                f[i] = t[num * 2];
            }
            t[num] += 1;
        }
        t = new int[mx + 1];
        // 处理j<k
        for (int i = len - 1; i >= 0; i--) {
            int num = nums[i];
            if (num * 2 <= mx) {
                ans += ((long) f[i] * t[num * 2]);
            }
            t[num] += 1;
        }
        return (int) (ans % MOD);
    }
}
