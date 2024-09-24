import java.util.*;

class Dijkstra {
    static class Node implements Comparable<Node> {
        int vertex, weight;
        Node(int v, int w) { vertex = v; weight = w; }
        public int compareTo(Node other) { return this.weight - other.weight; }
    }
    static void dijkstra(int[][] graph, int src) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;
            if (visited[u]) continue;
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
    public static void main(String[] args) {
        int[][] graph = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                          { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                          { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                          { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                          { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                          { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                          { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                          { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                          { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        dijkstra(graph, 0);
    }
}
