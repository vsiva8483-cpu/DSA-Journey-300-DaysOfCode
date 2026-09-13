import java.util.*;

class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();

        int[] a = bfs(1, adj, n);
        int[] b = bfs(a[0], adj, n);

        return (b[1] + 1) / 2;
    }

    private int[] bfs(int start, ArrayList<ArrayList<Integer>> adj, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        int[] q = new int[n];
        int front = 0, rear = 0;

        q[rear++] = start;
        dist[start] = 0;

        int far = start;

        while (front < rear) {
            int u = q[front++];

            for (int v : adj.get(u - 1)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q[rear++] = v;

                    if (dist[v] > dist[far])
                        far = v;
                }
            }
        }

        return new int[]{far, dist[far]};
    }
}
