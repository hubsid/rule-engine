package com.sidh.ruleengine.simple.user;

import com.opencsv.bean.CsvToBeanBuilder;
import com.sidh.ruleengine.simple.user.model.Director;
import com.sidh.ruleengine.simple.user.model.InsurerSelectionDT;
import com.sidh.ruleengine.simple.user.model.ProductType;
import com.sidh.ruleengine.simple.user.service.InsurerSelectorRuleEngine;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String resourcepath = "/home/sidharth/coding/rule engine simple/src/main/resources/insurer-selector.csv";

        List<InsurerSelectionDT> insurerSelectionDTS = new CsvToBeanBuilder<InsurerSelectionDT>(new FileReader(resourcepath))
                .withType(InsurerSelectionDT.class)
                .build()
                .parse();

        System.out.println(insurerSelectionDTS);

        Director director = new Director(23, 30, ProductType.CREDIT, null);

        InsurerSelectorRuleEngine ruleEngine = new InsurerSelectorRuleEngine(insurerSelectionDTS);
        ruleEngine.execute(director);

        System.out.println(director.getInsurer());
    }
}
