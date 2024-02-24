package 二叉树;

import com.sun.corba.se.spi.oa.ObjectAdapterFactory;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的完全性检验 {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            // 空树是完全二叉树
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // 标记是否遇到了空节点
        boolean empty = false;

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                empty = true;
            } else {
                // 此时遍历非空节点
                if (empty) { // 当遇到了空节点后，又遇到了非空节点 表示非完全二叉树
                    return false;
                }
                // 将左右子节点包括空节点入列
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }

        return true;
    }
}
