package edu.touro.cs;

import java.util.*;

//class Gender..see Effective Java on enums
//{
//    final String genderType; // final instance var may set in c-tor
//    private Gender(String type){ // noone outside class can instaintuate a new gender
//        this.genderType = type;
//    }
//    public static final Gender Male = new Gender("male");
//    public static final Gender Female = new Gender("female");
//    public static final Gender Other = new Gender("other");
//}

enum Weekday {SUNDAY, MONDAY, SATURDAY} // basic enum...enhanced enums not discussing
enum DredelSide {NUN, GIMMEL, _0, _1, }
enum Gender {MALE, FEMALE, OTHER} //enumeration...isting all values

// Factory method is a static method that is used to create objects by specifiying the relevant settings/fields
// limit how objects are created, so they are instantiated correctly
enum Suit{} enum Rank{}
class Card implements Comparable<Card>{
    public Card(Suit s, Rank r){}


    public static List<Card> deck()
    {
        // returns all 52 cards
        return null;
    }

    @Override
    public int compareTo(Card o) {
        return 0;
    }
}


public class Person implements Comparable<Person> {
    private String firstName, lastName;
    private int id;
   // private double age; // stale if we store into database, file
    private Date birthday;
    private Gender gender;
    public Person(){
    }

    public Person(String firstName, String lastName, int id, Date birthday, Gender g) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.birthday = birthday;
        this.gender = g;
    }

    // methods you should consider always implementing (Effective Java)
    // toString is important for debugging / log the state (field values) of the object
    // equals ... assertion library assumes it is there, list's contains methods it...as does remove, and many bulk methods
    // hashcode - may use classes HashSet, HashMap
    //          --- objects unique fingerprint (int value) that is generated based on the object's fields
    //          ---    firstName, lastName, etc all contribute to the hashcode int value
    // compareTo, Comparable interface -- allows you to sort elements, or find the highest / lowest elt
    // Comparator interface


//    @Override
//    public boolean equals(Object o)
//    {
//        if ( this == o)
//            return true;
//        if (! (o instanceof Person))
//        {
//            return false;
//        }
//
//        Person p = (Person) o;
//        if (firstName == null && p.firstName != null)
//            return false;
//        if (firstName != null && ! firstName.equals(p.firstName))
//            return false;
//        if (lastName == null && p.lastName != null)
//            return false;
//        if (lastName != null && ! lastName.equals(p.lastName))
//            return false;
//        if (id != p.id)
//            return false;
//        if (birthday == null && p.birthday != null)
//            return false;
//        if (birthday != null && ! birthday.equals(p.birthday))
//            return false;
//        return true;
//    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(birthday, person.birthday);
    }

    /// length
    /// ip = ip = length - 1 ? ip = 0 : ip + 1;

    /// ip = (ip + 1) % length
    @Override
    public int hashCode() {
        int hash = 23;
        hash = hash * 11 + id;
        hash = hash * 11 + firstName.hashCode();
        hash = hash * 11 + lastName.hashCode();
        hash = hash * 11 + birthday.hashCode();

        return hash;

        //return Objects.hash(firstName, lastName, id, birthday);
    }

    // returns 0 if same
    // returns > 0 if this > that ("Z" > "A")
    // return < 0  if this < that
    // returns this - that
    // NATURAL ORDERING
    @Override
    public int compareTo(Person that) {
        int diff = this.lastName.compareTo(that.lastName);
        if (diff != 0)
            return diff;
        diff = this.firstName.compareTo(that.firstName);
        if (diff != 0)
            return diff;
        diff = this.id - that.id;
        if (diff != 0)
            return diff;
        diff = this.birthday.compareTo(that.birthday);
        return diff;// TODO?? Gender also
    }

    public int getId() {return id;
    }

    public static class ReverseComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            return -p1.compareTo(p2);
        }
    }
}

