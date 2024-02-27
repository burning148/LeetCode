package 二叉树;

import sun.reflect.generics.tree.Tree;

public class 相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q; // 必须都为空
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(q.right, q.right);
    }
}
