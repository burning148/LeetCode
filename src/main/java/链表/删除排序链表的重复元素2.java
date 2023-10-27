package 链表;

public class 删除排序链表的重复元素2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            // 当前元素的下一个元素和下下个元素值相等
            if (cur.next.val == cur.next.next.val) {
                // 记录这个值
                int val = cur.next.val;
                // 当前元素后面一个元素的值等于这个值的时候，一直删除后面元素
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
