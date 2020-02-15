package com.sidh.ruleengine.simple.user.model;

import com.opencsv.bean.AbstractBeanField;

public class StringToEnumConvertors {
    public static class INSURER extends AbstractBeanField {
        @Override
        protected Insurer convert(String s) {
            return Insurer.valueOf(s);
        }
    }
    public static final class PRODUCT extends AbstractBeanField {
        @Override
        protected ProductType convert(String s) {
            return ProductType.valueOf(s);
        }
    }
}