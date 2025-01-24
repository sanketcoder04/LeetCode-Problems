// There is a directed graph of n nodes with each node labeled from 0 to n - 1.
// The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
// A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
// Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

// Example 1:
// Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
// Output: [2,4,5,6]
// Explanation:
// Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
// Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
  
// Example 2:
// Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
// Output: [4]
// Explanation:
// Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
 
// Constraints:
// n == graph.length
// 1 <= n <= 104
// 0 <= graph[i].length <= n
// 0 <= graph[i][j] <= n - 1
// graph[i] is sorted in a strictly increasing order.
// The graph may contain self-loops.
// The number of edges in the graph will be in the range [1, 4 * 104].

class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int vertices = graph.length;
        int visited[] = new int[vertices];
        int pathVisit[] = new int[vertices];        // checking for an cycle detection
        int check[] = new int[vertices];            // record of nodes which are safe

        for(int i=0;i<vertices;i++) {
            if(visited[i] == 0) {   // Check for all the nodes
                checking(i, graph, visited, pathVisit, check);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<check.length;i++) {
            if(check[i] == 1) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean checking(int vertex, int[][] graph, int[] visited, int[] pathVisit, int[] check) {
        visited[vertex] = 1;
        pathVisit[vertex] = 1;
        check[vertex] = 0;

        for(int i=0;i<graph[vertex].length;i++) {
            int neighbour = graph[vertex][i];
            // Check for neighbour nodes if they are safe 
            if(visited[neighbour] == 0) {
                if(checking(neighbour, graph, visited, pathVisit, check)) {
                    return true;    // If neighbour is safe then curr is also safe
                }
            }
            else if(pathVisit[neighbour] == 1) {
                return true;    // If neighbour is a part of a cycle return as a safe 
            }
        }
        check[vertex] = 1;      // mark as safe node
        pathVisit[vertex] = 0;  // backtrack and change to previous
        return false;
    }
}
