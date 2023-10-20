package 动态规划;

public class 完全平方数 {
    public int numSquares(int n) {
        // dp[i]为i的最少完全平方数
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // 最坏的情况是i个1；
            int min = i;
            // 遍历从1到sqrt(i)，最小完全平方数的递推公式如下
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j] + 1);
            }

            dp[i] = min;
        }

        return dp[n];
    }
}
