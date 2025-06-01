package com.lab.equestrian;

import java.util.ArrayList;
import java.util.List;

public class EquestrianManager {
    private List<Horse> horses;
    private List<Competition> competitions;

    public EquestrianManager() {
        this.horses = new ArrayList<>();
        this.competitions = new ArrayList<>();
    }

    public void addHorse(Horse horse) {
        horses.add(horse);
    }

    public Horse getHorseByName(String name) {
        for (Horse horse : horses) {
            if (horse.getName().equalsIgnoreCase(name)) {
                return horse;
            }
        }
        return null;
    }

    public void addCompetition(Competition competition) {
        competitions.add(competition);
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void printAllCompetitions() {
        if (competitions.isEmpty()) {
            System.out.println("Немає змагань.");
            return;
        }
        for (Competition comp : competitions) {
            System.out.println("Змагання: " + comp.getName());
            System.out.println("Дата: " + comp.getDate());
            System.out.println("Результати: " + comp.getResults());
            Horse winner = comp.getWinner();
            if (winner != null) {
                System.out.println("Переможець: " + winner.getName() + " (" + winner.getBreed() + ", " + winner.getAge() + " років)");
            } else {
                System.out.println("Переможець: ще не визначено.");
            }
            System.out.println("-----");
        }
    }
}
