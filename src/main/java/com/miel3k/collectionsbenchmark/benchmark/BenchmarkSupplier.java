package com.miel3k.collectionsbenchmark.benchmark;

import com.miel3k.collectionsbenchmark.models.Testable;

import java.util.*;

public class BenchmarkSupplier {

    public static <T extends Testable<T>> List<T> getArrayList(T testObject, int n) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(testObject.copy());
        }
        return list;
    }

    public static <T extends Testable<T>> List<T> getLinkedList(T testObject, int n) {
        List<T> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(testObject.copy());
        }
        return list;
    }

    public static <T extends Testable<T>> Set<T> getHashSet(T testObject, int n) {
        Set<T> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(testObject.copy());
        }
        return set;
    }

    public static <T extends Testable<T>> Set<T> getLinkedHashSet(T testObject, int n) {
        Set<T> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(testObject.copy());
        }
        return set;
    }

    public static <T extends Testable<T>> Set<T> getTreeSet(T testObject, int n) {
        Set<T> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(testObject.copy());
        }
        return set;
    }
}
