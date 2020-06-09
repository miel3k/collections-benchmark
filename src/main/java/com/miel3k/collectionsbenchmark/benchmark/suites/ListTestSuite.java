package com.miel3k.collectionsbenchmark.benchmark.suites;

import com.miel3k.collectionsbenchmark.benchmark.BenchmarkSupplier;
import com.miel3k.collectionsbenchmark.models.BenchmarkResult;
import com.miel3k.collectionsbenchmark.models.Testable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTestSuite<T extends Testable<T>> implements TestSuite {

    private final T testObject;
    private final int iterationsCount;

    public ListTestSuite(T testObject, int numberOfIterations) {
        this.testObject = testObject;
        this.iterationsCount = numberOfIterations;
    }

    @Override
    public List<BenchmarkResult> executeAddingCase() {
        List<T> arrayList = new ArrayList<>();
        BenchmarkResult arrayListResult = executeListCase(
                "Adding",
                iterationsCount,
                arrayList,
                collection -> collection.add(0, testObject)
        );
        List<T> linkedList = new LinkedList<>();
        BenchmarkResult linkedListResult = executeListCase(
                "Adding",
                iterationsCount,
                linkedList,
                collection -> collection.add(0, testObject)
        );
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(arrayListResult);
        resultList.add(linkedListResult);
        return resultList;
    }

    @Override
    public List<BenchmarkResult> executeRemovingCase() {
        List<T> arrayList = BenchmarkSupplier.getArrayList(testObject, 500);
        BenchmarkResult arrayListResult = executeListCase(
                "Removing",
                iterationsCount,
                arrayList,
                collection -> collection.remove(0)
        );
        List<T> linkedList = BenchmarkSupplier.getLinkedList(testObject, 500);
        BenchmarkResult linkedListResult = executeListCase(
                "Removing",
                iterationsCount,
                linkedList,
                collection -> collection.remove(0)
        );
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(arrayListResult);
        resultList.add(linkedListResult);
        return resultList;
    }

    @Override
    public List<BenchmarkResult> executeBrowsingCase() {
        List<T> arrayList = BenchmarkSupplier.getArrayList(testObject, 500);
        BenchmarkResult arrayListResult = executeListCase(
                "Browsing",
                iterationsCount,
                arrayList,
                collection -> collection.get(0)
        );
        List<T> linkedList = BenchmarkSupplier.getLinkedList(testObject, 500);
        BenchmarkResult linkedListResult = executeListCase(
                "Browsing",
                iterationsCount,
                linkedList,
                collection -> collection.get(0)
        );
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(arrayListResult);
        resultList.add(linkedListResult);
        return resultList;
    }

    @Override
    public List<BenchmarkResult> executeContainingCase() {
        List<T> arrayList = BenchmarkSupplier.getArrayList(testObject, 500);
        BenchmarkResult arrayListResult = executeListCase(
                "Containing",
                iterationsCount,
                arrayList,
                collection -> collection.contains(testObject)
        );
        List<T> linkedList = BenchmarkSupplier.getLinkedList(testObject, 500);
        BenchmarkResult linkedListResult = executeListCase(
                "Containing",
                iterationsCount,
                linkedList,
                collection -> collection.contains(testObject)
        );
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(arrayListResult);
        resultList.add(linkedListResult);
        return resultList;
    }

    private BenchmarkResult executeListCase(String caseType, int iterationsCount, List<T> list, Listable<T> listable) {
        long startTime = System.nanoTime();
        for (int i = 0; i < iterationsCount; i++) {
            listable.execute(list);
        }
        long endTime = System.nanoTime();
        return new BenchmarkResult(
                testObject.getClass().getSimpleName(),
                caseType,
                list.getClass().getSimpleName(),
                iterationsCount,
                endTime - startTime
        );
    }
}
