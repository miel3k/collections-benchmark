package com.miel3k.collectionsbenchmark.benchmark.suites;

import com.miel3k.collectionsbenchmark.benchmark.BenchmarkSupplier;
import com.miel3k.collectionsbenchmark.models.BenchmarkResult;
import com.miel3k.collectionsbenchmark.models.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ListTestSuite implements TestSuite {

    private final int iterationsCount;

    public ListTestSuite(int numberOfIterations) {
        this.iterationsCount = numberOfIterations;
    }

    @Override
    public List<BenchmarkResult> executeAddingCase() {
        User user = new User(UUID.randomUUID().toString(), "UserName", 10);
        List<User> arrayList = new ArrayList<>();
        BenchmarkResult arrayListResult = executeListCase(
                "Adding",
                iterationsCount,
                arrayList,
                collection -> collection.add(0, user)
        );
        List<User> linkedList = new LinkedList<>();
        BenchmarkResult linkedListResult = executeListCase(
                "Adding",
                iterationsCount,
                linkedList,
                collection -> collection.add(0, user)
        );
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(arrayListResult);
        resultList.add(linkedListResult);
        return resultList;
    }

    @Override
    public List<BenchmarkResult> executeRemovingCase() {
        List<User> arrayList = BenchmarkSupplier.getArrayList(500);
        BenchmarkResult arrayListResult = executeListCase(
                "Removing",
                iterationsCount,
                arrayList,
                collection -> collection.remove(0)
        );
        List<User> linkedList = BenchmarkSupplier.getLinkedList(500);
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
        List<User> arrayList = BenchmarkSupplier.getArrayList(500);
        BenchmarkResult arrayListResult = executeListCase(
                "Browsing",
                iterationsCount,
                arrayList,
                collection -> collection.get(0)
        );
        List<User> linkedList = BenchmarkSupplier.getLinkedList(500);
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
        List<User> arrayList = BenchmarkSupplier.getArrayList(500);
        User user = arrayList.get(0);
        BenchmarkResult arrayListResult = executeListCase(
                "Containing",
                iterationsCount,
                arrayList,
                collection -> collection.contains(user)
        );
        List<User> linkedList = BenchmarkSupplier.getLinkedList(500);
        BenchmarkResult linkedListResult = executeListCase(
                "Containing",
                iterationsCount,
                linkedList,
                collection -> collection.contains(user)
        );
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(arrayListResult);
        resultList.add(linkedListResult);
        return resultList;
    }

    private BenchmarkResult executeListCase(String caseType, int iterationsCount, List<User> list, Listable listable) {
        long startTime = System.nanoTime();
        for (int i = 0; i < iterationsCount; i++) {
            listable.execute(list);
        }
        long endTime = System.nanoTime();
        return new BenchmarkResult(
                caseType,
                list.getClass().getName(),
                iterationsCount,
                endTime - startTime
        );
    }
}
