package 指针.单序列.相向;

/*
给你两个整数数组 nums1 和 nums2 ，请你返回根据以下规则形成的三元组的数目（类型 1 和类型 2 ）：

类型 1：三元组 (i, j, k) ，如果 nums1[i]^2 == nums2[j] * nums2[k] 其中 0 <= i < nums1.length 且 0 <= j < k < nums2.length
类型 2：三元组 (i, j, k) ，如果 nums2[i]^2 == nums1[j] * nums1[k] 其中 0 <= i < nums2.length 且 0 <= j < k < nums1.length


示例 1：

输入：nums1 = [7,4], nums2 = [5,2,8,9]
输出：1
解释：类型 1：(1,1,2), nums1[1]^2 = nums2[1] * nums2[2] (4^2 = 2 * 8)
示例 2：

输入：nums1 = [1,1], nums2 = [1,1,1]
输出：9
解释：所有三元组都符合题目要求，因为 1^2 = 1 * 1
类型 1：(0,0,1), (0,0,2), (0,1,2), (1,0,1), (1,0,2), (1,1,2), nums1[i]^2 = nums2[j] * nums2[k]
类型 2：(0,0,1), (1,0,1), (2,0,1), nums2[i]^2 = nums1[j] * nums1[k]
示例 3：

输入：nums1 = [7,7,8,3], nums2 = [1,2,9,7]
    3 7 7 8
    1 2 7 9
输出：2
解释：有两个符合题目要求的三元组
类型 1：(3,0,2), nums1[3]^2 = nums2[0] * nums2[2]
类型 2：(3,0,1), nums2[3]^2 = nums1[0] * nums1[1]
示例 4：

输入：nums1 = [4,7,9,11,23], nums2 = [3,5,1024,12,18]
输出：0
解释：不存在符合题目要求的三元组


提示：

1 <= nums1.length, nums2.length <= 1000
1 <= nums1[i], nums2[i] <= 10^5
 */

import java.util.Arrays;

// 数的平方等于两数乘积的方法数
public class leetcode_1577 {
    public static void main(String[] args) {
        System.out.println(numTriplets(new int[]{7, 4}, new int[]{5, 2, 8, 9}));
        System.out.println(numTriplets(new int[]{1, 1}, new int[]{1, 1, 1}));
        System.out.println(numTriplets(new int[]{7, 7, 8, 3}, new int[]{1, 2, 9, 7}));
        System.out.println(numTriplets(new int[]{4, 7, 9, 11, 23}, new int[]{3, 5, 1024, 12, 18}));
        System.out.println(numTriplets(new int[]{1, 3, 1, 2}, new int[]{2, 3, 5, 3, 2})); // 2

        // 1 9 2 0
    }

    public static int numTriplets(int[] nums1, int[] nums2) {
        /*
            枚举nums1 i去nums2内匹配
            枚举nums2 i去nums1内匹配
         */
        // 枚举nums1
        int ans = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ans += sum(nums1, nums2);
        System.out.println(">>>>> " + ans);
        ans += sum(nums2, nums1);
        return ans;
    }

    private static int sum(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int l = 0, r = n2 - 1;
        int ans = 0;
        /*
            1   1   2   3
            2   2   3   3   5
         */
        for (int i = 0; i < n1; i++) {
            long target = (long) nums1[i] * nums1[i];
            // 去nums2匹配
            // 1 1     1 1 1 1
            /*
                2!
                (r-l + 1)!(r-l- 2)!
             */
            l = 0;
            r = n2 - 1;
            while (l < r) {
                long sum = (long) nums2[l] * nums2[r];
                if (sum == target) {
                    // 关键是这里
                    if(nums2[l] == nums2[r]){
                        // 1 1 1 1        0 1 2 3
                        ans += (r - l + 1) * (r - l) / 2;
                        break;

                        /*
                           (r - l + 1)(r - l)(r - l -1)!] /  2*（r - l -1)!
                        =    (r- l + 1)(r-1) / 2
                         */
                    }
                    // 2 2 xxx  4 4 4   target = 8 总组合： 2个2，3个4 即 2 * 3个
                    int m = 1, n = 1;
                    while(l < r && nums2[l + 1] == nums2[l]){
                        m++;
                        l++;
                    }
                    while(l < r && nums2[r] == nums2[r - 1]){
                        n++;
                        r--;
                    }
                    ans += m * n;
                    l++;
                    r--;
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }

    public static int factorialRecursive(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorialRecursive(n - 1);
    }
}
