package 回溯.排列;
/*
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。



示例 1：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
示例 2：

输入：nums = [0,1]
输出：[[0,1],[1,0]]
示例 3：

输入：nums = [1]
输出：[[1]]


提示：

1 <= nums.length <= 6
-10 <= nums[i] <= 10
nums 中的所有整数 互不相同
 */

import helper.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 全排列
public class leetcode_46 {
    public static void main(String[] args) {
        /*
        输入：nums = [1,2,3]
        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        示例 2：

        输入：nums = [0,1]
        输出：[[0,1],[1,0]]
        示例 3：

        输入：nums = [1]
        输出：[[1]]
         */
        Utils.printList2(permute(new int[]{1, 2, 3}));
        /*
                1               2
              2    3        1       3
             3       2
         */
    }

    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        backTracking(nums, new LinkedList<Integer>());
        return ans;
    }

    private static void backTracking(int[] nums, LinkedList<Integer> res) {
        if (res.size() == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int num : nums) {
            // 因为是不含有重复的 所以使用contains
            if (res.contains(num))
                continue;
            res.add(num);
            backTracking(nums, res);
            res.removeLast();
        }
    }


    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            solve(nums, 0);
            return ans;
        }

        public void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        public void solve(int[] nums, int cur){
            if(cur == nums.length){
                List<Integer> list = new ArrayList<>();
                for(int x : nums){
                    list.add(x);
                }
                ans.add(list);
                return ;
            }

            for(int i = cur; i < nums.length; i ++){
                swap(nums, cur, i);
                solve(nums, cur + 1);
                swap(nums, cur, i);
            }
        }
    }
}
