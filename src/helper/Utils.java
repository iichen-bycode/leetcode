package helper;

import java.util.List;

public class Utils {
    public static void print(int[] nums) {
        for (int k : nums) {
            System.out.print(k + ",");
        }
        System.out.println("---------------------------------------------");
    }

    public static void print2(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }

    public static void print3(int[][][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                for (int k = 0; k < nums[i][j].length; k++) {
                    System.out.print(nums[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }

    public static void printList2(List<List<Integer>> a) {
        for (List<Integer> a1 : a) {
            for (int a2 : a1) {
                System.out.print(a2 + ",");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }
    public static void printList(List<Integer> a) {
        for (int aa : a) {
            System.out.print(aa + ",");
        }
        System.out.println("---------------------------------------------");
    }
}
