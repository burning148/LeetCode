package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class 路径总和2 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.add(root.val); // 先将当前节点添加到路径中
        if (root.left == null && root.right == null && targetSum == root.val) { // 再判断是否到达叶子节点且路径和等于目标和
            res.add(new ArrayList<>(path));
        }

        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
        path.remove(path.size() - 1); // 回溯
    }

}
