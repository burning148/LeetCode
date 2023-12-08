package 二叉树;

public class 打家劫舍3 {
    public int rob(TreeNode root) {
        int[] arr = dfs(root);
        return Math.max(arr[0], arr[1]);
    }

    /**
     *
     * @param root
     * @return
     */
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] arr = new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        arr[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        arr[1] = root.val + left[0] + right[0];

        return arr;
    }


}
