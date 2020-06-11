package com.miel3k.collectionsbenchmark.view;

import com.miel3k.collectionsbenchmark.model.BenchmarkResult;

import java.util.List;

public class ConsoleView implements BenchmarkView {

    public ConsoleView() {
    }

    @Override
    public void displayResults(List<BenchmarkResult> results) {
        System.out.println(BenchmarkResult.HEADER);
        for (BenchmarkResult result : results) {
            System.out.println(result.toString());
        }
    }
}
