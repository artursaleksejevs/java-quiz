package com.example.quiz.app;

import com.example.quiz.app.model.Debtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StreamWarrior {
    @Autowired
    ShadyService shadyService = new ShadyService();

    public List<String> AllDebtorNames() {

        return shadyService.getDebtors().stream()
                .map(Debtor::getDebtorName)
                .collect(Collectors.toList());

//        List<String> debtorList = new ArrayList<String>();
//        for (int i = 0 ; i < shadyService.getDebtors().size(); i ++){
//            debtorList.add(shadyService.getDebtors().get(i).getDebtorName());
//        }
//        return debtorList;
    }

    // Return debtor with fewer debt amount in RUB
    public String SpecificSortedDebtAmounts(String currency) {
//        List<Debtor> debtorsRUB = new ArrayList<Debtor>();
//        List<Debtor> debtors = shadyService.getDebtors();
//        for (int i = 0; i < debtors.size(); i++) {
//            if (debtors.get(i).getDebtCurrency() == "RUB")
//                debtorsRUB.add(debtors.get(i));
//        }
//        Collections.sort(debtorsRUB, Comparator.comparingInt(Debtor::getDebtAmount));
//        return debtorsRUB.get(0).getDebtorName();
        return shadyService.getDebtors().stream()
                .filter(d -> currency.equals(d.getDebtCurrency()))
                .min((a, b) -> a.getDebtAmount() - b.getDebtAmount())
                .orElseThrow(() -> new RuntimeException("Wrong currency"))
                .getDebtorName();

    }

    //Return Sorted List Of Debtors grouped by currency which has fewever avarage age
    public List<String> GroupedDebtosrByAgeSpaggetti() {
        //Manual calculation: CHF=33,5; EUR=41,5; RUB=40,5; SEK=22; USD=32
        //Sorted Debtors with currency SEK should be returned
        //return List.of("Stephan Anderson", "Zivanovic Ivanka");

        Map <String, List<Debtor>> groupedList =  shadyService.getDebtors().stream()
                .collect(Collectors.groupingBy(Debtor::getDebtCurrency));

        SortedMap<Double, String> newMap = new TreeMap<>();

        groupedList.entrySet().stream()
                 .forEach(e -> newMap.put(e.getValue().stream()
                                                            .mapToInt(d -> d.getAge())
                                                            .average().orElse(-1),
                                           e.getKey()
                 ));

        return shadyService.getDebtors().stream()
                .filter(d -> newMap.values().iterator().next().equals(d.getDebtCurrency()))
                .map(d -> d.getDebtorName())
                .collect(Collectors.toList());

    }

    public List<String> GroupedDebtosrByAge() {

        Map <String, Double> groupedList =  shadyService.getDebtors().stream()
                .collect(Collectors.groupingBy(Debtor::getDebtCurrency,
                                               Collectors.averagingDouble(Debtor::getAge)));
        return  shadyService.getDebtors().stream()
                .filter(d ->  groupedList.entrySet().stream()
                                .min(Comparator.comparingDouble(Map.Entry::getValue))
                                .map(m -> m.getKey()).get()
                        .equals(d.getDebtCurrency()))
                .map(d -> d.getDebtorName())
                .collect(Collectors.toList());
    }

}

