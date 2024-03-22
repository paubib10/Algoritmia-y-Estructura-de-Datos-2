package Set;

/**
 *
 * @author Pau Toni Bibiloni Martínez
 * @param <E>
 */
public interface Set<E> {
    /**
     * Este método comprueba si el conjunto contiene un elemento.
     * 
     * @param elem elemento a buscar en el conjunto.
     * @return true si el elemento está en el conjunto, false en caso contrario.
     */
    public boolean contains(E elem);

    /**
     * Este método añade un elemento al conjunto.
     * 
     * @param elem elemento a añadir al conjunto.
     * @return true si se ha cambiado el conjunto, false en caso contrario.
     */
    public boolean add(E elem);

    /**
     * Este método elimina un elemento del conjunto.
     * 
     * @param elem elemento a eliminar del conjunto.
     * @return true si se ha cambiado el conjunto, false en caso contrario.
     */
    public boolean remove(E elem);

    /**
     * Este método comprueba si el conjunto está vacío.
     * 
     * @return true si el conjunto está vacío, false en caso contrario.
     */
    public boolean isEmpty();
}
