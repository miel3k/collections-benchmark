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
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(executePriorityQueueAddingCase());
        resultList.add(executePriorityBlockingQueueAddingCase());
        resultList.add(executeArrayBlockingQueueAddingCase());
        resultList.add(executeLinkedBlockingQueueAddingCase());
        resultList.add(executeLinkedTransferQueueAddingCase());
        resultList.add(executeConcurrentLinkedQueueAddingCase());
        return resultList;
    }

    private BenchmarkResult executePriorityQueueAddingCase() {
        Queue<T> priorityQueue = TestSuiteSupplier.getPriorityQueue(testObject, collectionSize);
        return executeQueueCase(
                "Adding",
                priorityQueue,
                collection -> collection.add(testObject.copy())
        );
    }

    private BenchmarkResult executePriorityBlockingQueueAddingCase() {
        Queue<T> priorityBlockingQueue = TestSuiteSupplier.getPriorityBlockingQueue(testObject, collectionSize);
        return executeQueueCase(
                "Adding",
                priorityBlockingQueue,
                collection -> collection.add(testObject.copy())
        );
    }

    private BenchmarkResult executeArrayBlockingQueueAddingCase() {
        Queue<T> arrayBlockingQueue = TestSuiteSupplier.getArrayBlockingQueue(testObject, collectionSize);
        return executeQueueCase(
                "Adding",
                arrayBlockingQueue,
                collection -> collection.add(testObject.copy())
        );
    }

    private BenchmarkResult executeLinkedBlockingQueueAddingCase() {
        Queue<T> linkedBlockingQueue = TestSuiteSupplier.getLinkedBlockingQueue(testObject, collectionSize);
        return executeQueueCase(
                "Adding",
                linkedBlockingQueue,
                collection -> collection.add(testObject.copy())
        );
    }

    private BenchmarkResult executeLinkedTransferQueueAddingCase() {
        Queue<T> linkedTransferQueue = TestSuiteSupplier.getLinkedTransferQueue(testObject, collectionSize);
        return executeQueueCase(
                "Adding",
                linkedTransferQueue,
                collection -> collection.add(testObject.copy())
        );
    }

    private BenchmarkResult executeConcurrentLinkedQueueAddingCase() {
        Queue<T> concurrentLinkedQueue = TestSuiteSupplier.getConcurrentLinkedQueue(testObject, collectionSize);
        return executeQueueCase(
                "Adding",
                concurrentLinkedQueue,
                collection -> collection.add(testObject.copy())
        );
    }

    @Override
    public List<BenchmarkResult> executeRemovingCase() {
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(executePriorityQueueRemovingCase());
        resultList.add(executePriorityBlockingQueueRemovingCase());
        resultList.add(executeArrayBlockingQueueRemovingCase());
        resultList.add(executeLinkedBlockingQueueRemovingCase());
        resultList.add(executeLinkedTransferQueueRemovingCase());
        resultList.add(executeConcurrentLinkedQueueRemovingCase());
        return resultList;
    }

    private BenchmarkResult executePriorityQueueRemovingCase() {
        Queue<T> priorityQueue = TestSuiteSupplier.getPriorityQueue(testObject, collectionSize);
        return executeQueueCase(
                "Removing",
                priorityQueue,
                Queue::remove
        );
    }

    private BenchmarkResult executePriorityBlockingQueueRemovingCase() {
        Queue<T> priorityBlockingQueue = TestSuiteSupplier.getPriorityBlockingQueue(testObject, collectionSize);
        return executeQueueCase(
                "Removing",
                priorityBlockingQueue,
                Queue::remove
        );
    }

    private BenchmarkResult executeArrayBlockingQueueRemovingCase() {
        Queue<T> arrayBlockingQueue = TestSuiteSupplier.getArrayBlockingQueue(testObject, collectionSize);
        return executeQueueCase(
                "Removing",
                arrayBlockingQueue,
                Queue::remove
        );
    }

    private BenchmarkResult executeLinkedBlockingQueueRemovingCase() {
        Queue<T> linkedBlockingQueue = TestSuiteSupplier.getLinkedBlockingQueue(testObject, collectionSize);
        return executeQueueCase(
                "Removing",
                linkedBlockingQueue,
                Queue::remove
        );
    }

    private BenchmarkResult executeLinkedTransferQueueRemovingCase() {
        Queue<T> linkedTransferQueue = TestSuiteSupplier.getLinkedTransferQueue(testObject, collectionSize);
        return executeQueueCase(
                "Removing",
                linkedTransferQueue,
                Queue::remove
        );
    }

    private BenchmarkResult executeConcurrentLinkedQueueRemovingCase() {
        Queue<T> concurrentLinkedQueue = TestSuiteSupplier.getConcurrentLinkedQueue(testObject, collectionSize);
        return executeQueueCase(
                "Removing",
                concurrentLinkedQueue,
                Queue::remove
        );
    }

    @Override
    public List<BenchmarkResult> executeBrowsingCase() {
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(executePriorityQueueBrowsingCase());
        resultList.add(executePriorityBlockingQueueBrowsingCase());
        resultList.add(executeArrayBlockingQueueBrowsingCase());
        resultList.add(executeLinkedBlockingQueueBrowsingCase());
        resultList.add(executeLinkedTransferQueueBrowsingCase());
        resultList.add(executeConcurrentLinkedQueueBrowsingCase());
        return resultList;
    }

    private BenchmarkResult executePriorityQueueBrowsingCase() {
        Queue<T> priorityQueue = TestSuiteSupplier.getPriorityQueue(testObject, collectionSize);
        return executeQueueCase(
                "Browsing",
                priorityQueue,
                Queue::peek
        );
    }

    private BenchmarkResult executePriorityBlockingQueueBrowsingCase() {
        Queue<T> priorityBlockingQueue = TestSuiteSupplier.getPriorityBlockingQueue(testObject, collectionSize);
        return executeQueueCase(
                "Browsing",
                priorityBlockingQueue,
                Queue::peek
        );
    }

    private BenchmarkResult executeArrayBlockingQueueBrowsingCase() {
        Queue<T> arrayBlockingQueue = TestSuiteSupplier.getArrayBlockingQueue(testObject, collectionSize);
        return executeQueueCase(
                "Browsing",
                arrayBlockingQueue,
                Queue::peek
        );
    }

    private BenchmarkResult executeLinkedBlockingQueueBrowsingCase() {
        Queue<T> linkedBlockingQueue = TestSuiteSupplier.getLinkedBlockingQueue(testObject, collectionSize);
        return executeQueueCase(
                "Browsing",
                linkedBlockingQueue,
                Queue::peek
        );
    }

    private BenchmarkResult executeLinkedTransferQueueBrowsingCase() {
        Queue<T> linkedTransferQueue = TestSuiteSupplier.getLinkedTransferQueue(testObject, collectionSize);
        return executeQueueCase(
                "Browsing",
                linkedTransferQueue,
                Queue::peek
        );
    }

    private BenchmarkResult executeConcurrentLinkedQueueBrowsingCase() {
        Queue<T> concurrentLinkedQueue = TestSuiteSupplier.getConcurrentLinkedQueue(testObject, collectionSize);
        return executeQueueCase(
                "Browsing",
                concurrentLinkedQueue,
                Queue::peek
        );
    }

    @Override
    public List<BenchmarkResult> executeContainingCase() {
        List<BenchmarkResult> resultList = new ArrayList<>();
        resultList.add(executePriorityQueueContainingCase());
        resultList.add(executePriorityBlockingQueueContainingCase());
        resultList.add(executeArrayBlockingQueueContainingCase());
        resultList.add(executeLinkedBlockingQueueContainingCase());
        resultList.add(executeLinkedTransferQueueContainingCase());
        resultList.add(executeConcurrentLinkedQueueContainingCase());
        return resultList;
    }

    private BenchmarkResult executePriorityQueueContainingCase() {
        Queue<T> priorityQueue = TestSuiteSupplier.getPriorityQueue(testObject, collectionSize);
        return executeQueueCase(
                "Containing",
                priorityQueue,
                collection -> collection.contains(testObject.copy())
        );
    }

    private BenchmarkResult executePriorityBlockingQueueContainingCase() {
        Queue<T> priorityBlockingQueue = TestSuiteSupplier.getPriorityBlockingQueue(testObject, collectionSize);
        return executeQueueCase(
                "Containing",
                priorityBlockingQueue,
                collection -> collection.contains(testObject.copy())
        );
    }

    private BenchmarkResult executeArrayBlockingQueueContainingCase() {
        Queue<T> arrayBlockingQueue = TestSuiteSupplier.getArrayBlockingQueue(testObject, collectionSize);
        return executeQueueCase(
                "Containing",
                arrayBlockingQueue,
                collection -> collection.contains(testObject.copy())
        );
    }

    private BenchmarkResult executeLinkedBlockingQueueContainingCase() {
        Queue<T> linkedBlockingQueue = TestSuiteSupplier.getLinkedBlockingQueue(testObject, collectionSize);
        return executeQueueCase(
                "Containing",
                linkedBlockingQueue,
                collection -> collection.contains(testObject.copy())
        );
    }

    private BenchmarkResult executeLinkedTransferQueueContainingCase() {
        Queue<T> linkedTransferQueue = TestSuiteSupplier.getLinkedTransferQueue(testObject, collectionSize);
        return executeQueueCase(
                "Containing",
                linkedTransferQueue,
                collection -> collection.contains(testObject.copy())
        );
    }

    private BenchmarkResult executeConcurrentLinkedQueueContainingCase() {
        Queue<T> concurrentLinkedQueue = TestSuiteSupplier.getConcurrentLinkedQueue(testObject, collectionSize);
        return executeQueueCase(
                "Containing",
                concurrentLinkedQueue,
                collection -> collection.contains(testObject.copy())
        );
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