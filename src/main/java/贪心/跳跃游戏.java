package 贪心;

public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        int fastIdx = 0;
        // 贪心计算每个位置能够跳跃到的最远的位置
        for (int i = 0; i < nums.length; i++) {
            // 确保能够跳跃到这个位置
            if (fastIdx >= i) {
                fastIdx = Math.max(fastIdx, i + nums[i]);
                // 能够跳跃到的最远距离达到了最后一个位置
                if (fastIdx >= nums.length - 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
