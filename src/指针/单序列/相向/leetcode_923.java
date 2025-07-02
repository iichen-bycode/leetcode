package 指针.单序列.相向;

/*
给定一个整数数组 arr ，以及一个整数 target 作为目标值，返回满足 i < j < k 且 arr[i] + arr[j] + arr[k] == target 的元组 i, j, k 的数量。

由于结果会非常大，请返回 109 + 7 的模。



示例 1：
            0 1 2 3 4 5 6 7 8 9
输入：arr = [1,1,2,2,3,3,4,4,5,5], target = 8
输出：20
解释：
按值枚举(arr[i], arr[j], arr[k])：
(1, 2, 5) 出现 8 次；
(1, 3, 4) 出现 8 次；
(2, 2, 4) 出现 2 次；
(2, 3, 3) 出现 2 次。
示例 2：

输入：arr = [1,1,2,2,2,2], target = 5
输出：12
解释：
arr[i] = 1, arr[j] = arr[k] = 2 出现 12 次：
我们从 [1,1] 中选择一个 1，有 2 种情况，
从 [2,2,2,2] 中选出两个 2，有 6 种情况。


提示：

3 <= arr.length <= 3000
0 <= arr[i] <= 100
0 <= target <= 300
 */


import java.util.Arrays;

//多重三数之和  同1577
public class leetcode_923 {
    public static void main(String[] args) {
        // 20
        System.out.println(threeSumMulti(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
        // 12
        System.out.println(threeSumMulti(new int[]{1, 1, 2, 2, 2, 2}, 5));
        System.out.println(threeSumMulti(new int[]{2, 2, 3, 2}, 7)); // 3
    }

    public static int threeSumMulti(int[] arr, int target) {
        int l = 0, n = arr.length, r, MOD = 1_000_000_007, lastNum = 0;
        long ans = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            if (arr[i] + arr[i + 1] + arr[i + 2] > target) {
                break;
            }
            if (arr[i] + arr[n - 1] + arr[n - 2] < target) {
                continue;
            }
            l = i + 1;
            r = n - 1;
            while (l < r) {
                int sum = arr[l] + arr[r] + arr[i];
                if (sum == target) {
                    if (arr[l] == arr[r]) {
                        ans += ((long) (r - l + 1) * (r - l) / 2) % MOD;
                        break;
                    }
                    int m = 1, s = 1;
                    while (l < r && arr[l] == arr[l + 1]) {
                        l++;
                        m++;
                    }
                    while (l < r && arr[r] == arr[r - 1]) {
                        r--;
                        s++;
                    }
                    ans += ((long) m * s) % MOD;
                    l++;
                    r--;
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return (int) (ans % MOD);
    }
}
