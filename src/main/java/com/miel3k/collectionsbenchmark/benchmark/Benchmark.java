package com.miel3k.collectionsbenchmark.benchmark;

import com.miel3k.collectionsbenchmark.benchmark.suites.TestSuite;
import com.miel3k.collectionsbenchmark.benchmark.suites.factory.TestSuiteFactory;
import com.miel3k.collectionsbenchmark.enums.CaseType;
import com.miel3k.collectionsbenchmark.enums.SuitType;

import java.util.ArrayList;
import java.util.List;

public class Benchmark {

    private final List<SuitType> suitTypes;
    private final List<CaseType> caseTypes;
    private final int iterationsCount;

    public Benchmark(List<SuitType> suitTypeList, List<CaseType> caseTypeList, int iterationsCount) {
        this.suitTypes = suitTypeList;
        this.caseTypes = caseTypeList;
        this.iterationsCount = iterationsCount;
    }

    public void run() {
        List<TestSuite> testSuites = new ArrayList<>();
        for (SuitType type : suitTypes) {
            testSuites.add(TestSuiteFactory.getTestSuite(type.name(), iterationsCount));
        }
        for (TestSuite suite : testSuites) {
            if (caseTypes.contains(CaseType.Adding)) {
                suite.startAddingCase();
            }
            if (caseTypes.contains(CaseType.Removing)) {
                suite.startRemovingCase();
            }
            if (caseTypes.contains(CaseType.Browsing)) {
                suite.startBrowsingCase();
            }
            if (caseTypes.contains(CaseType.Containing)) {
                suite.startContainingCase();
            }
        }
    }
}

