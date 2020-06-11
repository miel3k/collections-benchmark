package com.miel3k.collectionsbenchmark.model;

import com.miel3k.collectionsbenchmark.enums.CaseType;
import com.miel3k.collectionsbenchmark.enums.Model;
import com.miel3k.collectionsbenchmark.enums.SuitType;

import java.util.List;

public class BenchmarkConfiguration {

    private final Model model;
    private final List<SuitType> suitTypes;
    private final List<CaseType> caseTypes;
    private final int collectionSize;
    private final int iterationsCount;

    public BenchmarkConfiguration(Model model, List<SuitType> suitTypeList, List<CaseType> caseTypeList, int collectionSize, int iterationsCount) {
        this.model = model;
        this.suitTypes = suitTypeList;
        this.caseTypes = caseTypeList;
        this.collectionSize = collectionSize;
        this.iterationsCount = iterationsCount;
    }

    public Model getModel() {
        return model;
    }

    public List<SuitType> getSuitTypes() {
        return suitTypes;
    }

    public List<CaseType> getCaseTypes() {
        return caseTypes;
    }

    public int getCollectionSize() {
        return collectionSize;
    }

    public int getIterationsCount() {
        return iterationsCount;
    }
}
