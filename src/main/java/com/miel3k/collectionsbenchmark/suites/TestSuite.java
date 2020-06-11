package com.miel3k.collectionsbenchmark.suites;

import com.miel3k.collectionsbenchmark.model.BenchmarkResult;

import java.util.List;

public interface TestSuite {

    List<BenchmarkResult> executeAddingCase();

    List<BenchmarkResult> executeRemovingCase();

    List<BenchmarkResult> executeBrowsingCase();

    List<BenchmarkResult> executeContainingCase();
}
