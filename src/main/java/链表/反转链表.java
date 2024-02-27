package 链表;

/**
 * @author wangjun294
 * @description 206.反转链表
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) { // 链表为空或只有一个节点时，直接返回头节点
            return head;
        }
        ListNode last = reverseList(head.next); // 从第二个节点开始反转
        head.next.next = head;
        head.next = null;
        return last;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 反转前n个节点
     * @param head
     * @param n
     * @return
     */
    ListNode successor = null;
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    /**
     * 反转区间中的节点
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}
