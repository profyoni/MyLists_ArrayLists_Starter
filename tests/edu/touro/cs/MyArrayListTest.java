package edu.touro.cs;

import  org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @org.junit.jupiter.api.Test
    void size() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void containsTrue() {
        MyArrayList mal = new MyArrayList();
        mal.add("A");
        assertEquals(true, mal.contains("A"));
    }

    @org.junit.jupiter.api.Test
    void containsFalse() {
        MyArrayList mal = new MyArrayList();
        assertEquals(false, mal.contains("A"));
    }

    @org.junit.jupiter.api.Test
    void add() {
        MyArrayList mal = new MyArrayList();
        mal.add("A");
        assertEquals(1, mal.size());
    }

    @org.junit.jupiter.api.Test
    void toArray() { // sharing private issue test
        MyArrayList mal = new MyArrayList();
        mal.add("A");
        Object [] backDoor = mal.toArray();
        backDoor[0] = "HAHHA";

        assertEquals("A", mal.get(0));
    }
}