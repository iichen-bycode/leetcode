package easy;

import java.util.Arrays;
import java.util.HashMap;

/*
给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。

对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。



示例 1：

输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]
示例  2:

1 2 2 2 3 3 4 6 7 9 19
2 2 2 1 3 3 4 6 7 9 19
2 2 2 1 4 3 3 9 6 7 19

输入：arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
输出：[22,28,8,6,17,44]


6 8 17 22 28 44
提示：

1 <= arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
arr2 中的元素 arr2[i]  各不相同
arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */
public class leetcode_1122 {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 19, 9, 2, 7};
//        输出：[2,2,2,1,4,3,3,9,6,7,19]
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] res = relativeSortArray(arr1, arr2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ",");
        }
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;
        for (int i = 1; i < arr1.length; i++) {
            if(arr1[i] > arr1[max]) {
                max = i;
            }
        }
        int []cache = new int[arr1[max] + 1];
        // 计数排序
        for (int k : arr1) {
            ++cache[k];
        }
        int []ans = new int[arr1.length];
        int index = 0;
        for (int cur : arr2) {
            for (int j = 0; j < cache[cur]; j++) {
                ans[index++] = cur;
            }
            cache[cur] = 0;
        }
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i]; j++) {
                ans[index++] = i;
            }
        }
        return ans;
    }
}
