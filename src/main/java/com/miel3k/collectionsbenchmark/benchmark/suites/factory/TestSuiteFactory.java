package com.miel3k.collectionsbenchmark.benchmark.suites.factory;

import com.miel3k.collectionsbenchmark.benchmark.suites.ListTestSuite;
import com.miel3k.collectionsbenchmark.benchmark.suites.SetTestSuite;
import com.miel3k.collectionsbenchmark.benchmark.suites.TestSuite;
import com.miel3k.collectionsbenchmark.enums.SuitType;

public class TestSuiteFactory {

    public static TestSuite getTestSuite(String type, int numberOfIterations) {
        if(SuitType.LIST.name().equalsIgnoreCase(type))
            return new ListTestSuite(numberOfIterations);

        else if(SuitType.SET.name().equalsIgnoreCase(type))
            return new SetTestSuite();

        return null;
    }
}
