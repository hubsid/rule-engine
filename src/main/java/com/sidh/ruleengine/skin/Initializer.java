package com.sidh.ruleengine.skin;

import com.sidh.ruleengine.core.model.InsurerSelector;
import com.sidh.ruleengine.skin.model.Director;
import com.sidh.ruleengine.skin.model.InsurerSelectionDT;

import java.util.List;

public class Initializer {
    public static void main(String[] args) {
        List<InsurerSelectionDT> insurerSelectionDTS = null;

        final InsurerSelector insurerSelector = new InsurerSelector();
        final Director director = new Director("name", 21, 30, null);
        insurerSelectionDTS.stream()
                .filter(d -> insurerSelector.testCondition(director, d))
                .findFirst()
                .ifPresent(d -> insurerSelector.execute(director, d));
    }
}
