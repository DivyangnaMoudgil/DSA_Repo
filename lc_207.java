
import java.util.*;

public class lc_207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create an adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Store the number of prerequisites for each course
        int[] indegree = new int[numCourses];

        // Build the graph
        for (int[] prerequisite : prerequisites) {

            int course = prerequisite[0];
            int prereq = prerequisite[1];

            graph.get(prereq).add(course);

            indegree[course]++;
        }

        // Add all courses with indegree 0 to the queue
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Count the number of courses we can complete
        int completedCourses = 0;

        // Process courses using BFS
        while (!queue.isEmpty()) {

            int current = queue.poll();

            completedCourses++;

            // Visit all courses dependent on current course
            for (int next : graph.get(current)) {

                indegree[next]--;

                // If all prerequisites are completed
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // If all courses can be completed, return true
        return completedCourses == numCourses;
    }
}
