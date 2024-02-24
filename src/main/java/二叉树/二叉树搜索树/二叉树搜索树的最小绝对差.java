package 二叉树.二叉树搜索树;

import 二叉树.TreeNode;

public class 二叉树搜索树的最小绝对差 {
    private int res = Integer.MAX_VALUE; // 求最小值，初始化最大值
    private int preVal; // 前一个节点值
    public int getMinimumDifference(TreeNode root) {
        inorderTraversal(root); // 中序遍历
        return res;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);

        res = Math.min(res, root.val - preVal);
        // 更新前一个节点值
        preVal = root.val;

        inorderTraversal(root.right);
    }
}
