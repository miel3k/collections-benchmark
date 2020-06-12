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
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(executeArrayListAddingAtTheBeginningCase());
        resultList.add(executeLinkedListAddingAtTheBeginningCase());
        resultList.add(executeArrayListAddingInTheMiddleCase());
        resultList.add(executeLinkedListAddingInTheMiddleCase());
        resultList.add(executeArrayListAddingAtTheEndCase());
        resultList.add(executeLinkedListAddingAtTheEndCase());
        return resultList;
    }

    private BenchmarkResult executeArrayListAddingAtTheBeginningCase() {
        List<T> arrayList = TestSuiteSupplier.getArrayList(testObject, collectionSize);
        return executeListCase(
                "Adding(begin)",
                arrayList,
                collection -> collection.add(0, testObject)
        );
    }

    private BenchmarkResult executeLinkedListAddingAtTheBeginningCase() {
        List<T> linkedList = TestSuiteSupplier.getLinkedList(testObject, collectionSize);
        return executeListCase(
                "Adding(begin)",
                linkedList,
                collection -> collection.add(0, testObject)
        );
    }

    private BenchmarkResult executeArrayListAddingInTheMiddleCase() {
        List<T> arrayList = TestSuiteSupplier.getArrayList(testObject, collectionSize);
        return executeListCase(
                "Adding(middle)",
                arrayList,
                collection -> collection.add(collection.size() / 2, testObject)
        );
    }

    private BenchmarkResult executeLinkedListAddingInTheMiddleCase() {
        List<T> linkedList = TestSuiteSupplier.getLinkedList(testObject, collectionSize);
        return executeListCase(
                "Adding(middle)",
                linkedList,
                collection -> collection.add(collection.size() / 2, testObject)
        );
    }

    private BenchmarkResult executeArrayListAddingAtTheEndCase() {
        List<T> arrayList = TestSuiteSupplier.getArrayList(testObject, collectionSize);
        return executeListCase(
                "Adding(end)",
                arrayList,
                collection -> collection.add(testObject)
        );
    }

    private BenchmarkResult executeLinkedListAddingAtTheEndCase() {
        List<T> linkedList = TestSuiteSupplier.getLinkedList(testObject, collectionSize);
        return executeListCase(
                "Adding(end)",
                linkedList,
                collection -> collection.add(testObject)
        );
    }

    @Override
    public List<BenchmarkResult> executeRemovingCase() {
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(executeArrayListRemovingAtTheBeginningCase());
        resultList.add(executeLinkedListRemovingAtTheBeginningCase());
        resultList.add(executeArrayListRemovingInTheMiddleCase());
        resultList.add(executeLinkedListRemovingInTheMiddleCase());
        resultList.add(executeArrayListRemovingAtTheEndCase());
        resultList.add(executeLinkedListRemovingAtTheEndCase());
        return resultList;
    }

    private BenchmarkResult executeArrayListRemovingAtTheBeginningCase() {
        List<T> arrayList = TestSuiteSupplier.getArrayList(testObject, collectionSize);
        return executeListCase(
                "Removing(begin)",
                arrayList,
                collection -> collection.remove(0)
        );
    }

    private BenchmarkResult executeLinkedListRemovingAtTheBeginningCase() {
        List<T> linkedList = TestSuiteSupplier.getLinkedList(testObject, collectionSize);
        return executeListCase(
                "Removing(begin)",
                linkedList,
                collection -> collection.remove(0)
        );
    }

    private BenchmarkResult executeArrayListRemovingInTheMiddleCase() {
        List<T> arrayList = TestSuiteSupplier.getArrayList(testObject, collectionSize);
        return executeListCase(
                "Removing(middle)",
                arrayList,
                collection -> collection.remove(collection.size() / 2)
        );
    }

    private BenchmarkResult executeLinkedListRemovingInTheMiddleCase() {
        List<T> linkedList = TestSuiteSupplier.getLinkedList(testObject, collectionSize);
        return executeListCase(
                "Removing(middle)",
                linkedList,
                collection -> collection.remove(collection.size() / 2)
        );
    }

    private BenchmarkResult executeArrayListRemovingAtTheEndCase() {
        List<T> arrayList = TestSuiteSupplier.getArrayList(testObject, collectionSize);
        return executeListCase(
                "Removing(end)",
                arrayList,
                collection -> collection.remove(collection.size() - 1)
        );
    }

    private BenchmarkResult executeLinkedListRemovingAtTheEndCase() {
        List<T> linkedList = TestSuiteSupplier.getLinkedList(testObject, collectionSize);
        return executeListCase(
                "Removing(end)",
                linkedList,
                collection -> collection.remove(collection.size() - 1)
        );
    }

    @Override
    public List<BenchmarkResult> executeBrowsingCase() {
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(executeArrayListBrowsingIndexCase());
        resultList.add(executeLinkedListBrowsingIndexCase());
        resultList.add(executeArrayListBrowsingIteratorCase());
        resultList.add(executeLinkedListBrowsingIteratorCase());
        return resultList;
    }

    private BenchmarkResult executeArrayListBrowsingIndexCase() {
        List<T> arrayList = TestSuiteSupplier.getArrayList(testObject, collectionSize);
        return executeListCase(
                "Browsing(index)",
                arrayList,
                collection -> collection.get(collection.size() / 2)
        );
    }

    private BenchmarkResult executeLinkedListBrowsingIndexCase() {
        List<T> linkedList = TestSuiteSupplier.getLinkedList(testObject, collectionSize);
        return executeListCase(
                "Browsing(index)",
                linkedList,
                collection -> collection.get(collection.size() / 2)
        );
    }

    private BenchmarkResult executeArrayListBrowsingIteratorCase() {
        List<T> arrayList = TestSuiteSupplier.getArrayList(testObject, collectionSize);
        return executeListCase(
                "Browsing(iterator)",
                arrayList,
                collection -> collection.iterator().next()
        );
    }

    private BenchmarkResult executeLinkedListBrowsingIteratorCase() {
        List<T> linkedList = TestSuiteSupplier.getLinkedList(testObject, collectionSize);
        return executeListCase(
                "Browsing(iterator)",
                linkedList,
                collection -> collection.iterator().next()
        );
    }

    @Override
    public List<BenchmarkResult> executeContainingCase() {
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(executeArrayListContainingCase());
        resultList.add(executeLinkedListContainingCase());
        return resultList;
    }

    private BenchmarkResult executeArrayListContainingCase() {
        List<T> arrayList = TestSuiteSupplier.getArrayList(testObject, collectionSize);
        return executeListCase(
                "Containing",
                arrayList,
                collection -> collection.contains(testObject)
        );
    }

    private BenchmarkResult executeLinkedListContainingCase() {
        List<T> linkedList = TestSuiteSupplier.getLinkedList(testObject, collectionSize);
        return executeListCase(
                "Containing",
                linkedList,
                collection -> collection.contains(testObject)
        );
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
