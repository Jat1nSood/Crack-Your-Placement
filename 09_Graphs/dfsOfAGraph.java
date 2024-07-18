class Solution {
    
    private void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans){
        
        vis[node] = 1;
        ans.add(node);
        
        for(int adjNode : adj.get(node)){
            
            if(vis[adjNode] == 0){
                dfs(adjNode, vis, adj, ans);
            }
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        int[] vis = new int[V];
        dfs(0, vis, adj, ans);
        return ans;
    }
}
