package com.sidh.ruleengine.core.model;

import java.util.List;

public interface IRuleExecutor<F, D, R> {
    void init(Class<F> factClass, List<D> decisionTable);
    
}
