package Mapping;

/**
 *
 * @author Pau Toni Bibiloni Martínez
 * @param <K>
 * @param <V>
 */
public interface Map<K,V> {
    /**
     * Este metodo obtiene el valor asociado a una clave en el mapping.
     * 
     * @param key clave a buscar en el mapping.
     * @return el valor asociado a la clave pasada como parámetro.
     */
    public V get(K key);

    /**
     * Este método añade un nuevo par clave-valor al mapping.
     * 
     * @param key clave a añadir al mapping.
     * @param value valor asociado a la clave.
     * @return el valor anterior asociado a la clave, si existía o null si no.
     */
    public V put(K key, V value);

    /**
     * Este método elimina un par clave-valor del mapping.
     * 
     * @param key clave a eliminar del mapping.
     * @return el valor asociado a la clave, si existía o null si no.
     */
    public V remove(K key);

    /**
     * Este método comprueba si el mapping está vacío.
     * 
     * @return true si el mapping está vacío, false en caso contrario.
     */
    public boolean isEmpty();

}
