package com.miel3k.collectionsbenchmark.benchmark;

import com.miel3k.collectionsbenchmark.benchmark.suites.TestSuite;
import com.miel3k.collectionsbenchmark.benchmark.suites.factory.TestSuiteFactory;
import com.miel3k.collectionsbenchmark.enums.CaseType;
import com.miel3k.collectionsbenchmark.enums.SuitType;
import com.miel3k.collectionsbenchmark.models.BenchmarkResult;
import com.miel3k.collectionsbenchmark.view.BenchmarkView;

import java.util.ArrayList;
import java.util.List;

public class Benchmark {

    private final BenchmarkView view;
    private final List<SuitType> suitTypes;
    private final List<CaseType> caseTypes;
    private final int iterationsCount;
    private final List<BenchmarkResult> resultList;

    public Benchmark(BenchmarkView view, List<SuitType> suitTypeList, List<CaseType> caseTypeList, int iterationsCount) {
        this.view = view;
        this.suitTypes = suitTypeList;
        this.caseTypes = caseTypeList;
        this.iterationsCount = iterationsCount;
        this.resultList = new ArrayList<>();
    }

    public void run() {
        List<BenchmarkResult> resultList = new ArrayList<>();
        List<TestSuite> testSuites = new ArrayList<>();
        for (SuitType type : suitTypes) {
            testSuites.add(TestSuiteFactory.getTestSuite(type.name(), iterationsCount));
        }
        for (TestSuite suite : testSuites) {
            if (caseTypes.contains(CaseType.Adding)) {
                resultList.addAll(suite.executeAddingCase());
            }
            if (caseTypes.contains(CaseType.Removing)) {
                resultList.addAll(suite.executeRemovingCase());
            }
            if (caseTypes.contains(CaseType.Browsing)) {
                resultList.addAll(suite.executeBrowsingCase());
            }
            if (caseTypes.contains(CaseType.Containing)) {
                resultList.addAll(suite.executeContainingCase());
            }
        }
        view.displayResults(resultList);
    }
}

