class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] vis = new int[V];
        q.offer(0);
        vis[0] = 1;
        
        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);
            
            for(int adjNode : adj.get(node)){
                if(vis[adjNode] == 0){
                    vis[adjNode] = 1;
                    q.offer(adjNode);
                }
            }
        }
        return bfs;
    }
}