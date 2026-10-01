import java.util.*;

class Solution {
    public int minTime(int[] duration, int[][] dependencies) {

        int n = duration.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];

        for (int[] edge : dependencies) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            indegree[v]++;
        }
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = duration[i];
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int completed = 0;
        int answer = 0;

        while (!queue.isEmpty()) {

            int u = queue.poll();
            completed++;

            answer = Math.max(answer, dp[u]);

            for (int v : graph.get(u)) {
                dp[v] = Math.max(dp[v], dp[u] + duration[v]);

                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }
        if (completed != n) {
            return -1;
        }

        return answer;
    }
}
