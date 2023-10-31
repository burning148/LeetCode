package 二叉树;

public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q); // 在左子树中找p，q的公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) { // 当左右子树的公共祖先都不为空时，当前节点就是公共祖先
            return root;
        }
        return left == null ? right : left; // 当左子树的公共祖先为空时，右子树的公共祖先为最近公共祖先
    }
}
