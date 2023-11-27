package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的完全性检验 {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = false; // 是否遇到左右孩子不全的节点
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if ((cur.left == null && cur.right != null) // 左孩子为空，右孩子不为空
                        || (flag && (cur.left != null || cur.right != null))) { // 如果遇到过左右孩子不全的节点，那么下面的节点必须都为叶子节点
                    return false;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                if (cur.left == null || cur.right == null) {
                    flag = true;
                }
            }
        }

        return true;
    }
}
