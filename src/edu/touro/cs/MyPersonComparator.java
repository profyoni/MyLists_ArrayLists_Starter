package edu.touro.cs;

import java.util.Comparator;

public class MyPersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getId() - p2.getId();
    }
}
