package 数组.二维数组;

public class 旋转图像 {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        // 延45度角镜像反转图像
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 反转每一行
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    private void reverse(int[] row) {
        int left = 0, right = row.length - 1;
        while (left < right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
}
