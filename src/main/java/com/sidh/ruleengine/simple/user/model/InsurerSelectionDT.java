package com.sidh.ruleengine.simple.user.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;

public class InsurerSelectionDT {
    @CsvBindByName
    private int ageHigh;
    @CsvBindByName
    private int ageLow;
    @CsvBindByName
    private int tenureHigh;
    @CsvCustomBindByName(converter = StringToEnumConvertors.PRODUCT.class)
    private ProductType productType;
    @CsvCustomBindByName(converter = StringToEnumConvertors.INSURER.class)
    private Insurer insurer;

    public InsurerSelectionDT() {
    }

    public InsurerSelectionDT(int ageHigh, int ageLow, int tenureHigh, ProductType productType, Insurer insurer) {
        this.ageHigh = ageHigh;
        this.ageLow = ageLow;
        this.tenureHigh = tenureHigh;
        this.productType = productType;
        this.insurer = insurer;
    }

    public int getAgeHigh() {
        return ageHigh;
    }

    public void setAgeHigh(int ageHigh) {
        this.ageHigh = ageHigh;
    }

    public int getAgeLow() {
        return ageLow;
    }

    public void setAgeLow(int ageLow) {
        this.ageLow = ageLow;
    }

    public int getTenureHigh() {
        return tenureHigh;
    }

    public void setTenureHigh(int tenureHigh) {
        this.tenureHigh = tenureHigh;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Insurer getInsurer() {
        return insurer;
    }

    public void setInsurer(Insurer insurer) {
        this.insurer = insurer;
    }

    @Override
    public String toString() {
        return "InsurerSelectionDT{" +
                "ageHigh=" + ageHigh +
                ", ageLow=" + ageLow +
                ", tenureHigh=" + tenureHigh +
                ", productType=" + productType +
                ", insurer=" + insurer +
                '}';
    }
}
