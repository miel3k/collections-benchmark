package com.miel3k.collectionsbenchmark.view;

import com.miel3k.collectionsbenchmark.model.BenchmarkResult;

import java.util.List;

public interface BenchmarkView {
    void displayResults(List<BenchmarkResult> results);
}
