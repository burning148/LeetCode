package 数组.nSum问题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和问题
 * 解法
 * @author wangjun294
 */
class TwoSum {
    /**
     * 双指针
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] newNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(newNums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = newNums[left] + newNums[right];
            if (sum == target) {
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        if (left >= right) {
            return new int[]{-1, -1};
        }
        int index1 = -1, index2 = -1;
        for (int i = 0; i < nums.length; i++) {
            // 当index1已经找到时，就不再赋值
            if (nums[i] == newNums[left] && index1 == -1) {
                index1 = i;
            }
            // 当index2已经找到时，就不再赋值
            if (nums[i] == newNums[right] && index2 == -1) {
                index2 = i;
            }
        }
        return new int[]{index1, index2};
    }

    /**
     * 哈希表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int otherNum = target - nums[i];
            if (map.containsKey(otherNum)) {
                return new int[]{i, map.get(otherNum)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        int[] nums = {3, 3};
        TwoSum twoSum = new TwoSum();
        twoSum.twoSum(nums, 6);
    }
}
