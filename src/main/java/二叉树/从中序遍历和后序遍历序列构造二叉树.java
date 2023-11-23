package 二叉树;

import java.util.HashMap;
import java.util.Map;

public class 从中序遍历和后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return f(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode f(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2, Map<Integer, Integer> map) {
        if (l2 > r2) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[r2]);
        if (l2 == r2) {
            return root;
        }

        Integer k = map.get(root.val);
        // inorder的下标确定很简单，根据inorder中左右子树的规模去确定postorder中的下标， postorder的左树r2求出后，加1就是右树的l2
        root.left = f(inorder, l1, k - 1, postorder, l2, l2 + k - 1 - l1, map);
        root.right = f(inorder, k + 1, r1, postorder, l2 + k - l1, r2 - 1, map);
        return root;
    }


}
