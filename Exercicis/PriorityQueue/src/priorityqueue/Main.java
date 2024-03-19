package priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Pau Toni Bibiloni Martínez
 */
public class Main {

    /**
     * @param args The command line arguments.
     */
    public static void main(String[] args) 
    {
        Persona p1 = new Persona("Damiana", 20); 
        Persona p2 = new Persona("Emili", 22);
        Persona p3 = new Persona("Francesa", 23);
        Persona p4 = new Persona("Lucia", 24);
        Persona p5 = new Persona("Maria", 21);
        Persona p6 = new Persona("Neus", 25);

        PriorityQueue<Persona> heap = new PriorityQueue<>(Comparator.comparing(Persona::getName));
        
        for (Persona p : new Persona[]{p1, p2, p3, p4, p5, p6}) 
        {
            heap.offer(p);
        }

        while (!heap.isEmpty()) 
        {
            System.out.println(heap.poll().getName());
        }
    }

}
