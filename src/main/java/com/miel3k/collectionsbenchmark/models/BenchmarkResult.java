package com.miel3k.collectionsbenchmark.models;

public class BenchmarkResult {

    private final String model;
    private final String caseType;
    private final String collection;
    private final int collectionSize;
    private final int iterations;
    private long time;

    public BenchmarkResult(String model, String caseType, String collection, int collectionSize, int iterations, long time) {
        this.model = model;
        this.caseType = caseType;
        this.collection = collection;
        this.collectionSize = collectionSize;
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

    public int getIterations() {
        return iterations;
    }

    public long getTime() {
        return time;
    }
}
