package com.miel3k.collectionsbenchmark.benchmark;

import com.miel3k.collectionsbenchmark.models.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class BenchmarkSupplier {

    public static List<User> getArrayList(int n) {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new User(UUID.randomUUID().toString(), "UserName", 10));
        }
        return list;
    }

    public static List<User> getLinkedList(int n) {
        List<User> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(new User(UUID.randomUUID().toString(), "UserName", 10));
        }
        return list;
    }
}
