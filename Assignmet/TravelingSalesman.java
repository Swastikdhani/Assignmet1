
import java.util.Arrays;

public class TravelingSalesman {

    static final int INF = Integer.MAX_VALUE;

    // Function to find minimum cost to visit all cities and return to the start
    public static int findMinCost(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[n][1 << n];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[0][1] = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    for (int j = 0; j < n; j++) {
                        if ((mask & (1 << j)) != 0 && i != j) {
                            dp[i][mask] = Math.min(dp[i][mask], dp[j][mask ^ (1 << i)] + graph[j][i]);
                        }
                    }
                }
            }
        }

        int minCost = INF;
        for (int i = 1; i < n; i++) {
            minCost = Math.min(minCost, dp[i][(1 << n) - 1] + graph[i][0]);
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };  // Example graph
        System.out.println("The minimum cost is: " + findMinCost(graph));
    }
}
