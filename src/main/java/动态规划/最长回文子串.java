package 动态规划;

public class 最长回文子串 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        boolean[][] dp = new boolean[n][n];
        // 子串长度为1都为回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int start = 0;

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    // 子串长度为2或者去掉首尾字符后仍为回文串
                    if (len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        // 当为回文串时，更新最长回文子串的起始位置和长度
                        if (len > maxLen) {
                            maxLen = len;
                            start = i;
                        }
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

}
