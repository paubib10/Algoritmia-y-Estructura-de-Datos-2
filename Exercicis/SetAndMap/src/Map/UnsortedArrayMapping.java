package Mapping;

/**
 * 
 * @author Pau Toni Bibiloni Martínez
 */
public class UnsortedArrayMapping<K,V> implements Map<K,V>{
    private K[] claves;
    private V[] valores;
    private int n;

    // Prepara los arrays para almacenar el mapping
    public UnsortedArrayMapping(int max) {
        this.claves = (K[]) new Object[max];
        this.valores = (V[]) new Object[max];
        this.n = 0;
    }

    // Consultar valor asociado a la clave
    @Override
    public V get(K key) {
        for (int i = 0; i < this.n; i++) {
            if (this.claves[i].equals(key)) {
                return this.valores[i];
            }
        }
        return null;
    }

    // Añadir un nuevo par clave-valor
    // Devuelve el valor anterior asociado a la clave, si existía o null si no
    @Override
    public V put(K key, V value) {
        for (int i = 0; i < this.n; i++) {
            if (this.claves[i].equals(key)) {
                V old = this.valores[i];
                this.valores[i] = value;
                return old;
            }
        }
        this.claves[this.n] = key;
        this.valores[this.n] = value;
        this.n++;
        return null;
    }

    // Eliminar un par clave-valor
    // Devuelve el valor asociado a la clave, si existía o null si no
    @Override
    public V remove(K key) {
        for (int i = 0; i < this.n; i++) {
            if (this.claves[i].equals(key)) {
                V old = this.valores[i];
                this.claves[i] = this.claves[this.n - 1];
                this.valores[i] = this.valores[this.n - 1];
                this.n--;
                return old;
            }
        }
        return null;
    }

    // Consultar si el mapping está vacío
    @Override
    public boolean isEmpty() {
        return this.n == 0;
    }
        
}