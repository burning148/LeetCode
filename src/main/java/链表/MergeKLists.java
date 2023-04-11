package 链表;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并k个升序链表
 * @author wangjun294
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
