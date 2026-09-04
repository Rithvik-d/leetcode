import java.util.*;

class Solution {
    private int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> conn : connections) {
            int u = conn.get(0);
            int v = conn.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] tin = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        List<List<Integer>> bridges = new ArrayList<>();

        dfs(0, -1, adj, tin, low, visited, bridges);

        return bridges;
    }

    private void dfs(int node, int parent, List<List<Integer>> adj, int[] tin, int[] low, boolean[] visited, List<List<Integer>> bridges) {
        visited[node] = true;
        tin[node] = low[node] = timer++;

        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) {
                continue;
            }
            if (!visited[neighbor]) {
                dfs(neighbor, node, adj, tin, low, visited, bridges);
                low[node] = Math.min(low[node], low[neighbor]);
                
                // If neighbor cannot reach node or an ancestor of node, the edge is critical
                if (low[neighbor] > tin[node]) {
                    bridges.add(Arrays.asList(node, neighbor));
                }
            } else {
                // Back-edge found, update lowest reachable discovery time
                low[node] = Math.min(low[node], tin[neighbor]);
            }
        }
    }
}