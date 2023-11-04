package 动态规划;

public class 删除并获得点数 {
    public int deleteAndEarn(int[] nums) {
        // 将数组中的元素按照值统计，得到每个值的总和
        int[] sum  = new int[10001];
        for (int num : nums) {
            sum[num] += num;
        }
        // 跟打家劫舍一样的dp方程
        int[] dp = new int[10001];
        dp[1] = sum[1];
        for (int i = 2; i < 10001; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i]);
        }
        return dp[10000];
    }

}
