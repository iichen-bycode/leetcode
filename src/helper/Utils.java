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

    public static <T> void printList2(List<List<T>> a) {
        for (List<T> a1 : a) {
            for (T a2 : a1) {
                System.out.print(a2 + ",");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }
    public static <T> void printList(List<T> a) {
        for (T aa : a) {
            System.out.print(aa + ",");
        }
        System.out.println("---------------------------------------------");
    }

    public static <T> void printListS(List<T> a) {
        for (T aa : a) {
            System.out.print(aa + ",");
        }
        System.out.println("---------------------------------------------");
    }

    public static void printB(boolean[] array) {
        for (boolean k : array) {
            System.out.print(k + ",");
        }
        System.out.println("---------------------------------------------");
    }
}
