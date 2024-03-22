package Main;

public class Pasajero {
    private String nombre;
    private String DNI;
    private String destino;

    public Pasajero(String nombre, String DNI, String destino) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.destino = destino;
    }

    public Pasajero(String nombre, String DNI, String telefon, String c, String m) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.destino = c + " " + m;
    }
}
