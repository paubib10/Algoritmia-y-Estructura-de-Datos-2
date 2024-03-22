package modas152;

import java.util.Scanner;

/**
 *
 * @author Pau Toni Bibiloni Martínez
 */
public class Modas152 {

    /**
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // Leer número de valores
            int numValues = sc.nextInt();
            if (numValues == 0) break;
            
            // Leer valores
            int[] values = new int[numValues];
            for (int i = 0; i < numValues; i++) {
                values[i] = sc.nextInt();
            }
    
            // Ordenar los valores O(n log n)
            quicksort(values, 0, numValues - 1);
            
            int maxFrequency = 0, mode = -1, currentFrequency = 1;
            // Calcular la moda
            for (int i = 1; i < numValues; i++) {
                if (values[i] == values[i - 1]) {
                    currentFrequency++;
                } else {
                    if (currentFrequency > maxFrequency) {
                        maxFrequency = currentFrequency;
                        mode = values[i - 1];
                    }
                    currentFrequency = 1;
                }
            }
            
    
            // Verificar si el último valor es la moda
            if (currentFrequency > maxFrequency) {
                mode = values[numValues - 1];
            }
            System.out.println(mode);
        }
        sc.close();
    }

    /**
     * Este método ordena un array de enteros utilizando el algoritmo de quicksort.
     * 
     * Orden de complejidad O(n log n).
     * 
     * @param arr Array de enteros a ordenar.
     * @param start Índice de inicio del array.
     * @param end Índice de fin del array.
     */
    private static void quicksort(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = generatePivot(arr, start, end);
            quicksort(arr, start, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, end);
        }
    }
    
    /**
     * Este método ordena los valores de un array de forma que los 
     * valores menores al pivote queden a la izquierda y los mayores
     * a la derecha. Seguidamente, se coloca
     * el pivote en su posición correcta.
     * 
     * Orden de complejidad O(n).
     * 
     * @param arr Array de enteros.
     * @param start Índice de inicio del array.
     * @param end Índice de fin del array.
     * @return Índice del pivote.
     */
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) swap(arr, ++i, j);
        }
        swap(arr, i + 1, end);
        return i + 1;
    }
    
    /**
     * Este método genera el pivote para el algoritmo de quicksort.
     * Este consiste en seleccionar el valor medio entre el primer, 
     * último y valor central del array.
     * Luego, se ordenan los valores de forma que el pivote quede 
     * en la posición correcta.
     * 
     * Orden de complejidad O(1).
     * 
     * @param arr Array de enteros.
     * @param start Índice de inicio.
     * @param end Índice de fin.
     * @return Índice del pivote.
     */
    private static int generatePivot(int[] arr, int start, int end) {
        int mid = (start + end) / 2; 
        if (arr[mid] < arr[start]) swap(arr, mid, start);
        if (arr[end] < arr[start]) swap(arr, end, start);
        if (arr[end] < arr[mid]) swap(arr, end, mid);
        swap(arr, mid, end);
        return partition(arr, start, end);
    }

    /**
     * Este método intercambia dos valores de un array.
     * 
     * Orden de complejidad O(1).
     * 
     * @param arr Array de enteros.
     * @param i Índice del primer valor.
     * @param j Índice del segundo valor.
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/**
 * Este código utiliza el algoritmo Quicksort para ordenar los 
 * valores ingresados por el usuario. 
 * Quicksort es un algoritmo eficiente que ordena los elementos 
 * en su lugar, es decir, no requiere espacio adicional.
 * 
 * En este caso, Quicksort se utiliza para calcular la moda, 
 * que es el valor que aparece con mayor frecuencia.
 * Para hacer esto, Quicksort ordena los valores y luego el 
 * código recorre el array ordenado para encontrar el valor 
 * que aparece con mayor frecuencia.
 *
 * La variante de Quicksort utilizada en este código es la que 
 * utiliza el "pivote mediano de tres", que selecciona el pivote 
 * como el valor medio entre el primer, último y valor central del array.
 * Esta variante puede mejorar el rendimiento en arrays que 
 * ya están parcialmente ordenados.
 */
