package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集2 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
