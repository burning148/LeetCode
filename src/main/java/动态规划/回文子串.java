package 动态规划;

public class 回文子串 {
    public int countSubstrings(String s) {
        int n = s.length();
        if (n == 1) {
            return 1;
        }

        int res = 0;
        boolean[][] dp = new boolean[n][n];
        // 子串长度为1
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            res++;
        }
        // 从长度为2开始遍历
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) { // i 最大值需要注意
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }

        return res;
    }
}
