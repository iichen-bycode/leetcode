package easy;

public class leetcode_3370 {
    public static void main(String[] args) {
        System.out.println(smallestNumber(5));
        System.out.println(smallestNumber(10));
        System.out.println(smallestNumber(3));
        System.out.println("-------------------------");
        // 32 16 8 4 2 1
        /**
         *  32 - Integer.numberOfLeadingZeros(5) 二进制长度
         *  31 - Integer.numberOfLeadingZeros(5) 二进制长度
         */
        int m = 32 - Integer.numberOfLeadingZeros(5);
        System.out.println((1 << m) - 1);
        int m2 = 32 - Integer.numberOfLeadingZeros(10);
        System.out.println((1 << m2) - 1);
        int m3 = 32 - Integer.numberOfLeadingZeros(3);
        System.out.println((1 << m3) - 1);
        System.out.println("-------------------------");

        int s = 31 - Integer.numberOfLeadingZeros(10);
        System.out.println(s);
        System.out.println(Integer.bitCount(7));
    }

    public static int smallestNumber(int n) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += jc(i);
            if (ans >= n)
                return ans;
        }
        return ans;
    }

    public static int jc(int n) {
        int res = 1;
        while (n > 0) {
            res *= 2;
            n--;
        }
        return res;
    }
}
