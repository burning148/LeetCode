package 二叉树;

public class 二叉树展开为链表 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode cur = root.left;
        if (cur == null) {
            return;
        }
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = root.right; // 将右子树挂到左子树的最后一个结点上
        root.right = root.left; // 将左子树挂到右子树上
        root.left = null; // 将左子树清空
    }
}
