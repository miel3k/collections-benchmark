package com.miel3k.collectionsbenchmark.benchmark.suites.factory;

import com.miel3k.collectionsbenchmark.benchmark.suites.TestSuite;
import com.miel3k.collectionsbenchmark.benchmark.suites.list.ListTestSuite;
import com.miel3k.collectionsbenchmark.benchmark.suites.queue.QueueTestSuite;
import com.miel3k.collectionsbenchmark.benchmark.suites.set.SetTestSuite;
import com.miel3k.collectionsbenchmark.enums.Model;
import com.miel3k.collectionsbenchmark.enums.SuitType;
import com.miel3k.collectionsbenchmark.models.Author;
import com.miel3k.collectionsbenchmark.models.Book;

public class TestSuiteFactory {

    public static TestSuite getTestSuite(Model model, SuitType type, int collectionSize, int numberOfIterations) {
        if (model.name().equalsIgnoreCase(Model.Book.name())) {
            return getBookTestSuite(type, collectionSize, numberOfIterations);
        } else if (model.name().equalsIgnoreCase(Model.Author.name())) {
            return getAuthorTestSuite(type, collectionSize, numberOfIterations);
        }
        return null;
    }

    private static TestSuite getAuthorTestSuite(SuitType type, int collectionSize, int numberOfIterations) {
        Author author = new Author("Name", 10);
        if (SuitType.LIST.name().equalsIgnoreCase(type.name())) {
            return new ListTestSuite<>(author, collectionSize, numberOfIterations);
        } else if (SuitType.SET.name().equalsIgnoreCase(type.name())) {
            return new SetTestSuite<>(author, collectionSize, numberOfIterations);
        } else if (SuitType.QUEUE.name().equalsIgnoreCase(type.name())) {
            return new QueueTestSuite<>(author, collectionSize, numberOfIterations);
        }
        return null;
    }

    private static TestSuite getBookTestSuite(SuitType type, int collectionSize, int numberOfIterations) {
        Author author = new Author("Name", 10);
        Book book = new Book("Title", author);
        if (SuitType.LIST.name().equalsIgnoreCase(type.name())) {
            return new ListTestSuite<>(book, collectionSize, numberOfIterations);
        } else if (SuitType.SET.name().equalsIgnoreCase(type.name())) {
            return new SetTestSuite<>(book, collectionSize, numberOfIterations);
        } else if (SuitType.QUEUE.name().equalsIgnoreCase(type.name())) {
            return new QueueTestSuite<>(book, collectionSize, numberOfIterations);
        }
        return null;
    }
}
