
class Solution {
    // Function to detect cycle in an undirected graph.
    
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int parent){
        vis[node] = 1;
        for(int adjNode : adj.get(node)){
            if(adjNode == parent) continue;
            if(vis[adjNode] == 0){
                if(dfs(adjNode, adj, vis, node)) return true;
            }
            else if(vis[adjNode] == 1) return true;
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] vis = new int[V];
        for(int i = 0; i < V; i++){
            if(vis[i] == 0)
                if(dfs(i, adj, vis, -1)) return true;
        }
        return false;
    }
}