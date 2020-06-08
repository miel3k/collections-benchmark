package com.miel3k.collectionsbenchmark.benchmark.suites;

import com.miel3k.collectionsbenchmark.models.BenchmarkResult;

import java.util.List;

public interface TestSuite {

    void startAddingCase();

    void startRemovingCase();

    void startBrowsingCase();

    void startContainingCase();

    List<BenchmarkResult> getResults();
}
