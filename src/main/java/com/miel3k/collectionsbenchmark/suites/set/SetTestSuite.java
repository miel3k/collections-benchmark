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
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(executeHashSetAddingCase());
        resultList.add(executeLinkedHashSetAddingCase());
        resultList.add(executeTreeSetAddingCase());
        return resultList;
    }

    private BenchmarkResult executeHashSetAddingCase() {
        Set<T> hashSet = TestSuiteSupplier.getHashSet(testObject, collectionSize);
        return executeSetCase(
                "Adding",
                hashSet,
                collection -> collection.add(testObject.copy())
        );
    }

    private BenchmarkResult executeLinkedHashSetAddingCase() {
        Set<T> linkedHashSet = TestSuiteSupplier.getLinkedHashSet(testObject, collectionSize);
        return executeSetCase(
                "Adding",
                linkedHashSet,
                collection -> collection.add(testObject.copy())
        );
    }

    private BenchmarkResult executeTreeSetAddingCase() {
        Set<T> treeSet = TestSuiteSupplier.getTreeSet(testObject, collectionSize);
        return executeSetCase(
                "Adding",
                treeSet,
                collection -> collection.add(testObject.copy())
        );
    }

    @Override
    public List<BenchmarkResult> executeRemovingCase() {
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(executeHashSetRemovingCase());
        resultList.add(executeLinkedHashSetRemovingCase());
        resultList.add(executeTreeSetRemovingCase());
        return resultList;
    }

    private BenchmarkResult executeHashSetRemovingCase() {
        Set<T> hashSet = TestSuiteSupplier.getHashSet(testObject, collectionSize);
        return executeSetCase(
                "Removing",
                hashSet,
                collection -> collection.remove(testObject)
        );
    }

    private BenchmarkResult executeLinkedHashSetRemovingCase() {
        Set<T> linkedHashSet = TestSuiteSupplier.getLinkedHashSet(testObject, collectionSize);
        return executeSetCase(
                "Removing",
                linkedHashSet,
                collection -> collection.remove(testObject)
        );
    }

    private BenchmarkResult executeTreeSetRemovingCase() {
        Set<T> treeSet = TestSuiteSupplier.getTreeSet(testObject, collectionSize);
        return executeSetCase(
                "Removing",
                treeSet,
                collection -> collection.remove(testObject)
        );
    }

    @Override
    public List<BenchmarkResult> executeBrowsingCase() {
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(executeHashSetBrowsingCase());
        resultList.add(executeLinkedHashSetBrowsingCase());
        resultList.add(executeTreeSetBrowsingCase());
        return resultList;
    }

    private BenchmarkResult executeHashSetBrowsingCase() {
        Set<T> hashSet = TestSuiteSupplier.getHashSet(testObject, collectionSize);
        return executeSetCase(
                "Browsing",
                hashSet,
                collection -> collection.iterator().next()
        );
    }

    private BenchmarkResult executeLinkedHashSetBrowsingCase() {
        Set<T> linkedHashSet = TestSuiteSupplier.getLinkedHashSet(testObject, collectionSize);
        return executeSetCase(
                "Browsing",
                linkedHashSet,
                collection -> collection.iterator().next()
        );
    }

    private BenchmarkResult executeTreeSetBrowsingCase() {
        Set<T> treeSet = TestSuiteSupplier.getTreeSet(testObject, collectionSize);
        return executeSetCase(
                "Browsing",
                treeSet,
                collection -> collection.iterator().next()
        );
    }

    @Override
    public List<BenchmarkResult> executeContainingCase() {
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(executeHashSetContainingCase());
        resultList.add(executeLinkedHashSetContainingCase());
        resultList.add(executeTreeSetContainingCase());
        return resultList;
    }

    private BenchmarkResult executeHashSetContainingCase() {
        Set<T> hashSet = TestSuiteSupplier.getHashSet(testObject, collectionSize);
        return executeSetCase(
                "Containing",
                hashSet,
                collection -> collection.contains(testObject)
        );
    }

    private BenchmarkResult executeLinkedHashSetContainingCase() {
        Set<T> linkedHashSet = TestSuiteSupplier.getLinkedHashSet(testObject, collectionSize);
        return executeSetCase(
                "Containing",
                linkedHashSet,
                collection -> collection.contains(testObject)
        );
    }

    private BenchmarkResult executeTreeSetContainingCase() {
        Set<T> treeSet = TestSuiteSupplier.getTreeSet(testObject, collectionSize);
        return executeSetCase(
                "Containing",
                treeSet,
                collection -> collection.contains(testObject)
        );
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
