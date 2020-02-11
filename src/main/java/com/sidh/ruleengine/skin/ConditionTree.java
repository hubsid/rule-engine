package com.sidh.ruleengine.skin;

import com.sidh.ruleengine.core.model.ConditionNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConditionTree <F, R>{
    private List<ConditionNode<F, R, ?>> headNodes;
    private String firstLhs;

    public ConditionTree() {
        headNodes = new ArrayList<>();
    }

    public ConditionNode<F, R, ?>  addNode(ConditionNode<F, R, ?> conditionNode) {
        if(headNodes.isEmpty())
            headNodes.add(conditionNode);
        else {
            Optional<ConditionNode<F, R, ?>> matchingNode = headNodes.stream().filter(node -> node.equals(conditionNode)).findFirst();
            if(matchingNode.isPresent()) {
                return matchingNode.get();
            }
            headNodes.add(conditionNode);
        }
        return conditionNode;
    }


}
