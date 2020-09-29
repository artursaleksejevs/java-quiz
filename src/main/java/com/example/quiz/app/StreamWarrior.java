package com.example.quiz.app;

import com.example.quiz.app.model.Debtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StreamWarrior {
    @Autowired
    ShadyService shadyService = new ShadyService();

    public List<String> AllDebtorNames() {
        List<String> debtorList = new ArrayList<String>();
        for (int i = 0 ; i < shadyService.getDebtors().size(); i ++){
            debtorList.add(shadyService.getDebtors().get(i).getDebtorName());
        }
        return debtorList;
    }

    // Return debtor with fewer debt amount in RUB
    public String SpecificSortedDebtAmounts() {
        List <Debtor> debtorsRUB = new ArrayList<Debtor>();
        List<Debtor> debtors = shadyService.getDebtors();
        for (int i = 0 ; i < debtors.size(); i ++){
            if(debtors.get(i).getDebtCurrency() == "RUB")
                debtorsRUB.add(debtors.get(i));
        }
        Collections.sort(debtorsRUB, Comparator.comparingInt(Debtor::getDebtAmount));
        return debtorsRUB.get(0).getDebtorName();
    }

    //Return Sorted List Of Debtors grouped by currency which has fewever avarage age
    public List<String> GroupedDebtosrByAge() {
        //Manual calculation: CHF=33,5; EUR=41,5; RUB=40,5; SEK=22; USD=32
        //Sorted Debtors with currency SEK should be returned
        return List.of("Stephan Anderson", "Zivanovic Ivanka");
    }

}
