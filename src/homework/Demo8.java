package homework;

/**
 * @author Kui Lian
 * @date 2022/10/17 - 19:23
 * @Description:
 */
public class Demo8 {
    public static void main(String[] args) {

    }


    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int  m, n;
    char[][] board;

    public void solve(char[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(i, n - 1);
            }
        }
        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs(m - 1, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public  void dfs(int row, int col) {
        board[row][col] = '#';
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && board[newRow][newCol] == 'O') {
                dfs(newRow, newCol);
            }
        }
    }
}
