import helper.TreeNode;

public class test {
    public static void main(String[] args) {
        /*
            8   4   2   1
            3:  11
            4: 100
         */
//        System.out.println(1 << 2);
//        System.out.println(1 << 3);
//        System.out.println((1 << 2) & (1 << 3));
//        System.out.println(numberOfSubstrings("abcabbb"));
        // 16 8 4 2 1
        /*
            1000

            1111
         */
        //        [[4,8],[3,6],[10,20],[15,30]]
//        [[4,5],[7,8]]
        /*
            0010
            0101
         */
//        Deque<Integer> stack = new ArrayDeque<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        for (int a : stack) {
//            System.out.print(a+",");
//        }
//        System.out.println();
//        for (int a : queue) {
//            System.out.print(a+",");
//        }
//        System.out.println();
//        System.out.println(Long.MAX_VALUE);
//        System.out.println(Math.max(Integer.MAX_VALUE,2147483647));
//        int max = (int) (Math.pow(2, 31) - 1);
//        System.out.println((int) Math.sqrt(Integer.MAX_VALUE - 1) + "<>" + Integer.MAX_VALUE);
//        int a = 2147483600;
//        int m = (int) Math.sqrt(a - 1);
        /*
            4
            1   4
         */

//        System.out.println(erfen(new int[]{0, 2, 2, 3, 5, 7}, 4));
//        System.out.println(erfen(new int[]{1, 2, 3, 4, 5, 7}, 6));

//        long s = (long) 1000000000 + 1000000000 + 1000000000 + 1000000000;
//        System.out.println(s);
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        System.out.println(a == b);

        TreeNode c = null;
        TreeNode d = null;
        System.out.println(c == d);
    }

    public static int erfen(int[] ints, int target) {
        int l = 0, r = ints.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (ints[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }


    public static int numberOfSubstrings(String S) {
        char[] s = S.toCharArray();

        int ans = 0;
        int left = 0;
        int[] cnt = new int[3];
        for (char c : s) {
            cnt[c - 'a']++;
            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                cnt[s[left] - 'a']--;
                left++;
            }
            ans += left;
        }
        return ans;
    }
}
