package com.miel3k.collectionsbenchmark.models;

import java.util.Objects;
import java.util.UUID;

public class Book implements Testable<Book> {

    final private String id;
    final private String title;
    final private Author author;

    public Book(String title, Author author) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
    }

    public String getId() {
        return id;
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

    @Override
    public int compareTo(Book o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}
