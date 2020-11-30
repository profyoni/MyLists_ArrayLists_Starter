package edu.touro.cs;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testToString() {
        Person p1 = new Person();
        Person p2 = new Person();

        assertEquals("Person{firstName='null', lastName='null', id=0, birthday=null}",
                p1.toString());
    }

    @Test
    void testEquals() {
        Person p1 = new Person();
        Person p2 = new Person();

        assertEquals(p1, p2);
    }
    @Test
    void testEquals2() {
        Person p1 = new Person();
        Person p2 = new Person();

        assertEquals(p1, "A string");
    }

    @Test
    void hashcode() {
        Object o1 = new Person();

        assertEquals(121, o1.hashCode());
    }

    @Test
    void compareTo() {
        Person p1 = new Person("Bob","Thompson",2,new Date(), Gender.MALE);
        Person p2 = new Person("Bertha","Thomson",2,new Date(), Gender.FEMALE);
        Person p3 = new Person("Zobby","Simmons",2999,new Date(), Gender.OTHER);
        Person p4 = new Person("Martha","Stewart",2,new Date(), Gender.FEMALE);

        List<Person> list = Arrays.asList(new Person[]{p1,p2,p3,p4});
        Collections.sort(list);


        assertEquals(p3, list.get(0));
        assertEquals(p2, list.get(3));
    }


    @Test
    void compare() {
        Person p1 = new Person("Bob","Thompson",211111, new Date(), Gender.MALE);
        Person p2 = new Person("Bertha","Thomson",22,new Date(), Gender.FEMALE);
        Person p3 = new Person("Zobby","Simmons",2999,new Date(), Gender.OTHER);
        Person p4 = new Person("Martha","Stewart",1938,new Date(), Gender.FEMALE);

        List<Person> list = Arrays.asList(new Person[]{p1,p2,p3,p4});
        Collections.sort(list, new MyPersonComparator() );


        assertEquals(p2, list.get(0));
        assertEquals(p1, list.get(3));
    }
}