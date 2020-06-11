package com.miel3k.collectionsbenchmark.suites.list;

import com.miel3k.collectionsbenchmark.model.BenchmarkResult;
import com.miel3k.collectionsbenchmark.model.Testable;
import com.miel3k.collectionsbenchmark.suites.TestSuite;
import com.miel3k.collectionsbenchmark.suites.supplier.TestSuiteSupplier;

import java.util.ArrayList;
import java.util.List;

public class ListTestSuite<T extends Testable<T>> implements TestSuite {

    private final T testObject;
    private final int collectionSize;
    private final int iterationsCount;

    public ListTestSuite(T testObject, int collectionSize, int numberOfIterations) {
        this.testObject = testObject;
        this.collectionSize = collectionSize;
        this.iterationsCount = numberOfIterations;
    }

    @Override
    public List<BenchmarkResult> executeAddingCase() {
        String caseType = "Adding";
        List<T> arrayList = TestSuiteSupplier.getArrayList(testObject, collectionSize);
        BenchmarkResult arrayListResult = executeListCase(
                caseType,
                arrayList,
                collection -> collection.add(collection.size() / 2, testObject)
        );
        List<T> linkedList = TestSuiteSupplier.getLinkedList(testObject, collectionSize);
        BenchmarkResult linkedListResult = executeListCase(
                caseType,
                linkedList,
                collection -> collection.add(collection.size() / 2, testObject)
        );
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(arrayListResult);
        resultList.add(linkedListResult);
        return resultList;
    }

    @Override
    public List<BenchmarkResult> executeRemovingCase() {
        String caseType = "Removing";
        List<T> arrayList = TestSuiteSupplier.getArrayList(testObject, collectionSize);
        BenchmarkResult arrayListResult = executeListCase(
                caseType,
                arrayList,
                collection -> collection.remove(collection.size() / 2)
        );
        List<T> linkedList = TestSuiteSupplier.getLinkedList(testObject, collectionSize);
        BenchmarkResult linkedListResult = executeListCase(
                caseType,
                linkedList,
                collection -> collection.remove(collection.size() / 2)
        );
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(arrayListResult);
        resultList.add(linkedListResult);
        return resultList;
    }

    @Override
    public List<BenchmarkResult> executeBrowsingCase() {
        String caseType = "Browsing";
        List<T> arrayList = TestSuiteSupplier.getArrayList(testObject, collectionSize);
        BenchmarkResult arrayListResult = executeListCase(
                caseType,
                arrayList,
                collection -> collection.get(collection.size() / 2)
        );
        List<T> linkedList = TestSuiteSupplier.getLinkedList(testObject, collectionSize);
        BenchmarkResult linkedListResult = executeListCase(
                caseType,
                linkedList,
                collection -> collection.get(collection.size() / 2)
        );
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(arrayListResult);
        resultList.add(linkedListResult);
        return resultList;
    }

    @Override
    public List<BenchmarkResult> executeContainingCase() {
        String caseType = "Containing";
        List<T> arrayList = TestSuiteSupplier.getArrayList(testObject, collectionSize);
        BenchmarkResult arrayListResult = executeListCase(
                caseType,
                arrayList,
                collection -> collection.contains(testObject)
        );
        List<T> linkedList = TestSuiteSupplier.getLinkedList(testObject, collectionSize);
        BenchmarkResult linkedListResult = executeListCase(
                caseType,
                linkedList,
                collection -> collection.contains(testObject)
        );
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(arrayListResult);
        resultList.add(linkedListResult);
        return resultList;
    }

    private BenchmarkResult executeListCase(String caseType, List<T> list, Listable<T> listable) {
        long startTime = System.nanoTime();
        for (int i = 0; i < iterationsCount; i++) {
            listable.execute(list);
        }
        long endTime = System.nanoTime();
        return new BenchmarkResult(
                testObject.getClass().getSimpleName(),
                caseType,
                list.getClass().getSimpleName(),
                collectionSize,
                list.size(),
                iterationsCount,
                (endTime - startTime) / iterationsCount
        );
    }
}