package 二叉树;

public class 完全二叉树的节点个数 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) { // 左子树为满二叉树， 右子树为完全二叉树, 满二叉树的节点个数公式为2^树深度 - 1
            return (1 << leftDepth) + countNodes(root.right); // 左子树节点个数为2^左子树深度 - 1， 加上本身 + 1， 加上右子树节点个数countNodes(root.right)
        } else {
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    /**
     * 求完全二叉树的深度，一直向左扎，直到没有左子树为止，返回深度
     * @param root
     * @return
     */
    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }
}
