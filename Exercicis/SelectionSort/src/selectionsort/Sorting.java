package selectionsort;

/**
 *
 * @author Pau Toni Bibiloni Martínez
 */
public class Sorting {

    public Sorting() {
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
}
