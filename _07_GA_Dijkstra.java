import java.util.Arrays;
import java.util.Scanner;

public class _07_GA_Dijkstra {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the graph: ");
        int vertices = scanner.nextInt();

        int[][] graph = new int[vertices][vertices];

        System.out.println("Enter the adjacency matrix of the graph (use Integer.MAX_VALUE for infinity):");

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter the source vertex: ");
        int source = scanner.nextInt();

        dijkstra(graph, source);

        scanner.close();
    }

    private static void dijkstra(int[][] graph, int source) {
        int vertices = graph.length;
        int[] distance = new int[vertices];
        boolean[] visited = new boolean[vertices];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for (int count = 0; count < vertices - 1; count++) {
            int u = minDistance(distance, visited);
            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE &&
                        distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        printSolution(distance, source);
    }

    private static int minDistance(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < distance.length; v++) {
            if (!visited[v] && distance[v] <= min) {
                min = distance[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private static void printSolution(int[] distance, int source) {
        System.out.println("Shortest distances from the source vertex " + source + ":");

        for (int i = 0; i < distance.length; i++) {
            System.out.println("To vertex " + i + ": " + distance[i]);
        }
    }
}
