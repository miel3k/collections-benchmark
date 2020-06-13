package com.miel3k.collectionsbenchmark;

import com.miel3k.collectionsbenchmark.controller.BenchmarkController;
import com.miel3k.collectionsbenchmark.enums.BenchmarkEntity;
import com.miel3k.collectionsbenchmark.enums.TestCaseType;
import com.miel3k.collectionsbenchmark.enums.TestSuiteType;
import com.miel3k.collectionsbenchmark.model.BenchmarkConfiguration;
import com.miel3k.collectionsbenchmark.view.BenchmarkView;
import com.miel3k.collectionsbenchmark.view.ConsoleView;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.List;

@CommandLine.Command(name = "jcb", mixinStandardHelpOptions = true, version = "jcb - Java Collections Benchmark 0.0.1")
public class App implements Runnable {

    @CommandLine.Option(names = {"-l", "--list"}, description = "list: List benchmark")
    boolean isListBenchmarkEnabled;

    @CommandLine.Option(names = {"-s", "--set"}, description = "set: Set benchmark")
    boolean isSetBenchmarkEnabled;

    @CommandLine.Option(names = {"-q", "--queue"}, description = "queue: Queue benchmark")
    boolean isQueueBenchmarkEnabled;

    @CommandLine.Option(names = {"-c", "--cases"}, description = "cases: a - adding, r - removing, b - browsing, c - containing", defaultValue = "arbc")
    String cases;

    @CommandLine.Option(names = {"-e", "--entity"}, description = "entity: Author || Book", defaultValue = "Author")
    String entity;

    @CommandLine.Option(names = {"-cs", "--collectionSize"}, description = "collection size: (int)", defaultValue = "10")
    int collectionSize;

    @CommandLine.Option(names = {"-i", "--iterations"}, description = "iterations: (int)", defaultValue = "5")
    int iterations;

    @CommandLine.Option(names = {"-w", "--write"}, description = "write: write results to file")
    boolean isWriteEnabled;

    @CommandLine.Option(names = {"-wu", "--warmUp"}, description = "warm up: JVM warm-up")
    boolean isWarmUpEnabled;

    public void run() {
        System.out.println("Hello from Java Collections Benchmark");
        int size = parseCollectionSize();
        BenchmarkConfiguration benchmarkConfiguration = new BenchmarkConfiguration(
                parseEntity(),
                parseTestSuiteTypes(),
                parseCaseTypes(),
                size,
                parseIterations(size),
                isWriteEnabled,
                isWarmUpEnabled
        );
        BenchmarkView benchmarkView = new ConsoleView();
        BenchmarkController benchmarkController = new BenchmarkController(benchmarkView, benchmarkConfiguration);
        benchmarkController.run();
    }

    private List<TestSuiteType> parseTestSuiteTypes() {
        List<TestSuiteType> suiteTypeList = new ArrayList<>();
        if (isListBenchmarkEnabled) suiteTypeList.add(TestSuiteType.LIST);
        if (isSetBenchmarkEnabled) suiteTypeList.add(TestSuiteType.SET);
        if (isQueueBenchmarkEnabled) suiteTypeList.add(TestSuiteType.QUEUE);
        if (suiteTypeList.isEmpty()) {
            suiteTypeList.add(TestSuiteType.LIST);
            suiteTypeList.add(TestSuiteType.SET);
            suiteTypeList.add(TestSuiteType.QUEUE);
        }
        return suiteTypeList;
    }

    private List<TestCaseType> parseCaseTypes() {
        List<TestCaseType> caseTypeList = new ArrayList<>();
        if (cases.contains("a")) caseTypeList.add(TestCaseType.Adding);
        if (cases.contains("r")) caseTypeList.add(TestCaseType.Removing);
        if (cases.contains("b")) caseTypeList.add(TestCaseType.Browsing);
        if (cases.contains("c")) caseTypeList.add(TestCaseType.Containing);
        return caseTypeList;
    }

    private BenchmarkEntity parseEntity() {
        BenchmarkEntity benchmarkEntity;
        if (entity.equalsIgnoreCase("Author")) {
            benchmarkEntity = BenchmarkEntity.Author;
        } else if (entity.equalsIgnoreCase("Book")) {
            benchmarkEntity = BenchmarkEntity.Book;
        } else {
            benchmarkEntity = BenchmarkEntity.Author;
        }
        return benchmarkEntity;
    }

    private int parseCollectionSize() {
        if (collectionSize >= 0) {
            return collectionSize;
        } else {
            return 1;
        }
    }

    private int parseIterations(int collectionSize) {
        if (iterations <= collectionSize) {
            return iterations;
        } else {
            return collectionSize;
        }
    }

    public static void main(final String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}