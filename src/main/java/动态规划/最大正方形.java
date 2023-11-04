package 动态规划;

public class 最大正方形 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxSide = 0;

        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            maxSide = Math.max(maxSide, dp[i][0]);
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            maxSide = Math.max(maxSide, dp[0][j]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                } else {
                    dp[i][j] = 0;
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }

        }

        return maxSide * maxSide;
    }

}
