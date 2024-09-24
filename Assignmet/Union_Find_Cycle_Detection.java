class UnionFind {
    int[] parent, rank;
    UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    int find(int i) {
        if (parent[i] != i) parent[i] = find(parent[i]);
        return parent[i];
    }
    void union(int x, int y) {
        int xroot = find(x), yroot = find(y);
        if (xroot != yroot) {
            if (rank[xroot] < rank[yroot]) parent[xroot] = yroot;
            else if (rank[xroot] > rank[yroot]) parent[yroot] = xroot;
            else {
                parent[yroot] = xroot;
                rank[xroot]++;
            }
        }
    }
    boolean isCycle(int[][] edges) {
        for (int[] edge : edges) {
            int x = find(edge[0]);
            int y = find(edge[1]);
            if (x == y) return true;
            union(x, y);
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] edges = { {0, 1}, {1, 2}, {0, 2} };
        UnionFind uf = new UnionFind(3);
        System.out.println(uf.isCycle(edges));
    }
}
