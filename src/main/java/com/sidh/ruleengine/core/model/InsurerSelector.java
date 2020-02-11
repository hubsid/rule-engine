package com.sidh.ruleengine.core.model;

import com.sidh.ruleengine.skin.model.Director;
import com.sidh.ruleengine.skin.model.InsurerSelectionDT;

import java.util.List;

public class InsurerSelector implements IRuleExecutor<Director, InsurerSelectionDT, Void> {

    @Override
    public void init(List<InsurerSelectionDT> decisionTable) {

    }

    public Void execute(Director director, InsurerSelectionDT decisionTable) {

        director.setInsurer(decisionTable.getInsurer());
        return null;
    }
}
