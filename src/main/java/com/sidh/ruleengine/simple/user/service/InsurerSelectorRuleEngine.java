package com.sidh.ruleengine.simple.user.service;

import com.sidh.ruleengine.simple.core.services.RuleEngineAbstract;
import com.sidh.ruleengine.simple.user.model.Director;
import com.sidh.ruleengine.simple.user.model.InsurerSelectionDT;

import java.util.List;

public class InsurerSelectorRuleEngine extends RuleEngineAbstract<Director, InsurerSelectionDT> {

    public InsurerSelectorRuleEngine(List<InsurerSelectionDT> decisionTable) {
        setDecisionTable(decisionTable);
    }

    public void modifyFact(Director director, InsurerSelectionDT insurerSelectionDT) {
        director.setInsurer(insurerSelectionDT.getInsurer());
    }

    public boolean findMatch(InsurerSelectionDT dt, Director director) {
        return director.getAge() >= dt.getAgeLow()
                && director.getAge() <= dt.getAgeHigh()
                && director.getTenure() <= dt.getTenureHigh()
                && director.getProductType() == dt.getProductType();
    }
}
