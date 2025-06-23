package helper;

public class Utils {
    public static void print(int[] nums) {
        for (int k : nums) {
            System.out.print(k + ",");
        }
        System.out.println();
    }

    public static void print2(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
