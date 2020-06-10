package com.miel3k.collectionsbenchmark.benchmark.suites.queue;

import java.util.Queue;

public interface Queueable<T> {
    void execute(Queue<T> queue);
}
