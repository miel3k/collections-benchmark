package com.miel3k.collectionsbenchmark.suites.factory;

import com.miel3k.collectionsbenchmark.enums.BenchmarkEntity;
import com.miel3k.collectionsbenchmark.enums.TestSuiteType;
import com.miel3k.collectionsbenchmark.model.Author;
import com.miel3k.collectionsbenchmark.model.Book;
import com.miel3k.collectionsbenchmark.suites.TestSuite;
import com.miel3k.collectionsbenchmark.suites.list.ListTestSuite;
import com.miel3k.collectionsbenchmark.suites.queue.QueueTestSuite;
import com.miel3k.collectionsbenchmark.suites.set.SetTestSuite;

public class TestSuiteFactory {

    public static TestSuite getTestSuite(BenchmarkEntity benchmarkEntity, TestSuiteType type, int collectionSize, int numberOfIterations) {
        if (benchmarkEntity.name().equalsIgnoreCase(BenchmarkEntity.Book.name())) {
            return getBookTestSuite(type, collectionSize, numberOfIterations);
        } else if (benchmarkEntity.name().equalsIgnoreCase(BenchmarkEntity.Author.name())) {
            return getAuthorTestSuite(type, collectionSize, numberOfIterations);
        }
        return null;
    }

    private static TestSuite getAuthorTestSuite(TestSuiteType type, int collectionSize, int numberOfIterations) {
        Author author = new Author("Name", 10);
        if (TestSuiteType.LIST.name().equalsIgnoreCase(type.name())) {
            return new ListTestSuite<>(author, collectionSize, numberOfIterations);
        } else if (TestSuiteType.SET.name().equalsIgnoreCase(type.name())) {
            return new SetTestSuite<>(author, collectionSize, numberOfIterations);
        } else if (TestSuiteType.QUEUE.name().equalsIgnoreCase(type.name())) {
            return new QueueTestSuite<>(author, collectionSize, numberOfIterations);
        }
        return null;
    }

    private static TestSuite getBookTestSuite(TestSuiteType type, int collectionSize, int numberOfIterations) {
        Author author = new Author("Name", 10);
        Book book = new Book("Title", author);
        if (TestSuiteType.LIST.name().equalsIgnoreCase(type.name())) {
            return new ListTestSuite<>(book, collectionSize, numberOfIterations);
        } else if (TestSuiteType.SET.name().equalsIgnoreCase(type.name())) {
            return new SetTestSuite<>(book, collectionSize, numberOfIterations);
        } else if (TestSuiteType.QUEUE.name().equalsIgnoreCase(type.name())) {
            return new QueueTestSuite<>(book, collectionSize, numberOfIterations);
        }
        return null;
    }
}
