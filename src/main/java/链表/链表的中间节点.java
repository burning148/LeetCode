package 链表;

/**
 * @author wangjun294
 * @description 876.链表的中间节点
 */
public class 链表的中间节点 {

    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
