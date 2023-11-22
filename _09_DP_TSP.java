import java.util.Arrays;
import java.util.Scanner;

public class _09_DP_TSP {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of cities: ");
        int n = scanner.nextInt();

        int[][] distanceMatrix = new int[n][n];

        System.out.println("Enter the distance matrix (use Integer.MAX_VALUE for unreachable cities):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distanceMatrix[i][j] = scanner.nextInt();
            }
        }

        int minCost = tspDynamicProgramming(distanceMatrix);
        System.out.println("Minimum cost for TSP: " + minCost);

        scanner.close();
    }

    private static int tspDynamicProgramming(int[][] distance) {
        int n = distance.length;
        int[][] dp = new int[1 << n][n];
        final int INF = Integer.MAX_VALUE;

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[1][0] = 0;

        for (int mask = 1; mask < (1 << n); mask += 2) {
            for (int u = 1; u < n; u++) {
                if ((mask & (1 << u)) != 0) {
                    for (int v = 0; v < n; v++) {
                        if ((mask & (1 << v)) != 0 && u != v) {
                            dp[mask][u] = Math.min(dp[mask][u], dp[mask ^ (1 << u)][v] + distance[v][u]);
                        }
                    }
                }
            }
        }

        int finalMask = (1 << n) - 1;
        int minCost = INF;

        for (int u = 1; u < n; u++) {
            if (distance[u][0] != INF) {
                minCost = Math.min(minCost, dp[finalMask][u] + distance[u][0]);
            }
        }

        return minCost;
    }
}
