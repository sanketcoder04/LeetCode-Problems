// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
// You must do it in place.

// Example 1:
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]

// Example 2:
// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 
// Constraints:
// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1

class SetMatrixZeroes {
    private class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void setZeroes(int[][] matrix) {
        List<Position> positions = new ArrayList<>();
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        for(int i=0;i<rowSize;i++) {
            for(int j=0;j<colSize;j++) {
                int item = matrix[i][j];
                if(item == 0) {
                    positions.add(new Position(i, j));
                }
            }
        }

        for(Position position : positions) {
            int row = position.row;
            int col = position.col;

            for(int i=0;i<colSize;i++) {
                if(matrix[row][i] != 0) {
                    matrix[row][i] = 0;
                }
            }
            for(int i=0;i<rowSize;i++) {
                if(matrix[i][col] != 0) {
                    matrix[i][col] = 0;
                }
            }
        }
    }
}
