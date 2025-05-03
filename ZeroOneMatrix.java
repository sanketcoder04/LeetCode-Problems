// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
// The distance between two cells sharing a common edge is 1.

// Example 1:
// Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
// Output: [[0,0,0],[0,1,0],[0,0,0]]
  
// Example 2:
// Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
// Output: [[0,0,0],[0,1,0],[1,2,1]]
 
// Constraints:
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 104
// 1 <= m * n <= 104
// mat[i][j] is either 0 or 1.
// There is at least one 0 in mat.

class ZeroOneMatrix {
    private class Node {
        int row;
        int col;
        int step;

        public Node(int row, int col, int step) {
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }
    
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length; // rowSize
        int m = mat[0].length; // colSize    n x m matrix

        int visited[][] = new int[n][m]; // check for if visited cell
        int distance[][] = new int[n][m]; // distance for every cell

        Queue<Node> queue = new LinkedList<>();

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                // If matrix's cell is already 0 then add it in the queue and update visited
                if(mat[i][j] == 0) {
                    queue.offer(new Node(i, j, 0));
                    visited[i][j] = 1;
                }
                // Not visited so make it 0 
                else {
                    visited[i][j] = 0;
                }
            }
        }

        int delRow[] = {-1, 0, 1, 0};   // helps to determine neighbour row 
        int delCol[] = {0, 1, 0, -1};   // helps to determine neighbour col

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int row = node.row;
            int col = node.col;
            int step = node.step;

            // Update at distance matrix for particular cell 
            distance[row][col] = step;

            for(int i=0;i<4;i++) {      
                // Find out the neighbour's row and col at 4 directions
                int neighbourRow = row + delRow[i];
                int neighbourCol = col + delCol[i];

                // Check the row and col validation and is previously visited??
                if(neighbourRow >= 0 && neighbourRow < n && neighbourCol >= 0 && neighbourCol < m 
                && visited[neighbourRow][neighbourCol] == 0) {
                    // Mark as visited
                    visited[neighbourRow][neighbourCol] = 1;
                    // Add that cell in the queue for further checking it's neighbours
                    queue.add(new Node(neighbourRow, neighbourCol, step + 1));
                }
            }
        }
        return distance;
    }
}
