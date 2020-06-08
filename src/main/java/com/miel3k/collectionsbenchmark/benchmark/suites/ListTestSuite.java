package com.miel3k.collectionsbenchmark.benchmark.suites;

import com.miel3k.collectionsbenchmark.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ListTestSuite implements TestSuite {

    private final List<User> list = new ArrayList<>();
    private final int iterationsCount;

    public ListTestSuite(int numberOfIterations) {
        this.iterationsCount = numberOfIterations;
    }

    @Override
    public void startAddingCase() {
        list.clear();
        User user = new User(UUID.randomUUID().toString(), "UserName", 10);
        Long startTime = System.nanoTime();
        for (int i = 0; i < iterationsCount; i++) {
            list.add(0, user);
        }
        Long endTime = System.nanoTime();
        System.out.println(
                "ArrayList: adding " + iterationsCount + " elements, " +
                        "time: " + (endTime - startTime) + " ns. " +
                        "size: " + list.size()
        );
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
}
