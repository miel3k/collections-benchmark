package com.miel3k.collectionsbenchmark.benchmark.suites.factory;

import com.miel3k.collectionsbenchmark.benchmark.suites.ListTestSuite;
import com.miel3k.collectionsbenchmark.benchmark.suites.SetTestSuite;
import com.miel3k.collectionsbenchmark.benchmark.suites.TestSuite;
import com.miel3k.collectionsbenchmark.enums.Model;
import com.miel3k.collectionsbenchmark.enums.SuitType;
import com.miel3k.collectionsbenchmark.models.Author;
import com.miel3k.collectionsbenchmark.models.Book;

import java.util.UUID;

public class TestSuiteFactory {

    public static TestSuite getTestSuite(Model model, SuitType type, int numberOfIterations) {
        if (model.name().equalsIgnoreCase(Model.Book.name())) {
            return getBookTestSuite(type, numberOfIterations);
        } else if (model.name().equalsIgnoreCase(Model.Author.name())) {
            return getAuthorTestSuite(type, numberOfIterations);
        }
        return null;
    }

    private static TestSuite getAuthorTestSuite(SuitType type, int numberOfIterations) {
        if (SuitType.LIST.name().equalsIgnoreCase(type.name())) {
            Author author = new Author(UUID.randomUUID().toString(), "UserName", 10);
            return new ListTestSuite<>(author, numberOfIterations);
        } else if (SuitType.SET.name().equalsIgnoreCase(type.name())) {
            return new SetTestSuite();
        }
        return null;
    }

    private static TestSuite getBookTestSuite(SuitType type, int numberOfIterations) {
        if (SuitType.LIST.name().equalsIgnoreCase(type.name())) {
            Author author = new Author(UUID.randomUUID().toString(), "UserName", 10);
            Book book = new Book("Title", author);
            return new ListTestSuite<>(book, numberOfIterations);
        } else if (SuitType.SET.name().equalsIgnoreCase(type.name())) {
            return new SetTestSuite();
        }
        return null;
    }
}
