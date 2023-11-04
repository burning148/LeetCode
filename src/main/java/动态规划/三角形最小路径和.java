package 动态规划;

import java.util.List;

public class 三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        // 计算最后一行的最小路径和
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }
        // 从倒数第二行开始计算最小路径和
        for (int i = n - 2; i >= 0; i--) {
            // 计算每一行的最小路径和
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        // 返回最小路径和
        return dp[0][0];
    }
}
