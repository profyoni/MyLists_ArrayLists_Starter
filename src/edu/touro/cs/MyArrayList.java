package edu.touro.cs;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// Reuse existing code wherever efficient
public class MyArrayList implements List<String> {
    // OOP : Reuse code (as long as its efficient)
    //     : Encapsulation: hide implementation/ private fields
    private String[] backingStore = new String[10];
    private int insertionPoint = 0;

    @Override
    public int size() {
        return insertionPoint;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size(); i++) {
            if (o == null && backingStore[i] == null ||
                    o != null && o.equals(backingStore[i]))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() { // TODO
        return backingStore; // never share your privates
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(String s) {
        if (insertionPoint >= backingStore.length) {
            growBackingStore();
        }
        backingStore[insertionPoint] = s;
        insertionPoint++;
        return true;
    }

    private void growBackingStore() // new array will be twice size old array
    {
        String[] newBackingStore = new String[backingStore.length * 2 + 1];
        System.arraycopy(backingStore, 0, newBackingStore, 0, backingStore.length);
        backingStore = newBackingStore;
    }

    @Override
    public boolean remove(Object o) {// TODO
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() { // TODO

    }

    @Override
    public String get(int index) {
        // TODO exception details
        if (index >= size())
            throw new IndexOutOfBoundsException(String.format("details of exception"));
        return backingStore[index];
    }

    @Override
    public String set(int index, String element) {// TODO
        return null;
    }

    @Override
    public void add(int index, String element) {// TODO

    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) { // TODO
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) { // TODO
        return 0;
    }

    @Override
    public ListIterator<String> listIterator() {
        return null;
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return null;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }
}
