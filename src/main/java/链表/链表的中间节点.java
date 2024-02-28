package 链表;

/**
 * @author wangjun294
 * @description 876.链表的中间节点
 */
public class 链表的中间节点 {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
