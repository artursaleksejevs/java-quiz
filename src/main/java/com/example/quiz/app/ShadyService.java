package com.example.quiz.app;

import lombok.Builder;

import java.util.List;

@Builder
public class ShadyService {
    public String getData() {
        return "Whatever";
    }
    public List<String> getList() { return null; };
}
