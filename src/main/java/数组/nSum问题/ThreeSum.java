package 数组.nSum问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 15.三数之和
 * @author wangjun294
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // 排序
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // 去重
                continue;
            }
            int left = i + 1, right = nums.length - 1, sum = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) { // 去重
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) { // 去重
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
