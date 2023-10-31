package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N皇后 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        // 初始化棋盘
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        // 从第一行开始放置皇后
        backtrack(board, 0);

        return res;
    }

    private void backtrack(char[][] board, int row) {
        if (row == board.length) {
            res.add(converse(board));
            return;
        }

        int n = board[row].length;
        // 在当前行尝试放皇后
        for (int col = 0; col < n; col++) {
            // 检查当前位置是否合法
            if (!isValid(board, row, col)) {
                continue;
            }

            board[row][col] = 'Q'; // 放置皇后
            backtrack(board, row + 1); // 在下一行放置皇后
            board[row][col] = '.'; // 撤销放置
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;

        // 检查同列
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> converse(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] ch : board) {
            res.add(String.valueOf(ch));
        }
        return res;
    }

}
