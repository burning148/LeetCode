package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针2 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (pre != null) {
                    pre.next = cur;
                }
                pre = cur;
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
        }

        return root;
    }
}
