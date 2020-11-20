package edu.touro.cs;

import java.util.*;

//public                        // U RO A R
//protected
//package private -  default
//private


public class MyLinkedList<T> implements List<T> {

    private class Node<T>
    {
        T data;
        Node<T> prev, next;

        public Node(){}
        public Node(T data, Node<T> prev, Node<T> next) {
            this.data= data;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<T> head, tail;
    private int size;

    public MyLinkedList()
    {
        head = tail = new Node<>(); // dummy node
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override //TODO
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
       return new MyLinkedListIterator();
    }

    // Principle of Least Privilege - grant as little access as needed
    // static inner class is when inner class has no need to access outer class
    // and is placed in outer class to help organize code

    private class MyLinkedListIterator implements Iterator<T>{ // inner class (static inner classes vs nonstatic inner classes)

        private Node<T> prevPtr = MyLinkedList.this.head;
        private boolean nextWasCalled, removeWasCalled;

        @Override
        public boolean hasNext() {
            return this.prevPtr.next != null;
        }

        @Override
        public T next() { // returns next data elt, and updates the ptr
            if (! hasNext())
                throw new NoSuchElementException();
            nextWasCalled = true;
            removeWasCalled = false; // allow remove to be called again
            // incr iterator;
            prevPtr = prevPtr.next;
            return prevPtr.data;   // return data elt that was next
        }

        public void remove(){
            if (! nextWasCalled)
            {
                throw new IllegalStateException("Cannot call remove unless next called first");
            }
            if (removeWasCalled)
            {
                throw new IllegalStateException("Cannot call remove twice unless next was called first");
            }
            removeWasCalled = true;
            // remove elt last returned by this iterator
            Node<T> beforeCurrent = prevPtr.prev;
            Node<T> afterCurrent = prevPtr.next;

            beforeCurrent.next = afterCurrent;
            afterCurrent.prev = beforeCurrent;
            size--;
        }
    }

    // iterators are necessary when you need to modify i.e. remove elt from list during iteration
    //
    @Override//TODO
    public Object[] toArray() {
        Object [] arr = new Object[size()];
        int i = 0;
        for (Object o : this)
        {
            arr[i++] = o;
        }
        return arr;
    }

    @Override//TODO
    public <T1> T1[] toArray(T1[] a) {
        // if a size is large enough to store this ll, add elts of ll to a
         return (T1 []) toArray();

    }

    @Override//TODO
    public boolean add(T t /* implicitly passes the this reference*/) {
        Node<T> newNode = new Node<>(t, tail, null);

        tail.next = newNode; // old last node point to new Node
        tail = newNode; // or tail = newNode // tail point to new Node

        size++;
        return true;
    }

    @Override //TODO
    public boolean remove(Object o) {
        return false;
    }

    @Override//TODO
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override//TODO
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override//TODO
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override//TODO
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override//TODO
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override//TODO
    public void clear() {
        head = tail = new Node<>(); // disconnected nodes will be garbage collected
        size = 0;
    }
// remove
// static inner class
// iterator

    private Node<T> getNode(int index) // helper : 1. ask yourself what tool will make my job easier
            // 2. look for repeated code and refactor and simplify
    {
        // size check
        Node<T> currentNode = head;
        for (int counter = 0; counter <= index;  counter++ )
            ; // BLANK
        return currentNode;
    }

    @Override//TODO
    public T get(int index) {
        return getNode(index).data;
    }

    @Override//TODO
    public T set(int index, T t) {
        Node<T> node = getNode(index);
        T oldData = node.data;
        node.data = t;
        return oldData;
    }

    @Override//TODO
    public void add(int index, T element) {

    }

    @Override//TODO
    public T remove(int index) {
        // index bounds check >=0 and < size

        Node<T> previousNode = head;
        for (int counter = 0; counter < index; previousNode = previousNode.next, counter++)
            ; // BLANK
        T oldValue = previousNode.next.data;
        previousNode.next = previousNode.next.next;
        // set prev refernce
        if (index == size-1)
        {
            tail = tail.prev;
        }
        size--;
        return oldValue;

    }

    @Override //TODO
    public int indexOf(Object o) {
        return 0;
    }

    @Override//TODO
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
