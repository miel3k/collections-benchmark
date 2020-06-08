package com.miel3k.collectionsbenchmark.models;

public class BenchmarkResult {

    private final String caseType;
    private final String collection;
    private final int iterations;
    private long time;

    public BenchmarkResult(String caseType, String collection, int iterations, long time) {
        this.caseType = caseType;
        this.collection = collection;
        this.iterations = iterations;
        this.time = time;
    }

    public String getCaseType() {
        return caseType;
    }

    public String getCollection() {
        return collection;
    }

    public int getIterations() {
        return iterations;
    }

    public long getTime() {
        return time;
    }
}
