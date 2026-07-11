class Solution {
    List<Integer>[] graph;
    boolean[] vis;

    public int countCompleteComponents(int n, int[][] edges) {
        graph = new ArrayList[n];
        vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int[] res = dfs(i);
                int vertices = res[0];
                int degreeSum = res[1];

                int edgesCount = degreeSum / 2;
                int expected = vertices * (vertices - 1) / 2;

                if (edgesCount == expected)
                    ans++;
            }
        }

        return ans;
    }

    private int[] dfs(int node) {
        vis[node] = true;

        int vertices = 1;
        int degreeSum = graph[node].size();

        for (int nei : graph[node]) {
            if (!vis[nei]) {
                int[] res = dfs(nei);
                vertices += res[0];
                degreeSum += res[1];
            }
        }

        return new int[]{vertices, degreeSum};
    }
}