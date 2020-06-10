package com.miel3k.collectionsbenchmark.benchmark.suites.list;

import java.util.List;

public interface Listable<T> {
    void execute(List<T> list);
}
