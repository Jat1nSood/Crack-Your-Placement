class DisjointSet{

    int v;
    int[] parent;
    int[] size;

    DisjointSet(int v){
        this.v = v;
        this.parent  = new int[v];
        this.size = new int[v];
        for(int i = 0; i < v; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    // Find Parent Function
    int findParent(int u){
        if(parent[u] == u) return u;
        return parent[u] = findParent(parent[u]);
        // return parent[u];
    }
    void unionBySize(int u, int v){

        int ulti_parent_u = findParent(u);
        int ulti_parent_v = findParent(v);

        if(ulti_parent_u == ulti_parent_v) return;

        if(size[ulti_parent_v] < size[ulti_parent_u]){
            parent[ulti_parent_v]  = ulti_parent_u;
            size[ulti_parent_u] += size[ulti_parent_v];
        } else{
            parent[ulti_parent_u] = ulti_parent_v;
            size[ulti_parent_v] += size[ulti_parent_u];
        }
    }
}


class Solution {
    public int removeStones(int[][] stones) {
        int rows = 0;
        int cols = 0;

        for(int i  = 0; i < stones.length; i++){
            rows = Math.max(rows, stones[i][0]);
            cols = Math.max(cols, stones[i][1]);
        }

        int n = (rows + cols + 1);
        DisjointSet ds = new DisjointSet(n + 1);

        for(int[] it : stones){
            int u = it[0];
            int v = it[1] + rows + 1;
            ds.unionBySize(u, v);
        }

        Set<Integer> set = new HashSet<>();

        for(int[] stone : stones){
            
            set.add(ds.findParent(stone[0]));
            set.add(ds.findParent(stone[1] + rows + 1));
        }


        return stones.length  - set.size();
    }
}
