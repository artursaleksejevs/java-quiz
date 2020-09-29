package com.example.quiz.app.model;

public class Debtor {
    private String debtorName;
    private int debtAmount;
    private String debtCurrency;
    private int debtorAge;

    public Debtor() {
    }

    public Debtor(String name, int debt, String currency, int age) {
        this.debtorName = name;
        this.debtAmount = debt;
        this.debtCurrency = currency;
        this.debtorAge = age;

    }

    public String getDebtorName() {
        return this.debtorName;
    }

    public int getDebtAmount() {
        return this.debtAmount;
    }

    public String getDebtCurrency() {
        return this.debtCurrency;
    }

    public int getAge() {
        return this.debtorAge;
    }

}

