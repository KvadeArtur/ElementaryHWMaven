package com.kvart;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String name;
    private List<Person> persons = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    @javax.xml.bind.annotation.XmlAttribute
    public String getName() {
        return name;
    }

    @javax.xml.bind.annotation.XmlAttribute
    public List<Person> getPersons() {
        return persons;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", persons=" + persons +
                '}';
    }
}