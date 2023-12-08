package 二叉树;

import java.util.*;

public class 寻找重复的子树 {
    private Map<String, TreeNode> map = new HashMap<>();
    private Set<TreeNode> set = new HashSet<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(set);
    }

    private String dfs(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(root.val);
        sb.append(dfs(root.left));
        sb.append(")(");
        sb.append(dfs(root.right));
        sb.append(")");
        String serial = sb.toString();
        if (map.containsKey(serial)) {
            set.add(map.get(serial));
        } else {
            map.put(serial, root);
        }
        return serial;
    }
}
