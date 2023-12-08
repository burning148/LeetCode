package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 组合总和 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            target -= candidates[i];
            backtrack(candidates, target, i);
            target += candidates[i];
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        组合总和 clazz = new 组合总和();
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        System.out.println(clazz.combinationSum(arr, target));
    }
}
