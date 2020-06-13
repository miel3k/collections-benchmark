package com.miel3k.collectionsbenchmark.model;

public class Warmer {

    public Warmer() {
    }

    public void method() {
    }

    public static void warmUp() {
        for (int i = 0; i < 100000; i++) {
            Warmer warmer = new Warmer();
            warmer.method();
        }
    }
}
