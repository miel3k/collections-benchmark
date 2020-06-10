package com.miel3k.collectionsbenchmark.models;

public interface Testable<T> extends Comparable<T> {
    T copy();
}
