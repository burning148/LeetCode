package 链表;

/**
 * 86.分隔链表
 *
 * <pre>
 * 分隔链表时需要断开原链表的next指针，是为了将链表分成两个独立的部分。如果不断开原链表的next指针，则无法将链表分成两个独立的部分，而是会形成一个环。
 * 这会导致在分隔链表后，原链表仍然存在，而且可能会导致程序出现死循环等问题。
 * 因此，为了确保程序的正确性和稳定性，需要在分隔链表时断开原链表的next指针。
 * </pre>
 *
 * @author wangjun294
 */
public class 分隔链表 {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1, p2 = dummy2, p = head;
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            // 断开原链表的next指针
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
