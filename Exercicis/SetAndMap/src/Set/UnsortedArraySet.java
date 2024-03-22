package Set;

/**
 *
 * @author Pau Toni Bibiloni Martínez
 */
public class UnsortedArraySet<E> implements Set<E>{
    private E[] arr;
    private int n;

    // Prepara el arrays para almacenar el conjunto
    public UnsortedArraySet(int max) {
        this.arr = (E[]) new Object[max];
        this.n = 0;
    }

    // Consultar si el conjunto contiene un elemento
    @Override
    public boolean contains(E elem) {
        for (int i = 0; i < n; i++) {
            if (arr[i].equals(elem)) {
                return true;
            }
        }
        return false;
    }
    
    // Añadir un elemento al conjunto (si aun no se encuentra en él)
    // Devuelve true si se ha cambiado el conjunto, false en caso contrario
    @Override
    public boolean add(E elem) {
        if (n == arr.length) {
            return false; // el conjunto está lleno
        }
        if (contains(elem)) {
            return false; // el elemento ya está en el conjunto
        }
        arr[n] = elem;
        n++;
        return true;
    }

    // Eliminar un elemento del conjunto (si se encuentra en él)
    // Devuelve true si se ha cambiado el conjunto, false en caso contrario
    @Override
    public boolean remove(E elem) {
        for (int i = 0; i < n; i++) {
            if (arr[i].equals(elem)) {
                arr[i] = arr[n - 1]; // reemplaza el elemento con el último en el conjunto
                arr[n - 1] = null; // elimina la referencia al último elemento
                n--;
                return true;
            }
        }
        return false;
    }

    // Consultar si el conjunto está vacío
    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    
}
