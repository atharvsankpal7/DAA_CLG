import java.util.Scanner;

public class _08_DP_Knapsack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        System.out.println("Enter the weights of each item:");
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        System.out.println("Enter the values of each item:");
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        System.out.print("Enter the maximum weight capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        int maxValue = knapsackDynamicProgramming(weights, values, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);

        scanner.close();
    }

    private static int knapsackDynamicProgramming(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }
}
