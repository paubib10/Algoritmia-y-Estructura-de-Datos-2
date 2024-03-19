package quickmergesort;

/**
 *
 * @author Pau Toni Bibiloni Martínez
 */
public class Sorting {

    /**
     * Empty constructor.
     * This constructor is intentionally left empty.
     * It serves as a placeholder for future implementation.
     */
    private Sorting() {
    }
    
    // Orden de complejidad O(n^2)
    public static void selectionsort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int aux = arr[i];
            arr[i] = arr[min];
            arr[min] = aux;
        }
    }

    // Orden de complejidad O(n^2)
    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }

    // Orden de complejidad O(n)
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int aux = arr[i];
                arr[i] = arr[j];
                arr[j] = aux;
            }
        }
        int aux = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = aux;
        return i + 1;
    }

    // Orden de complejidad O(n log n)
    public static void mergesort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergesort(arr, low, mid);
            mergesort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    // Orden de complejidad O(n)
    private static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[low + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[mid + 1 + i];
        }
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
