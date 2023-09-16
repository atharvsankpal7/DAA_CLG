class _01_Binary_Search {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int low = 0;

        int high = arr.length - 1;
        binarySearch(arr, low, high, 10);
    }

    static void binarySearch(int[] arr, int low, int high, int key) {
        int mid;
        while (low <= high) {
            mid = (high + low) / 2;
            if (key == arr[mid]) {
                System.out.println("Key element is present in the array");
                return;
            }
            if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Key element is not present in the array");
    }
}