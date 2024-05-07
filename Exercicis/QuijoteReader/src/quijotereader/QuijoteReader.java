package quijotereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 *
 * @author Pau Toni Bibiloni Martínez
 */
public class QuijoteReader {

    /**
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        System.out.println(countWords("el_quijote.txt"));
    }

    public static long countWords(String path) {
        HashSet<String> set = new HashSet<>();
        int count = 0;

        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(path))) {
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();
            while(line != null) {
                StringTokenizer st = new StringTokenizer(line," ,.:;¿?¡!()[]«»-'\"");
                while(st.hasMoreTokens()) {
                    if(set.add(st.nextToken())) count++;
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        } catch (Exception e) {
            throw new RuntimeException("Error reading file");
        }
        return count;
    }

}
