package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 组合 {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k,1);
        return res;
    }

    private void backtrack(int n, int k, int start) {
        if (k == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        组合 clazz = new 组合();
        System.out.println(clazz.combine(4, 2));
    }

}
