package 数组;

public class 移动零 {
    public static void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        // 此时【0， slow - 1】区间中都不为, 从slow开始赋值为0
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
