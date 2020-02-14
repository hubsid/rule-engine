package com.sidh.ruleengine.skin;

import com.sidh.ruleengine.core.model.ConditionNode;
import com.sidh.ruleengine.core.model.Operator;

import java.util.function.Function;

public class ConditionLeafNode<F, R, V> extends ConditionNode<F, R, V> {

    private Function<F, R> onMatchAction;

    public ConditionLeafNode(String methodname, Operator operator, V rhs, Function<F, R> onMatchAction) {
        super(methodname, operator, rhs);
        this.onMatchAction = onMatchAction;
    }

    public R execute(F fact) {
        return onMatchAction.apply(fact);
    }
}
