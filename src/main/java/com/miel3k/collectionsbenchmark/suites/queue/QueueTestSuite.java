package com.miel3k.collectionsbenchmark.suites.queue;

import com.miel3k.collectionsbenchmark.model.BenchmarkResult;
import com.miel3k.collectionsbenchmark.model.Testable;
import com.miel3k.collectionsbenchmark.suites.TestSuite;
import com.miel3k.collectionsbenchmark.suites.supplier.TestSuiteSupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class QueueTestSuite<T extends Testable<T>> implements TestSuite {

    private final T testObject;
    private final int collectionSize;
    private final int iterationsCount;

    public QueueTestSuite(T testObject, int collectionSize, int numberOfIterations) {
        this.testObject = testObject;
        this.collectionSize = collectionSize;
        this.iterationsCount = numberOfIterations;
    }

    @Override
    public List<BenchmarkResult> executeAddingCase() {
        String caseType = "Adding";
        Queue<T> priorityQueue = TestSuiteSupplier.getPriorityQueue(testObject, collectionSize);
        BenchmarkResult priorityQueueResult = executeQueueCase(
                caseType,
                priorityQueue,
                collection -> collection.add(testObject.copy())
        );
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(priorityQueueResult);
        return resultList;
    }

    @Override
    public List<BenchmarkResult> executeRemovingCase() {
        String caseType = "Removing";
        Queue<T> priorityQueue = TestSuiteSupplier.getPriorityQueue(testObject, collectionSize);
        BenchmarkResult priorityQueueResult = executeQueueCase(
                caseType,
                priorityQueue,
                Queue::remove
        );
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(priorityQueueResult);
        return resultList;
    }

    @Override
    public List<BenchmarkResult> executeBrowsingCase() {
        String caseType = "Browsing";
        Queue<T> priorityQueue = TestSuiteSupplier.getPriorityQueue(testObject, collectionSize);
        BenchmarkResult priorityQueueResult = executeQueueCase(
                caseType,
                priorityQueue,
                Queue::peek
        );
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(priorityQueueResult);
        return resultList;
    }

    @Override
    public List<BenchmarkResult> executeContainingCase() {
        String caseType = "Containing";
        Queue<T> priorityQueue = TestSuiteSupplier.getPriorityQueue(testObject, collectionSize);
        BenchmarkResult priorityQueueResult = executeQueueCase(
                caseType,
                priorityQueue,
                collection -> collection.contains(testObject.copy())
        );
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(priorityQueueResult);
        return resultList;
    }

    private BenchmarkResult executeQueueCase(String caseType, Queue<T> queue, Queueable<T> queueable) {
        long startTime = System.nanoTime();
        for (int i = 0; i < iterationsCount; i++) {
            queueable.execute(queue);
        }
        long endTime = System.nanoTime();
        return new BenchmarkResult(
                testObject.getClass().getSimpleName(),
                caseType,
                queue.getClass().getSimpleName(),
                collectionSize,
                queue.size(),
                iterationsCount,
                (endTime - startTime) / iterationsCount
        );
    }
}