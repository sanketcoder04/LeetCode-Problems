// You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). 
// You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). 
// You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
// A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
// Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
  
// Example 1:
// Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
// Output: 2
// Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
// This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
  
// Example 2:
// Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
// Output: 1
// Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
  
// Example 3:
// Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
// Output: 0
// Explanation: This route does not require any effort.
 
// Constraints:
// rows == heights.length
// columns == heights[i].length
// 1 <= rows, columns <= 100
// 1 <= heights[i][j] <= 106

class Tuple {
    int distance;
    int row; 
    int col;

    public Tuple(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> queue = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int rowLength = heights.length;
        int colLength = heights[0].length;
        int[][] distance = new int[rowLength][colLength];   // create a distance matrix for tracking

        for(int i=0;i<rowLength;i++) {
            for(int j=0;j<colLength;j++) {
                distance[i][j] = (int) 1e9;     // Make every cell marked as infinity
            }
        }
        distance[0][0] = 0;     // make source node's distance as 0
        queue.offer(new Tuple(0,0,0));    // add the source cell in the queue

        // helps to get adjancency cells
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};

        while(queue.size() != 0) {
            Tuple tuple = queue.poll();
            int diff = tuple.distance;
            int row = tuple.row;
            int col = tuple.col;

            if(row == rowLength-1 && col == colLength-1) {      // we get the destination node so return the difference
                return diff;
            }
            // go for all adjecency nodes
            for(int i=0;i<4;i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(newRow >= 0 && newCol >= 0 && newRow < rowLength && newCol < colLength) {
                    // calculate current effort 
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[newRow][newCol]), diff);

                    // update the effort value and add the tuple into the queue
                    if(newEffort < distance[newRow][newCol]) {
                        distance[newRow][newCol] = newEffort;
                        queue.offer(new Tuple(newEffort, newRow, newCol));
                    }
                }
            }
        }
        return 0;
    }
}
