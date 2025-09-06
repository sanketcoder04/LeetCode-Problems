// There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). 
// The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. 
// Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
// You want to determine if there is a valid path that exists from vertex source to vertex destination.
// Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

// Example 1:
// Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
// Output: true
// Explanation: There are two paths from vertex 0 to vertex 2:
// - 0 → 1 → 2
// - 0 → 2
  
// Example 2:
// Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
// Output: false
// Explanation: There is no path from vertex 0 to vertex 5.
 
// Constraints:
// 1 <= n <= 2 * 105
// 0 <= edges.length <= 2 * 105
// edges[i].length == 2
// 0 <= ui, vi <= n - 1
// ui != vi
// 0 <= source, destination <= n - 1
// There are no duplicate edges.
// There are no self edges.

class FindifPathExistsinGraph {
    class Edges {
        int source;
        int destination;
        
        public Edges(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    ArrayList<Edges>[] graph = null;

    // Convert src -> dest pair to Adjacency List
    public void create(int vertices, int[][] edges) {
        this.graph = new ArrayList[vertices];
        for(int i=0;i<vertices;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int row=0;row<edges.length;row++) {
            int src = edges[row][0];
            int dest = edges[row][1];

            graph[src].add(new Edges(src, dest));
            graph[dest].add(new Edges(dest, src));
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        create(n, edges);
        boolean[] visited = new boolean[graph.length];
        return hasPath(source, destination, visited);
    }

    private boolean hasPath(int src, int dest, boolean[] visited) {
        if(src == dest) {
            return true;
        }
        visited[src] = true;
        for(int i=0;i<graph[src].size();i++) {
            Edges edge = graph[src].get(i);
            if(!visited[edge.destination] && hasPath(edge.destination, dest, visited)) {
                return true;
            }
        }
        return false;
    }
}
