package com.lab.equestrian;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EquestrianManager manager = new EquestrianManager();

        while (true) {
            System.out.println("\n=== Equestrian Manager ===");
            System.out.println("1. Додати коня");
            System.out.println("2. Провести змагання");
            System.out.println("3. Показати всіх коней");
            System.out.println("4. Показати всі змагання");
            System.out.println("5. Вийти");
            System.out.print("Виберіть опцію: ");

            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.print("Ім'я коня: ");
                    String name = scanner.nextLine();
                    System.out.print("Порода: ");
                    String breed = scanner.nextLine();
                    System.out.print("Вік: ");
                    int age = Integer.parseInt(scanner.nextLine());

                    Horse horse = new Horse(name, breed, age);
                    manager.addHorse(horse);
                    System.out.println("Коня додано!");
                    break;

                case "2":
                    System.out.print("Назва змагання: ");
                    String compName = scanner.nextLine();
                    LocalDate date = LocalDate.now();
                    Map<String, Double> results = new HashMap<>();

                    System.out.println("Введіть результати (ім’я коня і оцінка), 'stop' для завершення:");
                    while (true) {
                        System.out.print("Ім'я коня: ");
                        String horseName = scanner.nextLine();
                        if (horseName.equalsIgnoreCase("stop")) break;

                        Horse h = manager.getHorseByName(horseName);
                        if (h == null) {
                            System.out.println("Коня не знайдено.");
                            continue;
                        }

                        System.out.print("Оцінка: ");
                        double score = Double.parseDouble(scanner.nextLine());
                        results.put(horseName, score);
                    }

                    if (!results.isEmpty()) {
                        String winnerName = Collections.max(results.entrySet(), Map.Entry.comparingByValue()).getKey();
                        Horse winner = manager.getHorseByName(winnerName);

                        Competition comp = new Competition(compName, date, results, winner);
                        manager.addCompetition(comp);
                        System.out.println("Змагання додано!");
                    } else {
                        System.out.println("Змагання скасовано — не було результатів.");
                    }
                    break;

                case "3":
                    System.out.println("Список коней:");
                    for (Horse h : manager.getHorses()) {
                        System.out.println(h);
                    }
                    break;

                case "4":
                    System.out.println("Список змагань:");
                    for (Competition c : manager.getCompetitions()) {
                        System.out.println("Змагання: " + c.getName());
                        System.out.println("Дата: " + c.getDate());
                        System.out.println("Результати: " + c.getResults());
                        System.out.println("Переможець: " + c.getWinner());
                        System.out.println("----------------------");
                    }
                    break;

                case "5":
                    System.out.println("Вихід...");
                    return;

                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
            }
        }
    }
}
