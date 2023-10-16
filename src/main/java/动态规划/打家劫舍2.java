package 动态规划;

/**
 * 环形房屋，不能相邻偷
 */
public class 打家劫舍2 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 分两种情况，偷第一家和不偷第一家
        return Math.max(rob1(nums, 0, nums.length - 2), rob1(nums, 1, nums.length - 1));
    }

    private int rob1(int[] nums, int start, int end) {

        if (end - start == 0) {
            return nums[start];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i + start], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

    // 计算在给定范围内偷窃的最大金额
    private int robRange(int[] nums, int start, int end) {
        int n = end - start + 1;
        if (n == 1) {
            return nums[start];
        }

        // 创建 dp 数组并初始化
        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        // 计算每个位置的最大金额
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[start + i], dp[i - 1]);
        }

        return dp[n - 1];
    }

}
