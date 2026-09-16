class Solution {
    public int numSpecial(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];

        // Count 1s in each row and column
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (mat[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int answer = 0;

        // Find special positions
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (mat[i][j] == 1 &&
                    rowCount[i] == 1 &&
                    colCount[j] == 1) {

                    answer++;
                }
            }
        }

        return answer;
    }
}