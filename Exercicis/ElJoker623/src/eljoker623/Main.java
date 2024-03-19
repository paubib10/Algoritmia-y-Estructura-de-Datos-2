package eljoker623;

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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
    
        for (int i = 0; i < n; i++) {
            String jokerNumber = sc.nextLine();
            String[] boletoNumber = jokerNumber.split(" ");
    
            String joker = boletoNumber[0];
            String boleto = boletoNumber[1];
    
            boolean gana = true;
            for (char c : joker.toCharArray()) {
                int countInJoker = countOccurrences(joker, c);
                int countInBoleto = countOccurrences(boleto, c);
                if(countInJoker > countInBoleto){
                    gana = false;
                    break;
                }
            }
    
            if (gana) {
                System.out.println("GANA");
            } else {
                System.out.println("PIERDE");
            }
        }
    
        sc.close();
    }

    public static int countOccurrences(String str, char c) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }
}
