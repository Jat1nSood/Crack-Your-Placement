
class Solution {
    
    public boolean dfs(int node, int[] vis, int[] pathVis, ArrayList<ArrayList<Integer>> adj){
        
        vis[node] = 1;
        pathVis[node] = 1;
        
        for(int adjNode : adj.get(node)){
            
            if(vis[adjNode] == 0){
                if(dfs(adjNode, vis, pathVis, adj)) return true;
            }
            else if(vis[adjNode] == 1 && pathVis[adjNode] == 1) return true;
        }
        
        pathVis[node] = 0;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                if(dfs(i, vis, pathVis, adj)) return true;
            }
        }
        return false;
    }
}