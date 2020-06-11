package com.miel3k.collectionsbenchmark.model;

import com.miel3k.collectionsbenchmark.enums.TestCaseType;
import com.miel3k.collectionsbenchmark.enums.BenchmarkEntity;
import com.miel3k.collectionsbenchmark.enums.TestSuiteType;

import java.util.List;

public class BenchmarkConfiguration {

    private final BenchmarkEntity benchmarkEntity;
    private final List<TestSuiteType> testSuiteTypes;
    private final List<TestCaseType> caseTypes;
    private final int collectionSize;
    private final int iterationsCount;

    public BenchmarkConfiguration(BenchmarkEntity benchmarkEntity, List<TestSuiteType> testSuiteTypeList, List<TestCaseType> caseTypeList, int collectionSize, int iterationsCount) {
        this.benchmarkEntity = benchmarkEntity;
        this.testSuiteTypes = testSuiteTypeList;
        this.caseTypes = caseTypeList;
        this.collectionSize = collectionSize;
        this.iterationsCount = iterationsCount;
    }

    public BenchmarkEntity getBenchmarkEntity() {
        return benchmarkEntity;
    }

    public List<TestSuiteType> getTestSuiteTypes() {
        return testSuiteTypes;
    }

    public List<TestCaseType> getCaseTypes() {
        return caseTypes;
    }

    public int getCollectionSize() {
        return collectionSize;
    }

    public int getIterationsCount() {
        return iterationsCount;
    }
}
