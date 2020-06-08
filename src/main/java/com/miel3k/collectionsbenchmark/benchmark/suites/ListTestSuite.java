package com.miel3k.collectionsbenchmark.benchmark.suites;

import com.miel3k.collectionsbenchmark.models.BenchmarkResult;
import com.miel3k.collectionsbenchmark.models.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ListTestSuite implements TestSuite {

    private final List<User> list;
    private final List<User> linkedList;
    private final int iterationsCount;

    private final List<BenchmarkResult> resultList;

    public ListTestSuite(int numberOfIterations) {
        this.list = new ArrayList<>();
        this.linkedList = new LinkedList<>();
        this.iterationsCount = numberOfIterations;
        this.resultList = new ArrayList<>();
    }

    @Override
    public void startAddingCase() {
        list.clear();
        User user = new User(UUID.randomUUID().toString(), "UserName", 10);
        long startTime = System.nanoTime();
        for (int i = 0; i < iterationsCount; i++) {
            list.add(0, user);
        }
        long endTime = System.nanoTime();
        BenchmarkResult arrayListResult = new BenchmarkResult(
                "Adding",
                "ArrayList",
                iterationsCount,
                endTime - startTime
        );
        resultList.add(arrayListResult);
        linkedList.clear();
        startTime = System.nanoTime();
        for (int i = 0; i < iterationsCount; i++) {
            linkedList.add(0, user);
        }
        endTime = System.nanoTime();
        BenchmarkResult linkedListResult = new BenchmarkResult(
                "Adding",
                "LinkedList",
                iterationsCount,
                endTime - startTime
        );
        resultList.add(linkedListResult);
    }

    @Override
    public void startRemovingCase() {

    }

    @Override
    public void startBrowsingCase() {

    }

    @Override
    public void startContainingCase() {

    }

    @Override
    public List<BenchmarkResult> getResults() {
        return resultList;
    }
}
