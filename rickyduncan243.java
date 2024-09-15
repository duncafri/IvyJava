/* 
 Author: Ricky Duncan
SDEV200-11
09/13/2024
Assignment: Module 4 Programming Assignment (3)
*/

import java.util.ListIterator;

public class Node<E> {
    E element;
    Node<E> next;
    Node<E> previous;

    public Node(E e) {
        element = e;
        next = null;
        previous = null;
    }
}

public class TwoWayLinkedList<E> implements MyList<E> {
    private Node<E> head, tail;
    private int size = 0;

    /** Create an empty list */
    public TwoWayLinkedList() {
    }

    /** Create a list from an array of objects */
    public TwoWayLinkedList(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            addLast(objects[i]);
    }

    /** Return the head element in the list */
    public E getFirst() {
        if (size == 0) return null;
        else return head.element;
    }

    /** Return the last element in the list */
    public E getLast() {
        if (size == 0) return null;
        else return tail.element;
    }

    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    /** Add an element to the end of the list */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> newNode = new Node<>(e);
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next.previous = newNode;
            current.next = newNode;
            newNode.previous = current;
            size++;
        }
    }

    /** Remove the first node and return the object that is contained in the removed node */
    public E removeFirst() {
        if (size == 0) return null;
        else {
            E temp = head.element;
            head = head.next;
            if (head != null) head.previous = null;
            size--;
            if (size == 0) tail = null;
            return temp;
        }
    }

    /** Remove the last node and return the object that is contained in the removed node */
    public E removeLast() {
        if (size == 0) return null;
        else {
            E temp = tail.element;
            tail = tail.previous;
            if (tail != null) tail.next = null;
            size--;
            if (size == 0) head = null;
            return temp;
        }
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) return null;
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E temp = current.element;
        current.previous.next = current.next;
        current.next.previous = current.previous;
        size--;
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            result.append(current.element);
            current = current.next;
            if (current != null) result.append(", ");
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean contains(Object e) {
        Node<E> current = head;
        while (current != null) {
            if (current.element.equals(e)) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public E get(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public int size() {
        return size;
    }

    // Implement listIterator() and listIterator(int index)
    public ListIterator<E> listIterator() {
        return new TwoWayLinkedListIterator(0);
    }

    public ListIterator<E> listIterator(int index) {
        return new TwoWayLinkedListIterator(index);
    }

    private class TwoWayLinkedListIterator implements ListIterator<E> {
        private Node<E> current;
        private int index;

        public TwoWayLinkedListIterator(int index) {
            current = head;
            for (int i = 0; i < index && current != null; i++) {
                current = current.next;
            }
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E element = current.element;
            current = current.next;
            return element;
        }

        @Override
        public boolean hasPrevious() {
            return current != null && current.previous != null;
        }

        @Override
        public E previous() {
            current = current.previous;
            return current.element;
        }

        @Override
        public int nextIndex() {
            return index++;
        }

        @Override
        public int previousIndex() {
            return index--;
        }

        @Override
        public void remove() {
            // Left as an exercise
        }

        @Override
        public void set(E e) {
            // Left as an exercise
        }

        @Override
        public void add(E e) {
            // Left as an exercise
        }
    }
}