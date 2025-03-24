// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
// You may assume all four edges of the grid are all surrounded by water.

// Example 1:
// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1
  
// Example 2:
// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3
 
// Constraints:
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] is '0' or '1'.

class NumberofIslands {
    private class Pair {
        int row;
        int col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private boolean[][] visited;
    
    public int numIslands(char[][] grid) {
        int count = 0;
        this.visited = new boolean[grid.length][grid[0].length];
        for(int row=0;row<grid.length;row++) {
            for(int col=0;col<grid[0].length;col++) {
                if(grid[row][col] != '0' && !visited[row][col]) {
                    bfs(grid,row,col);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int row, int col) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(row, col));
        visited[row][col] = true;

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int currRow = pair.row;
            int currCol = pair.col;

            // Check the four directions: up, down, left, and right
            if (currRow - 1 >= 0 && grid[currRow - 1][currCol] == '1' && !visited[currRow - 1][currCol]) {
                queue.offer(new Pair(currRow - 1, currCol));
                visited[currRow - 1][currCol] = true;
            }
            if (currRow + 1 < grid.length && grid[currRow + 1][currCol] == '1' && !visited[currRow + 1][currCol]) {
                queue.offer(new Pair(currRow + 1, currCol));
                visited[currRow + 1][currCol] = true;
            }
            if (currCol - 1 >= 0 && grid[currRow][currCol - 1] == '1' && !visited[currRow][currCol - 1]) {
                queue.offer(new Pair(currRow, currCol - 1));
                visited[currRow][currCol - 1] = true;
            }
            if (currCol + 1 < grid[0].length && grid[currRow][currCol + 1] == '1' && !visited[currRow][currCol + 1]) {
                queue.offer(new Pair(currRow, currCol + 1));
                visited[currRow][currCol + 1] = true;
            }
        }
    }
}
