package com.sidh.ruleengine.skin;

import com.sidh.ruleengine.core.model.ConditionNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConditionTree<F, R> {
    private List<ConditionNode<F, R, ?>> headNodes;
    private String firstLhs;

    public ConditionTree() {
        headNodes = new ArrayList<>();
    }

    public ConditionNode<F, R, ?> addNode(ConditionNode<F, R, ?> conditionNode) {
        if (headNodes.isEmpty())
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

    public R execute(F fact) {
        List<? extends ConditionNode<F, R, ?>> nodeList = headNodes;
        Optional<ConditionNode<F, R, ?>> matchingNode;
        do {
            matchingNode = headNodes.stream().filter(n -> n.test(fact)).findFirst();
            if (matchingNode.isPresent()) {
                if(matchingNode.get() instanceof ConditionLeafNode)
                    return ((ConditionLeafNode<F, R, ?>)matchingNode.get()).execute(fact);
                nodeList = matchingNode.get().getChildNodes();
            } else
                return null;
        } while (nodeList != null && !nodeList.isEmpty());

        return null;
    }
}
