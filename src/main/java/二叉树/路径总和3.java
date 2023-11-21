package 二叉树;

public class 路径总和3 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int res = rootSum(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);

        return res;
    }

    /**
     * 以根节点为起点的路径
     * @param root
     * @param targetSum
     * @return
     */
    private int rootSum(TreeNode root, int targetSum) {
        int res = 0;

        if (root.val == targetSum) {
            res++;
        }

        res += rootSum(root.left, targetSum - root.val);
        res += rootSum(root.right, targetSum - root.val);

        return res;
    }
}
