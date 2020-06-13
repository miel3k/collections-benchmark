package com.miel3k.collectionsbenchmark.model;

import com.miel3k.collectionsbenchmark.enums.BenchmarkEntity;
import com.miel3k.collectionsbenchmark.enums.TestCaseType;
import com.miel3k.collectionsbenchmark.enums.TestSuiteType;

import java.util.List;

public class BenchmarkConfiguration {

    private final BenchmarkEntity benchmarkEntity;
    private final List<TestSuiteType> testSuiteTypes;
    private final List<TestCaseType> caseTypes;
    private final int collectionSize;
    private final int iterationsCount;
    private final boolean isWriteEnabled;
    private final boolean isWarmUpEnabled;

    public BenchmarkConfiguration(
            BenchmarkEntity benchmarkEntity,
            List<TestSuiteType> testSuiteTypeList,
            List<TestCaseType> caseTypeList,
            int collectionSize,
            int iterationsCount,
            boolean isWriteEnabled,
            boolean isWarmUpEnabled
    ) {
        this.benchmarkEntity = benchmarkEntity;
        this.testSuiteTypes = testSuiteTypeList;
        this.caseTypes = caseTypeList;
        this.collectionSize = collectionSize;
        this.iterationsCount = iterationsCount;
        this.isWriteEnabled = isWriteEnabled;
        this.isWarmUpEnabled = isWarmUpEnabled;
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

    public boolean isWriteEnabled() {
        return isWriteEnabled;
    }

    public boolean isWarmUpEnabled() {
        return isWarmUpEnabled;
    }
}
