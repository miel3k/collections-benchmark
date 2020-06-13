package com.miel3k.collectionsbenchmark.controller;

import com.miel3k.collectionsbenchmark.enums.TestCaseType;
import com.miel3k.collectionsbenchmark.enums.TestSuiteType;
import com.miel3k.collectionsbenchmark.model.BenchmarkConfiguration;
import com.miel3k.collectionsbenchmark.model.BenchmarkResult;
import com.miel3k.collectionsbenchmark.model.Warmer;
import com.miel3k.collectionsbenchmark.suites.TestSuite;
import com.miel3k.collectionsbenchmark.suites.factory.TestSuiteFactory;
import com.miel3k.collectionsbenchmark.view.BenchmarkView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BenchmarkController {

    private final BenchmarkView view;
    private final BenchmarkConfiguration configuration;

    public BenchmarkController(BenchmarkView view, BenchmarkConfiguration configuration) {
        this.view = view;
        this.configuration = configuration;
    }

    public void run() {
        if (configuration.isWarmUpEnabled()) Warmer.warmUp();
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
        if (configuration.isWriteEnabled()) writeResults(resultList);
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

    private void writeResults(List<BenchmarkResult> results) {
        File directory = new File("output");
        if (!directory.exists()) {
            directory.mkdir();
        }
        String collectionSizeText = "cs" + configuration.getCollectionSize();
        String iterationsCountText = "i" + configuration.getIterationsCount();
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String fileName = getTestSuiteTypesText()
                + "_" + configuration.getBenchmarkEntity().name()
                + "_" + getCaseTypesText()
                + "_" + collectionSizeText
                + "_" + iterationsCountText
                + "_" + timestamp;
        String fileContent = getBenchmarkResultsText(results);
        try (PrintWriter printWriter = new PrintWriter("output/" + fileName + ".txt")) {
            printWriter.println(fileContent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String getCaseTypesText() {
        List<String> caseTypes = configuration
                .getCaseTypes()
                .stream()
                .map(type -> type.name().substring(0, 1))
                .collect(Collectors.toList());
        return String.join("_", caseTypes);
    }

    private String getTestSuiteTypesText() {
        List<String> testSuiteTypes = configuration
                .getTestSuiteTypes()
                .stream()
                .map(type -> type.name().substring(0, 1))
                .collect(Collectors.toList());
        return String.join("_", testSuiteTypes);
    }

    private String getBenchmarkResultsText(List<BenchmarkResult> results) {
        StringBuilder text = new StringBuilder();
        text.append(BenchmarkResult.HEADER);
        for (BenchmarkResult result : results) {
            String row = result.toString();
            text.append(row);
        }
        return text.toString();
    }
}

