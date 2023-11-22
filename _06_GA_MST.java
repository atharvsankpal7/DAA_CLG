import java.util.Arrays;
import java.util.Scanner;

public class _06_GA_MST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the graph: ");
        int n = scanner.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter the adjacency matrix of the graph:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        int minCost = primMST(graph);
        System.out.println("Minimum Cost Spanning Tree: " + minCost);

        scanner.close();
    }

    private static int primMST(int[][] graph) {
        int n = graph.length;
        int[] parent = new int[n];
        int[] key = new int[n];
        boolean[] mstSet = new boolean[n];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < n - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        int minCost = 0;
        for (int i = 1; i < n; i++) {
            minCost += graph[i][parent[i]];
        }

        return minCost;
    }

    private static int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < key.length; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }
}
