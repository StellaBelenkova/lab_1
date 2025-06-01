package com.lab.equestrian;

import java.util.Objects;

public class Horse {
    private String name;
    private String breed;
    private int age;

    public Horse() {}

    public Horse(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() { return name; }
    public String getBreed() { return breed; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setBreed(String breed) { this.breed = breed; }
    public void setAge(int age) { this.age = age; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Horse)) return false;
        Horse horse = (Horse) o;
        return Objects.equals(name, horse.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + " (" + breed + ", " + age + " років)";
    }
}
