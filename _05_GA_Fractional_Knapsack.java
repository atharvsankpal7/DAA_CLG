import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Item {
    int weight, value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class FractionalKnapsack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        Item[] items = new Item[n];

        System.out.println("Enter the weight and value of each item:");

        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " - Weight: ");
            int weight = scanner.nextInt();
            System.out.print("Item " + (i + 1) + " - Value: ");
            int value = scanner.nextInt();
            items[i] = new Item(weight, value);
        }

        System.out.print("Enter the maximum weight capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        double maxValue = fractionalKnapsack(items, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);

        scanner.close();
    }

    private static double fractionalKnapsack(Item[] items, int capacity) {
        Arrays.sort(items, Comparator.comparingDouble(item -> (double) item.value / item.weight));

        double totalValue = 0;
        int currentWeight = 0;

        for (int i = items.length - 1; i >= 0; i--) {
            if (currentWeight + items[i].weight <= capacity) {
                totalValue += items[i].value;
                currentWeight += items[i].weight;
            } else {
                double remainingWeight = capacity - currentWeight;
                totalValue += (remainingWeight / items[i].weight) * items[i].value;
                break;
            }
        }

        return totalValue;
    }
}
