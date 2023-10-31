package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, n, "", 0, 0);
        return res;
    }

    private void backtrack(List<String> res, int n, String s, int left, int right) {
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }
        if (right > left) {
            return;
        }
        if (left < n) {
            backtrack(res, n, s + "(", left + 1, right);
        }
        if (right < n) {
            backtrack(res, n, s + ")", left, right + 1);
        }
    }
}
