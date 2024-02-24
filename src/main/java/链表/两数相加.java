package 链表;

public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int t = 0; // 进位
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;

            // 计算当前和和进位
            int sum = a + b + t;
            t = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (t > 0) {
            temp.next = new ListNode(t);
        }

        return dummy.next;
    }
}
