package 字符串;

public class 最长回文子串 {

    // 中心扩展算法 处理回文串
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAround(s, i, i);
            int len2 = expandAround(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2; // 这里需要注意
                end = i + len / 2;
            }

        }

        return s.substring(start, end + 1);
    }

    private int expandAround(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 退出循环时候，left在最长回文串的左边，right在最长回文串的右边， 所以需要-1； 例如 {aba}，退出循环时候，left = -1， right = 3
        return right - left - 1;
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        // dp[i][j]的含义是以i为左边界，j为右边界的字符串是否为回文串
        boolean[][] dp = new boolean[n][n];
        // 长度为1的字符串都为回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int start = 0;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // j <= n - 1
                if (s.charAt(i) == s.charAt(j)) {
                    // 子串长度为2或者
                    if (len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (len > maxLen) {
                            len = maxLen;
                            start = i;
                        }
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}
