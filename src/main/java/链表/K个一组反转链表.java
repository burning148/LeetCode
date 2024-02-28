package 链表;

public class K个一组反转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode a, b;
        a = b = head;
        // 反转[a, b)之间的节点
        for (int i = 0; i < k; i++) {
            // basecase 当节点数不足k时，直接返回头节点;
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 反转区间[a, b)之间的节点
     * @param a
     * @param b
     * @return
     */
    private ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null, cur = a;
        while (cur != b) {
            // 反转节点
            ListNode next = cur.next;
            cur.next = pre;
            // 移动指针
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
