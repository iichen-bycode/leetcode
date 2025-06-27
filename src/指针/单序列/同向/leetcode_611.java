package 指针.单序列.同向;

import java.util.Arrays;

/*
给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。



示例 1:

输入: nums = [2,2,3,4]


输出: 3
解释:有效的组合是:
2,3,4 (使用第一个 2)
2,3,4 (使用第二个 2)
2,2,3
示例 2:

输入: nums = [4,2,3,4]
输出: 4


提示:

1 <= nums.length <= 1000
0 <= nums[i] <= 1000
https://leetcode.cn/problems/valid-triangle-number/description/
 */
public class leetcode_611 {
    public static void main(String[] args) {
    /*
    输入: nums = [2,2,3,4]
        输出: 3
        解释:有效的组合是:
        2,3,4 (使用第一个 2)
        2,3,4 (使用第二个 2)
        2,2,3


        回溯：
            2               2               3               4
        2   3   4        3    x             4               x
      3 4   4            4                  x               x
      T F   T            T


            4   2   3   4

            4           2
         2  3   4       3
        3 4  4  x       4
        T T  T          T
        双指针:

     */
        System.out.println(triangleNumber(new int[]{2, 2, 3, 4}));
        System.out.println(triangleNumber(new int[]{4, 2, 3, 4}));
    }

    public static int triangleNumber(int[] nums) {
        /*
            4   2   3   4
            => 2 3 4 4



            a+c >= a+b >b  必然成立
            b+c >= c+a >a

            a+b 唯一一个需要保证的

             a<=b<=c && a+b>c
         */
        int l = 0, n = nums.length, r = 0;
        if (n < 3)
            return 0;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            r = i -1;
            l = 0;
            while (l < r) {
                // 2 3 4 4 5
                if(nums[l] + nums[r] > nums[i]) {
                    // 因为有序 所以当 a[l] + a[r] 都大于 a[i] 那么l到r之间的与 a[r]相加都大于a[i]
                    ans += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }

    private static int ans = 0;

    public static int triangleNumbe2r(int[] nums) {
        dfs(nums, 0, 0, 0);
        return ans;
    }

    private static void dfs(int[] nums, int index, int sum, int count) {
        if (count == 3) {
            ans++;
            return;
        }
        for (int j = index; j < nums.length; j++) {
            if (count == 2 && sum <= nums[j]) {
                break;
            }
            dfs(nums, j + 1, sum + nums[j], count + 1);
        }
    }
}
