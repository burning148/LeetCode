package 二叉树;

public class 路径总和 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) { // 遍历到空节点
            return false;
        }
        if (root.left == null && root.right == null) { // 遍历到叶子节点
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
