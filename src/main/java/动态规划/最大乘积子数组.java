package 动态规划;

public class 最大乘积子数组 {

    public static int maxProduct(int[] nums) {
        // 因为nums[i]可能为负数，需要维护一个minDp
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];

        maxDp[0] = nums[0];
        minDp[0] = nums[0];

        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxDp[i] = Math.max(Math.max(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]), nums[i]);
            minDp[i] = Math.min(Math.min(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]), nums[i]);

            res = Math.max(res, maxDp[i]);
        }

        return res;
    }
}
