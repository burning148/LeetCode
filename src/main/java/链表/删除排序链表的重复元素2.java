package 链表;

public class 删除排序链表的重复元素2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        // 循环当前节点下一个节点和下下个节点
        while (cur.next != null && cur.next.next != null) {
            // 记录下个节点的值
            int val = cur.next.val;
            // 当下下个节点的值等于这个值
            if (cur.next.next.val == val) {
                // 循环删除下个节点，直到下个节点不等于这个值
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
