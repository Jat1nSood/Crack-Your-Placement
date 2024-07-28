class Solution {

    void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj){

        vis[node] = 1;

        for(int adjNode : adj.get(node)){

            if(vis[adjNode] == 0){
                dfs(adjNode, vis, adj);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {

        if(connections.length < n - 1) return -1;
        int[] vis = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    
        int unvisited = 0;

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < connections.length; i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }

        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                unvisited++;
                dfs(i, vis, adj);
            }
        }
        return unvisited - 1;

    }
}