class Solution {

    boolean[] vis;
    List<Integer>[] graph;

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        graph = new ArrayList[n];
        vis = new boolean[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < invocations.length; i++)
            graph[invocations[i][0]].add(invocations[i][1]);

        dfs(k);

        for (int i = 0; i < invocations.length; i++) {
            int u = invocations[i][0];
            int v = invocations[i][1];

            if (!vis[u] && vis[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int j = 0; j < n; j++)
                    ans.add(j);
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++)
            if (!vis[i])
                ans.add(i);

        return ans;
    }

    void dfs(int node) {

        vis[node] = true;

        for (int i = 0; i < graph[node].size(); i++) {
            int next = graph[node].get(i);
            if (!vis[next])
                dfs(next);
        }
    }
}
