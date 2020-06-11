package com.miel3k.collectionsbenchmark.controller;

import com.miel3k.collectionsbenchmark.enums.CaseType;
import com.miel3k.collectionsbenchmark.enums.SuitType;
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
        for (SuitType type : configuration.getSuitTypes()) {
            TestSuite testSuite = TestSuiteFactory.getTestSuite(
                    configuration.getModel(),
                    type,
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
            if (configuration.getCaseTypes().contains(CaseType.Adding)) {
                resultList.addAll(suite.executeAddingCase());
            }
            if (configuration.getCaseTypes().contains(CaseType.Removing)) {
                resultList.addAll(suite.executeRemovingCase());
            }
            if (configuration.getCaseTypes().contains(CaseType.Browsing)) {
                resultList.addAll(suite.executeBrowsingCase());
            }
            if (configuration.getCaseTypes().contains(CaseType.Containing)) {
                resultList.addAll(suite.executeContainingCase());
            }
        }
        return resultList;
    }
}

