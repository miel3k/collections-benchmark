package com.miel3k.collectionsbenchmark.suites.set;

import com.miel3k.collectionsbenchmark.model.BenchmarkResult;
import com.miel3k.collectionsbenchmark.model.Testable;
import com.miel3k.collectionsbenchmark.suites.TestSuite;
import com.miel3k.collectionsbenchmark.suites.supplier.TestSuiteSupplier;

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
        Set<T> hashSet = TestSuiteSupplier.getHashSet(testObject, collectionSize);
        BenchmarkResult hashSetResult = executeSetCase(
                caseType,
                hashSet,
                collection -> collection.add(testObject.copy())
        );
        Set<T> linkedHashSet = TestSuiteSupplier.getLinkedHashSet(testObject, collectionSize);
        BenchmarkResult linkedHashSetResult = executeSetCase(
                caseType,
                linkedHashSet,
                collection -> collection.add(testObject.copy())
        );
        Set<T> treeSet = TestSuiteSupplier.getTreeSet(testObject, collectionSize);
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
        String caseType = "Removing";
        Set<T> hashSet = TestSuiteSupplier.getHashSet(testObject, collectionSize);
        BenchmarkResult hashSetResult = executeSetCase(
                caseType,
                hashSet,
                collection -> collection.remove(testObject)
        );
        Set<T> linkedHashSet = TestSuiteSupplier.getLinkedHashSet(testObject, collectionSize);
        BenchmarkResult linkedHashSetResult = executeSetCase(
                caseType,
                linkedHashSet,
                collection -> collection.remove(testObject)
        );
        Set<T> treeSet = TestSuiteSupplier.getTreeSet(testObject, collectionSize);
        BenchmarkResult treeSetResult = executeSetCase(
                caseType,
                treeSet,
                collection -> collection.remove(testObject)
        );
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(hashSetResult);
        resultList.add(linkedHashSetResult);
        resultList.add(treeSetResult);
        return resultList;
    }

    @Override
    public List<BenchmarkResult> executeBrowsingCase() {
        return new ArrayList<>();
    }

    @Override
    public List<BenchmarkResult> executeContainingCase() {
        String caseType = "Containing";
        Set<T> hashSet = TestSuiteSupplier.getHashSet(testObject, collectionSize);
        BenchmarkResult hashSetResult = executeSetCase(
                caseType,
                hashSet,
                collection -> collection.contains(testObject)
        );
        Set<T> linkedHashSet = TestSuiteSupplier.getLinkedHashSet(testObject, collectionSize);
        BenchmarkResult linkedHashSetResult = executeSetCase(
                caseType,
                linkedHashSet,
                collection -> collection.contains(testObject)
        );
        Set<T> treeSet = TestSuiteSupplier.getTreeSet(testObject, collectionSize);
        BenchmarkResult treeSetResult = executeSetCase(
                caseType,
                treeSet,
                collection -> collection.contains(testObject)
        );
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(hashSetResult);
        resultList.add(linkedHashSetResult);
        resultList.add(treeSetResult);
        return resultList;
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
                set.size(),
                iterationsCount,
                (endTime - startTime) / iterationsCount
        );
    }
}
