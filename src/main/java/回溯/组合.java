package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 组合 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> path = new ArrayList<>();
        dfs(n, k, path, 1);
        return res;
    }

    private void dfs(int n, int k, List<Integer> path, int start) {
        if (k == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            dfs(n, k, path, i + 1);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        组合 clazz = new 组合();
        System.out.println(clazz.combine(4, 2));
    }

}
