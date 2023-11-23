package 二叉树;

import java.util.HashMap;
import java.util.Map;

public class 从前序遍历和中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        // 将中序遍历的值和索引存入哈希表
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return f(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode f(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2, Map<Integer, Integer> map) {
        if (l1 > r1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[l1]);
        if (l1 == r1) {
            return root;
        }
        int k = map.get(preorder[l1]);
        // preorder中左树r1求出来后， 加1就是右数l1了
        root.left = f(preorder, l1 + 1, l1 + k - l2, inorder, l2, k - 1, map);
        root.right = f(preorder, l1 + k - l2 + 1, r1, inorder, k + 1, r2, map);

        return root;
    }
}
