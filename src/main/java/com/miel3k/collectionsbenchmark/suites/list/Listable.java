package com.miel3k.collectionsbenchmark.suites.list;

import java.util.List;

public interface Listable<T> {
    void execute(List<T> list);
}
