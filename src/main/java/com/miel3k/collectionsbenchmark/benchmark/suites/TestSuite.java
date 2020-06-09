package com.miel3k.collectionsbenchmark.benchmark.suites;

import com.miel3k.collectionsbenchmark.models.BenchmarkResult;

import java.util.List;

public interface TestSuite {

    List<BenchmarkResult> executeAddingCase();

    List<BenchmarkResult> executeRemovingCase();

    List<BenchmarkResult> executeBrowsingCase();

    List<BenchmarkResult> executeContainingCase();
}
