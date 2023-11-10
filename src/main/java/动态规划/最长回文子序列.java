package 动态规划;

/**
 * @author wangjun
 */
public class 最长回文子序列 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        // s长度为1，最长回文子序列为1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // 从长度为2开始遍历
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) { // j < n 所以 i < n - len + 1
                int j = i + len - 1; // j 最大为 n - 1
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
