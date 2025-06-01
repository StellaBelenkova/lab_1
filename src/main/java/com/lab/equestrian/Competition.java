package com.lab.equestrian;

import java.time.LocalDate;
import java.util.Map;

public class Competition {

    private String name;
    private LocalDate date;
    private Map<String, Double> results;
    private Horse winner;

    public Competition() {
        // порожній конструктор потрібен для Jackson
    }

    public Competition(String name, LocalDate date, Map<String, Double> results, Horse winner) {
        this.name = name;
        this.date = date;
        this.results = results;
        this.winner = winner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Map<String, Double> getResults() {
        return results;
    }

    public void setResults(Map<String, Double> results) {
        this.results = results;
    }

    public Horse getWinner() {
        return winner;
    }

    public void setWinner(Horse winner) {
        this.winner = winner;
    }

    // Додати результат у змагання
    public void addResult(String horseName, double score) {
        results.put(horseName, score);
    }
}
