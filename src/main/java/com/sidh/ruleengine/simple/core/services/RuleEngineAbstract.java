package com.sidh.ruleengine.simple.core.services;

import java.util.List;
import java.util.Optional;

public abstract class RuleEngineAbstract<F, D> {
    private List<D> decisionTable;

    public void setDecisionTable(List<D> decisionTable) {
        this.decisionTable = decisionTable;
    }

    public void execute(F fact) {
        Optional<D> match = decisionTable.stream()
                .filter(dt -> findMatch(dt, fact)).findFirst();

        match.ifPresent(dt -> modifyFact(fact, dt));
    }

    protected abstract void modifyFact(F fact, D dt);

    protected abstract boolean findMatch(D dt, F fact);
}
