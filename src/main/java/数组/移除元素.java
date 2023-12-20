package 数组;

public class 移除元素 {
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                // 这里与删除有序数组重复项区别与 ，先赋值，后++， 这样只能保证【0， slow - 1】中不包含val值 ，所以返回的是slow - 1 + 1 = slow
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
