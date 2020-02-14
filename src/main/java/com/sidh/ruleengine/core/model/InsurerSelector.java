package com.sidh.ruleengine.core.model;

import com.sidh.ruleengine.skin.model.Director;
import com.sidh.ruleengine.skin.model.InsurerSelectionDT;

import java.util.List;

public class InsurerSelector implements IRuleExecutor<Director, InsurerSelectionDT, Void> {

    @Override
    public void init(Class<Director> factClass, List<InsurerSelectionDT> decisionTable) {

    }

    @Override
    public Void execute(Director fact) {
        return null;
    }
}
