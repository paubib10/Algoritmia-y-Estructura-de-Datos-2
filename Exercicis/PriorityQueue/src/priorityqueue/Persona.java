package priorityqueue;

/**
 *
 * @author Pau Toni Bibiloni Martínez
 */
public class Persona implements Comparable<Persona>{
    
    private String name;
    private int age;

    public Persona(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // EDAD
    public int compareTo(Persona p) {
        return Integer.compare(this.age, p.getAge());
    }

    // NOMBRE
    public int compareTo2(Persona p) {
        return this.name.compareTo(p.getName());
    }
}
