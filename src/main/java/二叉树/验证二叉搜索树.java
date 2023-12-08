package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class 验证二叉搜索树 {

    private long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;

        return isValidBST(root.right);
    }


    /**
     * 中序遍历用容器记录
     */
    private List<Integer> list = new ArrayList<>();
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        dfs(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
