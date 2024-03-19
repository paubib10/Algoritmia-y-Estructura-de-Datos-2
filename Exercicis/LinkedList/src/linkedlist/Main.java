package linkedlist;

import java.util.Scanner;

/**
 *
 * @author Pau Toni Bibiloni Martínez
 */
public class Main {

    /**
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        questionMergeSort();
    }

    private static void questionLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce los números separados por espacios: ");

        String[] numbers = sc.nextLine().split(" ");
        for (String number : numbers) {
            list.add(Integer.parseInt(number));
        }

        System.out.println("\n" + list);

        sc.close();
    }

    private static void questionMergeSort() {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce los números separados por espacios: ");

        String[] numbers = sc.nextLine().split(" ");
        for (String number : numbers) {
            list.add(Integer.parseInt(number));
        }

        // System.out.println("\n" + list);

        list.mergeSort();

        System.out.println("\n" + list);

        sc.close();
    }

}
