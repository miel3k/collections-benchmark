package com.miel3k.collectionsbenchmark.model;

public interface Testable<T> extends Comparable<T> {
    T copy();
}
