package com.miel3k.collectionsbenchmark;

import picocli.CommandLine;

@CommandLine.Command(name = "jbm", mixinStandardHelpOptions = true, version = "jbm - Java Collections Benchmark 0.0.1")
public class App implements Runnable {

    public void run() {
        System.out.println("Hello from Java Collections Benchmark");
    }

    public static void main(final String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}