// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
// You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

// Example 1:
// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.
  
// Example 2:
// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 
// Constraints:
// 1 <= numCourses <= 2000
// 0 <= prerequisites.length <= 5000
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// All the pairs prerequisites[i] are unique.

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Form a graph from the prerequisites and detect if a cycle present there or not

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int vertices = numCourses;

        for(int i=0;i<vertices;i++) {
            graph.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for(int i=0;i<m;i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // Include topological Sort and get a List of all nodes

        int inDegree[] = new int[vertices];
        for(int i=0;i<vertices;i++) {
            for(int neighbour : graph.get(i)) {
                inDegree[neighbour]++;              // Create a inDegree for every vertex
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<vertices;i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            topo.add(curr);

            for(int neighbour : graph.get(curr)) {
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        // Check if all nodes present in the node. If there is any cycle then the condition is false
        return topo.size() == vertices;
    }
}
