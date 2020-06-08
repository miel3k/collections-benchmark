package com.miel3k.collectionsbenchmark.models;

public class User {

    final private String id;
    final private String name;
    final private int age;

    public User(String id, String name, int age) {
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
}

