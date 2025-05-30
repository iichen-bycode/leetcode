package 链表;

import helper.ListNode;

public class leetcode_2058 {
    public static void main(String[] args) {
        int res[] = nodesBetweenCriticalPoints(new ListNode(6, new ListNode(8, new ListNode(4, new ListNode(1, new ListNode(9, new ListNode(6,
                new ListNode(6, new ListNode(10, new ListNode(6))))))))));
        System.out.println(res[0] + "," + res[1]);

        /*
                                        10
                            9
                8
            6                   6   6       6
                    4
                        1

            0   1   2   3   4   5   6   7   8
         */
    }

    /*

     */
    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[]{-1, -1};
        // firstP 记录第一个极值点下标，后续每个出现的极值点下标与firstP相减就是最大距离
        // lastP记录上一个极值点下标，后续每个出现的极值点与该极值点相减 与上次的取 最小值就是 最小距离
        int firstP = -1, last = head.val, lastP = -1;
        head = head.next;
        int diff = 0;
        int index = 1;
        while (head != null) {
            int d = head.val - last;
            if ((diff < 0 && d > 0) || (diff > 0 && d < 0)) {
                if (firstP == -1) { // 第一个极值点
                    firstP = index;
                } else {
                    ans[1] = index - firstP;
                    ans[0] = ans[0] == -1 ? index - lastP : Math.min(index - lastP, ans[0]);
                }
                lastP = index;
            }
            ++index;
            diff = d;
            last = head.val;
            head = head.next;
        }
        return ans;
    }
}
