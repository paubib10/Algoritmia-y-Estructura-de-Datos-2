package selectionsort;

/**
 *
 * @author Pau Toni Bibiloni Martínez
 */
public class Main {

    /**
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        /* int[] arr = generateRandomArray(10);
        printArray(arr);
        System.out.println();

        long startTime = System.currentTimeMillis();
        Sorting.selectionsort(arr);
        long endTime = System.currentTimeMillis();

        printArray(arr); */

        int[] n = {10, 100, 1000, 10000, 100000, 200000, 300000, 500000, 600000};
        for (int i = 0; i < n.length; i++) {
            int[] arr = generateRandomArray(n[i]);
            long startTime = System.currentTimeMillis();
            Sorting.selectionsort(arr);
            long endTime = System.currentTimeMillis();
            System.out.println("Tiempo de ejecución para " + n[i] + " elementos: " + (endTime - startTime) + " ms");
        }

    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }

}
