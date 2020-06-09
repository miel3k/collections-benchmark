package com.miel3k.collectionsbenchmark.models;

public class Book implements Testable<Book> {

    final private String title;
    final private Author author;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public Book copy() {
        return new Book(this.title, this.author);
    }
}
