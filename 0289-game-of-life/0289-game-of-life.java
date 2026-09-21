class Solution {
    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        int[][] copy = new int[m][n];

        // Copy original board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int count = 0;

                // Check 8 neighbours
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {

                        if (x >= 0 && x < m &&
                            y >= 0 && y < n &&
                            !(x == i && y == j)) {

                            count += copy[x][y];
                        }
                    }
                }

                // Live cell
                if (copy[i][j] == 1) {

                    if (count < 2 || count > 3) {
                        board[i][j] = 0;
                    }
                }

                // Dead cell
                else {

                    if (count == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
}