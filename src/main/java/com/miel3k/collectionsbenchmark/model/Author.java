package com.miel3k.collectionsbenchmark.model;

import java.util.Objects;
import java.util.UUID;

public class Author implements Testable<Author> {

    final private String id;
    final private String name;
    final private int age;

    public Author(String name, int age) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public Author copy() {
        return new Author(this.name, this.age);
    }

    @Override
    public int compareTo(Author o) {
        return id.compareTo(o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return age == author.age &&
                Objects.equals(id, author.id) &&
                Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}

