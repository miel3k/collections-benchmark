package com.miel3k.collectionsbenchmark.suites.supplier;

import com.miel3k.collectionsbenchmark.model.Testable;

import java.util.*;
import java.util.concurrent.*;

public class TestSuiteSupplier {

    public static <T extends Testable<T>> List<T> getArrayList(T testObject, int n) {
        List<T> list = new ArrayList<>();
        list.add(testObject);
        for (int i = 0; i < n - 1; i++) {
            list.add(testObject.copy());
        }
        return list;
    }

    public static <T extends Testable<T>> List<T> getLinkedList(T testObject, int n) {
        List<T> list = new LinkedList<>();
        list.add(testObject);
        for (int i = 0; i < n - 1; i++) {
            list.add(testObject.copy());
        }
        return list;
    }

    public static <T extends Testable<T>> Set<T> getHashSet(T testObject, int n) {
        Set<T> set = new HashSet<>();
        set.add(testObject);
        for (int i = 0; i < n - 1; i++) {
            set.add(testObject.copy());
        }
        return set;
    }

    public static <T extends Testable<T>> Set<T> getLinkedHashSet(T testObject, int n) {
        Set<T> set = new LinkedHashSet<>();
        set.add(testObject);
        for (int i = 0; i < n - 1; i++) {
            set.add(testObject.copy());
        }
        return set;
    }

    public static <T extends Testable<T>> Set<T> getTreeSet(T testObject, int n) {
        Set<T> set = new TreeSet<>();
        set.add(testObject);
        for (int i = 0; i < n - 1; i++) {
            set.add(testObject.copy());
        }
        return set;
    }

    public static <T extends Testable<T>> Queue<T> getPriorityQueue(T testObject, int n) {
        Queue<T> queue = new PriorityQueue<>();
        queue.add(testObject);
        for (int i = 0; i < n - 1; i++) {
            queue.add(testObject.copy());
        }
        return queue;
    }

    public static <T extends Testable<T>> Queue<T> getPriorityBlockingQueue(T testObject, int n) {
        Queue<T> queue = new PriorityBlockingQueue<>();
        queue.add(testObject);
        for (int i = 0; i < n - 1; i++) {
            queue.add(testObject.copy());
        }
        return queue;
    }

    public static <T extends Testable<T>> Queue<T> getArrayBlockingQueue(T testObject, int n) {
        Queue<T> queue = new ArrayBlockingQueue<>(2 * n);
        queue.add(testObject);
        for (int i = 0; i < n - 1; i++) {
            queue.add(testObject.copy());
        }
        return queue;
    }

    public static <T extends Testable<T>> Queue<T> getLinkedBlockingQueue(T testObject, int n) {
        Queue<T> queue = new LinkedBlockingQueue<>();
        queue.add(testObject);
        for (int i = 0; i < n - 1; i++) {
            queue.add(testObject.copy());
        }
        return queue;
    }

    public static <T extends Testable<T>> Queue<T> getLinkedTransferQueue(T testObject, int n) {
        Queue<T> queue = new LinkedTransferQueue<>();
        queue.add(testObject);
        for (int i = 0; i < n - 1; i++) {
            queue.add(testObject.copy());
        }
        return queue;
    }

    public static <T extends Testable<T>> Queue<T> getConcurrentLinkedQueue(T testObject, int n) {
        Queue<T> queue = new ConcurrentLinkedQueue<>();
        queue.add(testObject);
        for (int i = 0; i < n - 1; i++) {
            queue.add(testObject.copy());
        }
        return queue;
    }
}
