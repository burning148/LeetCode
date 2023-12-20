package 数组.二维数组;

public class 螺旋矩阵2 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        // 上下左右四个边界
        int up = 0, down = n - 1, left = 0, right = n - 1;
        int num = 1;
        while (num <= n * n) {
            if (up <= down) {
                // 从顶部往右遍历
                for (int j = left; j <= right; j++) {
                    res[up][j] = num;
                    num++;
                }
                up++;
            }

            if (left <= right) {
                // 在右侧从上往下遍历
                for (int i = up; i <= down; i++) {
                    res[i][right] = num;
                    num++;
                }
                right--;
            }

            if (up <= down) {
                // 从底部往左遍历
                for (int j = right; j >= left; j--) {
                    res[down][j] = num;
                    num++;
                }
                down--;
            }

            if (left <= right) {
                // 在左侧从下往上遍历
                for (int i = down; i >= up; i--) {
                    res[i][left] = num;
                    num++;
                }
                left++;
            }
        }
        return res;
    }
}
