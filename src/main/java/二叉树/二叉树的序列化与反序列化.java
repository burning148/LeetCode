package 二叉树;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的序列化与反序列化 {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }

        String left = serialize(root.left);
        String right = serialize(root.right);

        return root.val + "," + left + "," + right;
    }


    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        // 使用队列辅助反序列化
        Queue<String> q = new LinkedList<>(Arrays.asList(split));

        return build(q);
    }

    private TreeNode build(Queue<String> q) {
        String s = q.poll();

        if ("null".equals(s)) {
            return null;
        }

        TreeNode cur = new TreeNode(Integer.parseInt(s));
        cur.left = build(q);
        cur.right = build(q);
        return cur;
    }
}
