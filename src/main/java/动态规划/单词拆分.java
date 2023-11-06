package 动态规划;

import java.util.List;

public class 单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // 空字符串可以被拆分
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // 如果0 - j 可以被单词拆分并且 j- i是一个单词
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // 跳出内层循环，提高循环效率
                }
            }
        }

        return dp[n];
    }
}
