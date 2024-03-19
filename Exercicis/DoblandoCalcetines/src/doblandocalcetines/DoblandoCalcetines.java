package doblandocalcetines;
import java.util.Scanner;

public class DoblandoCalcetines {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        while (casoPrueba());

        System.out.println("FIN");
    }

    public static boolean casoPrueba() {
        if (!sc.hasNextInt()) {
            System.out.println("Error: se esperaba un número entero.");
            return false;
        }

        int n = sc.nextInt();
        if (n == 0) {
            return false;
        } else {
            int max = 0;
            int[] calcetines = new int[n];
            int impar = 0;

            for (int i = 0; i < n; i++) {
                if (!sc.hasNextInt()) {
                    System.out.println("Error: se esperaba un número entero.");
                    return false;
                }
                boolean found = false;
                calcetines[i] = sc.nextInt();
                for (int j = 0; j < i && !found; j++) {
                    if (calcetines[i] == calcetines[j]) {
                        found = true;
                        calcetines[i] = -1; calcetines[j] = -1;
                    }
                } 
                if (!found){
                    impar++;
                    if (impar > max) max = impar;
                } else {
                    impar--;
                }
            }
            System.out.println("Max: " + max);
            return true;
        }
    }
}