package 二叉树;


import java.util.LinkedList;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (i != size - 1) { // 不是这一层最后一个节点
                    cur.next = q.peek(); // 连接节点
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
        return root;
    }
}
