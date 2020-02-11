package com.sidh.ruleengine.core.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ConditionNode<F, V, R> {
    private String methodname;
    private Operator operator;
    private V rhs;
    private List<ConditionNode<F, R, V>> childNodes;

    public ConditionNode(String methodname, Operator operator, V rhs) {
        this.methodname = methodname;
        this.operator = operator;
        this.rhs = rhs;
    }

    public boolean test(F fact) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = fact.getClass().getMethod(methodname);
        Object lhs = method.invoke(fact);

        if(operator == Operator.LESSTHAN) {
            return ((Integer)lhs).compareTo((Integer) rhs) < 0;
        }
        else if(operator == Operator.GREATERTHAN) {
            return ((Integer)lhs).compareTo((Integer)rhs) > 0;
        }
        else if(operator == Operator.EQUALS) {
            if(lhs instanceof Integer)
                return ((Integer)lhs).compareTo((Integer)rhs) == 0;
            else if(lhs instanceof String)
                return lhs.equals(rhs);
        }
        else if(operator == Operator.EQUALSIGNORECASE) {
            return ((String)lhs).equalsIgnoreCase((String)rhs);
        }
        else if(operator == Operator.CONTAINS) {
            return ((String)lhs).contains((String)rhs);
        }
        else if(operator == Operator.STARTSWITH) {
            return ((String)lhs).startsWith((String)rhs);
        }
        else if(operator == Operator.ENDSWITH) {
            return ((String)lhs).endsWith((String)rhs);
        }
        return false;
    }

    public ConditionNode<F, R, V> add(ConditionNode<F, R, V> node) {
        Optional<ConditionNode<F, R, V>> matchingNode = childNodes.stream().filter(n -> n.equals(node)).findFirst();
        if(matchingNode.isPresent())
            return matchingNode.get();
        childNodes.add(node);
        return node;
    }

    public String getMethodname() {
        return methodname;
    }

    public void setMethodname(String methodname) {
        this.methodname = methodname;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public V getRhs() {
        return rhs;
    }

    public void setRhs(V rhs) {
        this.rhs = rhs;
    }

    public List<ConditionNode<F, R, V>> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(List<ConditionNode<F, R, V>> childNodes) {
        this.childNodes = childNodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConditionNode<?, ?, ?> that = (ConditionNode<?, ?, ?>) o;
        return methodname.equals(that.methodname) &&
                operator == that.operator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(methodname, operator, rhs);
    }
}