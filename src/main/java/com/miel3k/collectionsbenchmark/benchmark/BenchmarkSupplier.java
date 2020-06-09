package com.miel3k.collectionsbenchmark.benchmark;

import com.miel3k.collectionsbenchmark.models.Testable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
}
