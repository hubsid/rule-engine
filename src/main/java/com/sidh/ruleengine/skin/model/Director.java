package com.sidh.ruleengine.skin.model;

public class Director {
    private String name;
    private int age;
    private int tenure;
    private Insurer insurer;

    public Director() {

    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", tenure=" + tenure +
                ", insurer=" + insurer +
                '}';
    }

    public Director(String name, int age, int tenure, Insurer insurer) {
        this.name = name;
        this.age = age;
        this.tenure = tenure;
        this.insurer = insurer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Insurer getInsurer() {
        return insurer;
    }

    public void setInsurer(Insurer insurer) {
        this.insurer = insurer;
    }
}
