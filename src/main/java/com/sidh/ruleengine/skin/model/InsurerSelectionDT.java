package com.sidh.ruleengine.skin.model;

public class InsurerSelectionDT {
    private int ageLow;
    private int ageHigh;
    private int tenureLow;
    private int tenureHigh;
    private Insurer insurer;

    public InsurerSelectionDT(int ageLow, int ageHigh, int tenureLow, int tenureHigh, Insurer insurer) {
        this.ageLow = ageLow;
        this.ageHigh = ageHigh;
        this.tenureLow = tenureLow;
        this.tenureHigh = tenureHigh;
        this.insurer = insurer;
    }

    public int getAgeLow() {
        return ageLow;
    }

    public void setAgeLow(int ageLow) {
        this.ageLow = ageLow;
    }

    public int getAgeHigh() {
        return ageHigh;
    }

    public void setAgeHigh(int ageHigh) {
        this.ageHigh = ageHigh;
    }

    public int getTenureLow() {
        return tenureLow;
    }

    public void setTenureLow(int tenureLow) {
        this.tenureLow = tenureLow;
    }

    public int getTenureHigh() {
        return tenureHigh;
    }

    public void setTenureHigh(int tenureHigh) {
        this.tenureHigh = tenureHigh;
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
                "ageLow=" + ageLow +
                ", ageHigh=" + ageHigh +
                ", tenureLow=" + tenureLow +
                ", tenureHigh=" + tenureHigh +
                ", insurer=" + insurer +
                '}';
    }
}
