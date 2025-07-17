package 回溯;
/*
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。



示例 1：

输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
示例 2：

输入：nums = [0]
输出：[[],[0]]


提示：

1 <= nums.length <= 10
-10 <= nums[i] <= 10
nums 中的所有元素 互不相同
 */

import helper.Utils;

import java.util.ArrayList;
import java.util.List;

// 子集
public class leetcode_78 {
    public static void main(String[] args) {
        Utils.printList2(subsets(new int[]{1, 2, 3}));
//        Utils.printList2(subsets(new int[]{1}));
    }


    /*
    0/1     序列	    子集	0/1 序列对应的二进制数
    000	    {}	            0
    001	    {9}	            1
    010	    {2}	            2
    011	    {2,9}	        3
    100	    {5}	            4
    101	    {5,9}	        5
    110	    {5,2}	        6
    111	    {5,2,9}	        7

     */
    static List<Integer> t = new ArrayList<Integer>();
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public static List<List<Integer>> subsets(int[] nums) {
        // nums 每位选与不选
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) { // 循环总数目
            t.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) { // 判断哪一位与 当前循环结果匹配 就是答案
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;
    }


    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        backTracking(nums, ans, new ArrayList<Integer>(), 0);
        return ans;
    }

    private static void backTracking(int[] nums, List<List<Integer>> ans, ArrayList<Integer> path, int start) {
        /*
                1                   2           3
             2      3               3
            3
         */
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            ans.add(new ArrayList<>(path));
            backTracking(nums, ans, path, i + 1);
            path.remove(path.size() - 1);
        }
    }





}
