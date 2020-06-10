package com.miel3k.collectionsbenchmark.benchmark.suites.set;

import com.miel3k.collectionsbenchmark.benchmark.BenchmarkSupplier;
import com.miel3k.collectionsbenchmark.benchmark.suites.TestSuite;
import com.miel3k.collectionsbenchmark.models.BenchmarkResult;
import com.miel3k.collectionsbenchmark.models.Testable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SetTestSuite<T extends Testable<T>> implements TestSuite {

    private final T testObject;
    private final int collectionSize;
    private final int iterationsCount;

    public SetTestSuite(T testObject, int collectionSize, int numberOfIterations) {
        this.testObject = testObject;
        this.collectionSize = collectionSize;
        this.iterationsCount = numberOfIterations;
    }

    @Override
    public List<BenchmarkResult> executeAddingCase() {
        String caseType = "Adding";
        Set<T> hashSet = BenchmarkSupplier.getHashSet(testObject, collectionSize);
        BenchmarkResult hashSetResult = executeSetCase(
                caseType,
                hashSet,
                collection -> collection.add(testObject.copy())
        );
        Set<T> linkedHashSet = BenchmarkSupplier.getLinkedHashSet(testObject, collectionSize);
        BenchmarkResult linkedHashSetResult = executeSetCase(
                caseType,
                linkedHashSet,
                collection -> collection.add(testObject.copy())
        );
        Set<T> treeSet = BenchmarkSupplier.getTreeSet(testObject, collectionSize);
        BenchmarkResult treeSetResult = executeSetCase(
                caseType,
                treeSet,
                collection -> collection.add(testObject.copy())
        );
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(hashSetResult);
        resultList.add(linkedHashSetResult);
        resultList.add(treeSetResult);
        return resultList;
    }

    @Override
    public List<BenchmarkResult> executeRemovingCase() {
        return new ArrayList<>();
    }

    @Override
    public List<BenchmarkResult> executeBrowsingCase() {
        return new ArrayList<>();
    }

    @Override
    public List<BenchmarkResult> executeContainingCase() {
        return new ArrayList<>();
    }

    private BenchmarkResult executeSetCase(String caseType, Set<T> set, Setable<T> setable) {
        long startTime = System.nanoTime();
        for (int i = 0; i < iterationsCount; i++) {
            setable.execute(set);
        }
        long endTime = System.nanoTime();
        return new BenchmarkResult(
                testObject.getClass().getSimpleName(),
                caseType,
                set.getClass().getSimpleName(),
                collectionSize,
                iterationsCount,
                (endTime - startTime) / iterationsCount
        );
    }
}
