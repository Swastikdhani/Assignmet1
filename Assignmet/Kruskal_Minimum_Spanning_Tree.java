import java.util.*;

class Kruskal {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;
        Edge(int s, int d, int w) { src = s; dest = d; weight = w; }
        public int compareTo(Edge other) { return this.weight - other.weight; }
    }
    static class Subset {
        int parent, rank;
    }
    static int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }
    static void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x), yroot = find(subsets, y);
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    static void kruskal(int[][] graph) {
        int V = graph.length;
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < V; i++)
            for (int j = i + 1; j < V; j++)
                if (graph[i][j] != 0)
                    edges.add(new Edge(i, j, graph[i][j]));
        Collections.sort(edges);
        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; v++) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        List<Edge> result = new ArrayList<>();
        for (Edge edge : edges) {
            int x = find(subsets, edge.src);
            int y = find(subsets, edge.dest);
            if (x != y) {
                result.add(edge);
                union(subsets, x, y);
            }
        }
        for (Edge e : result)
            System.out.println(e.src + " -- " + e.dest + " == " + e.weight);
    }
    public static void main(String[] args) {
        int[][] graph = { { 0, 2, 0, 6, 0 },
                          { 2, 0, 3, 8, 5 },
                          { 0, 3, 0, 0, 7 },
                          { 6, 8, 0, 0, 9 },
                          { 0, 5, 7, 9, 0 } };
        kruskal(graph);
    }
}
