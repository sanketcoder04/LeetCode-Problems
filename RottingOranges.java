// You are given an m x n grid where each cell can have one of three values:
// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

// Example 1:
// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
  
// Example 2:
// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
  
// Example 3:
// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 
// Constraints:
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] is 0, 1, or 2.

class RottingOranges {
    private class Pair {
        int row;
        int col;
        int time;

        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        int n = grid.length;    // row size
        int m = grid[0].length; // col size

        Queue<Pair> queue = new LinkedList<>();

        int[][] visited = new int[n][m];

        // Create the visited array reference to grid
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                // cell contain rotten orange add in the queue and update visited 
                if(grid[i][j] == 2) {
                    queue.offer(new Pair(i, j, 0));
                    visited[i][j] = 2;
                }
                // if not rotten 
                else{
                    visited[i][j] = 0;
                }
            }
        }

        int maxTime = 0;
        // For neighbours row and col calculations
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};
        int count = 0;

        while(!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            int time = queue.peek().time;
            maxTime = Math.max(maxTime, time);
            queue.poll();

            for(int i=0;i<4;i++) {
                // Find out row and col of each neighbour one by one
                int neighbourRow = row + delRow[i];
                int neighbourCol = col + delCol[i];

                // check for position and condition validity
                if(neighbourRow >= 0 && neighbourRow < n && neighbourCol >= 0 && neighbourCol < m 
                && visited[neighbourRow][neighbourCol] == 0
                && grid[neighbourRow][neighbourCol] == 1) {
                    // Add the neighbour into the queue
                    queue.add(new Pair(neighbourRow, neighbourCol, time + 1));
                    visited[neighbourRow][neighbourCol] = 2;    // mark as rotten
                    count++;
                }
            }
        }

        // check for if oranges are not rotten
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(visited[i][j] != 2 && grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return maxTime;
    }
}
