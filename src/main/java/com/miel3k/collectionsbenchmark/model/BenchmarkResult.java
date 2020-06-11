package com.miel3k.collectionsbenchmark.model;

public class BenchmarkResult {

    public static String HEADER = String.format(
            "%16s%16s%16s%16s%16s%16s%40s",
            "Model",
            "Case",
            "Collection",
            "Size",
            "Current Size",
            "Iterations",
            "Single operation (avg) time (ns)"
    );

    private final String model;
    private final String caseType;
    private final String collection;
    private final int collectionSize;
    private final int currentSize;
    private final int iterations;
    private long time;

    public BenchmarkResult(
            String model,
            String caseType,
            String collection,
            int collectionSize,
            int currentSize,
            int iterations,
            long time
    ) {
        this.model = model;
        this.caseType = caseType;
        this.collection = collection;
        this.collectionSize = collectionSize;
        this.currentSize = currentSize;
        this.iterations = iterations;
        this.time = time;
    }

    public String getModel() {
        return model;
    }

    public String getCaseType() {
        return caseType;
    }

    public String getCollection() {
        return collection;
    }

    public int getCollectionSize() {
        return collectionSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public int getIterations() {
        return iterations;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return String.format(
                "%16s%16s%16s%16d%16d%16d%40d",
                model,
                caseType,
                collection,
                collectionSize,
                currentSize,
                iterations,
                time
        );
    }
}
