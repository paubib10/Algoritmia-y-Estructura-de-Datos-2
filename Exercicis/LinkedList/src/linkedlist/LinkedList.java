package linkedlist;

/**
 *
 * @author Pau Toni Bibiloni Martínez
 */
public class LinkedList<E extends Comparable<E>>{

    private Node<E> first;

    // Constructor
    public LinkedList() {
        first = null;
    }

    // Añade un elemento al principio de la lista
    public void add(E element) {
        first = new Node<>(element, first);
    }

    // Genera un String con los elementos de la lista
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> aux = first;

        while (aux != null) {
            sb.append(aux.getItem()).append(" ");
            aux = aux.getNext();
        }

        return sb.toString();
    }

    private Node middle(Node<E> first) {
        Node<E> slow = first;
        Node<E> fast = first;
    
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
    
        return slow;
    }

    public void mergeSort() {
        first = mergeSort(first);
    }   

    private Node<E> mergeSort(Node<E> first) {
        if (first == null || first.getNext() == null) {
            return first;
        }

        Node<E> middle = middle(first);
        Node<E> nextOfMiddle = middle.getNext();

        middle.setNext(null);

        Node<E> left = mergeSort(first);
        Node<E> right = mergeSort(nextOfMiddle);

        return merge(left, right);
    }

    private Node<E> merge(Node<E> left, Node<E> right) {
        Node<E> result = null;
    
        if (left == null) return right;
        else if (right == null) return left;
        
    
        int comparison = left.getItem().compareTo(right.getItem());
    
        if (comparison <= 0) {
            // Si el elemento izquierdo es menor o igual al derecho,
            // establecemos el nodo izquierdo como el resultado
            result = left;
    
            // Luego, establecemos el siguiente nodo del resultado como el resultado
            // de la mezcla del siguiente nodo del lado izquierdo y el nodo derecho
            Node<E> nextMergeResult = merge(left.getNext(), right);
            result.setNext(nextMergeResult);
        } else {
            // Si el elemento derecho es menor que el izquierdo,
            // establecemos el nodo derecho como el resultado
            result = right;
    
            // Luego, establecemos el siguiente nodo del resultado como el resultado
            // de la mezcla del nodo izquierdo y el siguiente nodo del lado derecho
            Node<E> nextMergeResult = merge(left, right.getNext());
            result.setNext(nextMergeResult);
        }
    
        // Devolvemos el nodo resultante, que es el inicio de la lista mezclada
        return result;
    }
}