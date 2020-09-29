package com.example.quiz.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Warrior {
    @Autowired
    ShadyService shadyService;

    public String passWhatever() {
        return shadyService.getData();
    }

    public String passUpper() {
        return Optional
                .ofNullable(shadyService.getData())
                .filter(s -> !s.isEmpty())
                .orElseThrow(() -> new RuntimeException("Empty"))
                .toUpperCase();

//       var result = shadyService.getData();
//       if (result == null) throw new RuntimeException("Empty");
//       else if (result == "") throw new RuntimeException("Empty");
//       else return result.toUpperCase();

    }

    public String passDefault() {
        return Optional
                .ofNullable(shadyService.getData())
                .filter(s -> !s.isEmpty())
                .orElse("Default");

//        var result = shadyService.getData();
//        if (result == null) result = "Default";
//        else if (result == "") result = "Default";
//        return result;
    }

    public Boolean exists() {

        return Optional
                .ofNullable(shadyService.getData())
                .isPresent();

//        var result = shadyService.getData();
//        if (result == null) return false;
//        return true;
    }

    public Boolean notEmpty() {

        return Optional
                .ofNullable(shadyService.getData())
                .filter(s -> !s.isEmpty())
                .isPresent();

//        var result = shadyService.getData();
//        if (result == null) return false;
//        else if (result == "") return false;
//        return true;
    }

    public Boolean filterList(String param) {

        return Optional
                .ofNullable(shadyService.getData())
                .filter(s -> !s.isEmpty())
                .isPresent();

//        var result = shadyService.getList();
//
//        if (result == null) throw new RuntimeException("Empty");
//        if (result.size() == 0) throw new RuntimeException("Empty");
//
//        for (int i = 0; i < result.size(); i++) {
//            if (result.get(i).equals(param)) return true;
//        }
//        return false;
    }

}
