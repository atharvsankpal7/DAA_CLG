public class _02_DAC_MinMax {
    static int[] arr = new int[]{10, 3, 56, 45241, 7, 2, 7, 1, 4, 67, 32};
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int low = 0;
        int high = arr.length - 1;
        minMax(low, high);
        System.out.println("min--> " + min);
        System.out.println("max--> " + max);
    }

    static void minMax(int low, int high) {
        //For 1 element
        if (low == high) {
            if (arr[low] > max) {
                max = arr[low];
            }
            if (arr[low] < min) {
                min = arr[low];
            }
            return;
        }

        //For 2 elements
        if (low == high - 1) {
            if (arr[low] > arr[high]) {
                if (arr[low] > max) {
                    max = arr[low];
                }
                if (arr[high] < min) {
                    min = arr[low];
                }
            } else {
                if (arr[low] < min) {
                    min = arr[low];
                }
                if (arr[high] > max) {
                    max = arr[high];
                }
            }
            return;
        }

        //For more elements
        int mid = (high + low) / 2;
        minMax(mid + 1, high);
        minMax(low, mid - 1);
    }
}
