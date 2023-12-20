package 链表;

public class 删除链表的中间结点 {
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast.next != null && fast.next.next != null) { // 跳出循环时fast再跳一次才为空,这与找链表的中间节点是不用的
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next; // 此时slow再跳一步才到中点，slow为中点的上一个节点
        return dummy.next;
    }


    public ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // 此时slow为中点
    }
}
