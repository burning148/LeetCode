package 二叉树;

import java.text.DateFormatSymbols;
import java.util.HashMap;

public class 二叉树的坡度 {

    private int res;
    public int findTilt(TreeNode root) {
        dfs(root);
        return res;
    }

    /**
     * @param root
     * @return 返回的是当前节点和子树中所有节点的和
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        // 在后序遍历的位置统计坡度结果
        res += Math.abs(left - right);

        return left + right + root.val;
    }

}
