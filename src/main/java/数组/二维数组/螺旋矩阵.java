package 数组.二维数组;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 上下左右四个边界
        int up = 0, down = m - 1, left = 0, right = n - 1;
        List<Integer> res = new ArrayList<>();
        while (res.size() < m * n) {
            if (up <= down) {
                // 从顶部往右遍历
                for (int j = left; j <= right; j++) {
                    res.add(matrix[up][j]);
                }
                // 上边界下移动
                up++;
            }

            if (left <= right) {
                // 在右侧从上往下遍历
                for (int i = up; i <= down; i++) {
                    res.add(matrix[i][right]);
                }
                // 右边界左移
                right--;
            }

            if (up <= down) {
                // 从底部往左遍历
                for (int j = right; j >= left; j--) {
                    res.add(matrix[down][j]);
                }
                // 下边界上移;
                down--;
            }

            if (left <= right) {
                // 在左侧从下往上遍历
                for (int i = down; i >= up; i--) {
                    res.add(matrix[i][left]);
                }
                // 左边界右移
                left++;
            }
        }
        return res;
    }
}
