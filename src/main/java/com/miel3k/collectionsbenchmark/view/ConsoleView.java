package com.miel3k.collectionsbenchmark.view;

import com.miel3k.collectionsbenchmark.models.BenchmarkResult;

import java.util.List;

public class ConsoleView implements BenchmarkView {

    public ConsoleView() {
    }

    @Override
    public void displayResults(List<BenchmarkResult> results) {
        System.out.format("%16s%16s%16s%16s%16s%n", "Model", "Case", "Collection", "Iterations", "Time (ns)");
        for (BenchmarkResult result : results) {
            System.out.format(
                    "%16s%16s%16s%16d%16d%n",
                    result.getModel(),
                    result.getCaseType(),
                    result.getCollection(),
                    result.getIterations(),
                    result.getTime()
            );
        }
    }
}
