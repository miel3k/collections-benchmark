package com.miel3k.collectionsbenchmark;

import com.miel3k.collectionsbenchmark.benchmark.Benchmark;
import com.miel3k.collectionsbenchmark.enums.CaseType;
import com.miel3k.collectionsbenchmark.enums.SuitType;
import com.miel3k.collectionsbenchmark.view.BenchmarkView;
import com.miel3k.collectionsbenchmark.view.ConsoleView;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.List;

@CommandLine.Command(name = "jbm", mixinStandardHelpOptions = true, version = "jbm - Java Collections Benchmark 0.0.1")
public class App implements Runnable {

    public void run() {
        System.out.println("Hello from Java Collections Benchmark");
        List<SuitType> suitTypeList = new ArrayList<>();
        suitTypeList.add(SuitType.LIST);
        List<CaseType> caseTypeList = new ArrayList<>();
        caseTypeList.add(CaseType.Adding);
        BenchmarkView benchmarkView = new ConsoleView();
        Benchmark benchmark = new Benchmark(benchmarkView, suitTypeList, caseTypeList, 5);
        benchmark.run();
    }

    public static void main(final String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}