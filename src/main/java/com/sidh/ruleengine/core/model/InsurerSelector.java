package com.sidh.ruleengine.core.model;

import com.sidh.ruleengine.skin.ConditionTree;
import com.sidh.ruleengine.skin.model.Director;
import com.sidh.ruleengine.skin.model.InsurerSelectionDT;

import java.util.List;
import java.util.ListIterator;

public class InsurerSelector implements IRuleExecutor<Director, InsurerSelectionDT, Void> {
    private ConditionTree<Director, Void> conditionTree;

    public InsurerSelector() {
        conditionTree = new ConditionTree<>();
    }

    @Override
    public void init(Class<Director> factClass, List<InsurerSelectionDT> decisionTable) {
        if(decisionTable.isEmpty()) {
            return;
        }
        ListIterator<InsurerSelectionDT> iterator = decisionTable.listIterator();
        conditionTree.addNode(new ConditionNode<>("getAge", Operator.GREATERTHAN, iterator.next().getAgeLow()))
                .add(new ConditionNode<>("getAge", Operator.LESSTHAN, iterator.next().getAgeHigh()))
                .add()
    }

    @Override
    public Void execute(Director fact) {
        return null;
    }
}
