package 动态规划;

import java.util.Arrays;

public class 最长递增子序列 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // 每个元素初始最长递增子序列为1
        Arrays.fill(dp, 1);
        // 结果
        int res = 1;
        // 从第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            // 与之前的每一个元素比较
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        System.out.println(Arrays.toString(dp));

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        最长递增子序列 最长递增子序列 = new 最长递增子序列();
        最长递增子序列.lengthOfLIS(nums);

    }
}
