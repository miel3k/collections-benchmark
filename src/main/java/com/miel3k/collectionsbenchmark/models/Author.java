package com.miel3k.collectionsbenchmark.models;

public class Author implements Testable<Author> {

    final private String id;
    final private String name;
    final private int age;

    public Author(String id, String name, int age) {
        this.id = id;
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
        return new Author(this.id, this.name, this.age);
    }
}

