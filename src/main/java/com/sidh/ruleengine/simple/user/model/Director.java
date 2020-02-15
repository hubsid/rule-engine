package com.sidh.ruleengine.simple.user.model;

public class Director {
    private int age;
    private int tenure;
    private ProductType productType;
    private Insurer insurer;

    public Director(int age, int tenure, ProductType productType, Insurer insurer) {
        this.age = age;
        this.tenure = tenure;
        this.productType = productType;
        this.insurer = insurer;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
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
        return "Director{" +
                "age=" + age +
                ", tenure=" + tenure +
                ", productType=" + productType +
                ", insurer=" + insurer +
                '}';
    }
}
