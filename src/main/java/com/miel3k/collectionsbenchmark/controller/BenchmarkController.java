package com.miel3k.collectionsbenchmark.controller;

import com.miel3k.collectionsbenchmark.enums.TestCaseType;
import com.miel3k.collectionsbenchmark.enums.TestSuiteType;
import com.miel3k.collectionsbenchmark.model.BenchmarkConfiguration;
import com.miel3k.collectionsbenchmark.model.BenchmarkResult;
import com.miel3k.collectionsbenchmark.suites.TestSuite;
import com.miel3k.collectionsbenchmark.suites.factory.TestSuiteFactory;
import com.miel3k.collectionsbenchmark.view.BenchmarkView;

import java.util.ArrayList;
import java.util.List;

public class BenchmarkController {

    private final BenchmarkView view;
    private final BenchmarkConfiguration configuration;

    public BenchmarkController(BenchmarkView view, BenchmarkConfiguration configuration) {
        this.view = view;
        this.configuration = configuration;
    }

    public void run() {
        List<TestSuite> testSuites = new ArrayList<>();
        for (TestSuiteType testSuiteType : configuration.getTestSuiteTypes()) {
            TestSuite testSuite = TestSuiteFactory.getTestSuite(
                    configuration.getBenchmarkEntity(),
                    testSuiteType,
                    configuration.getCollectionSize(),
                    configuration.getIterationsCount()
            );
            testSuites.add(testSuite);
        }
        List<BenchmarkResult> resultList = executeTestSuites(testSuites);
        view.displayResults(resultList);
    }

    private List<BenchmarkResult> executeTestSuites(List<TestSuite> testSuites) {
        List<BenchmarkResult> resultList = new ArrayList<>();
        for (TestSuite suite : testSuites) {
            if (configuration.getCaseTypes().contains(TestCaseType.Adding)) {
                resultList.addAll(suite.executeAddingCase());
            }
            if (configuration.getCaseTypes().contains(TestCaseType.Removing)) {
                resultList.addAll(suite.executeRemovingCase());
            }
            if (configuration.getCaseTypes().contains(TestCaseType.Browsing)) {
                resultList.addAll(suite.executeBrowsingCase());
            }
            if (configuration.getCaseTypes().contains(TestCaseType.Containing)) {
                resultList.addAll(suite.executeContainingCase());
            }
        }
        return resultList;
    }
}

