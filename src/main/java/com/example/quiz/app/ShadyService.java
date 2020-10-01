package com.example.quiz.app;

import com.example.quiz.app.model.Debtor;
import lombok.Builder;

import java.util.List;

@Builder
public class ShadyService {
    public String getData() {
        return "Whatever";
    }
    public List<String> getList() { return null; };
    public List<Debtor> getDebtors() {
        Debtor d01 = new Debtor ("John Kristopherson", 80, "EUR", 22);
        Debtor d02 = new Debtor ("Stephan Anderson ", 1000, "SEK", 25);
        Debtor d03 = new Debtor ("Pavel Glovacky", 80, "EUR", 54);
        Debtor d04 = new Debtor ("Patricia Swan", 80, "EUR", 18);
        Debtor d05 = new Debtor ("Roselin Leimgruber", 99, "CHF", 34);
        Debtor d06 = new Debtor ("Johnana Kristopherson", 80, "EUR", 65);
        Debtor d07 = new Debtor ("Kunz Angelina", 180, "CHF", 33);
        Debtor d08 = new Debtor ("Novakovic Stanko", 133, "EUR", 54);
        Debtor d09 = new Debtor ("Hassan Ahmed", 810, "EUR", 21);
        Debtor d10 = new Debtor ("Zivanovic Ivanka", 180, "SEK", 19);
        Debtor d11 = new Debtor ("Barhoumi Nadia", 1580, "EUR", 33);
        Debtor d12 = new Debtor ("Miladnovic Vesna", 10, "EUR", 65);
        Debtor d13 = new Debtor ("Sidibe Youssouf", 280, "USD", 43);
        Debtor d14 = new Debtor ("Schwierz Thomas", 180, "USD", 21);
        Debtor d15 = new Debtor ("Pavel Sidorov", 8210, "RUB", 34);
        Debtor d16 = new Debtor ("Aleksandr Sevcenko", 1810, "RUB",35);
        Debtor d17 = new Debtor ("Gleb Tremzin", 2180, "RUB", 54);
        Debtor d18 = new Debtor ("Natasha Sasnovskaja", 1180, "RUB", 29);
        //Debtor d19 = new Debtor ("Pavel Mihailvo", null, "RUB", 29);
        return List.of(d01, d02, d03, d04, d05, d06, d07, d08, d09, d10, d11, d12, d13, d14, d15, d16, d17, d18);
    }

}
