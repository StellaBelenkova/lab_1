package com.lab.equestrian;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonImporter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Competition> importCompetitionsFromFile(String filename) throws IOException {
        Competition[] competitions = objectMapper.readValue(new File(filename), Competition[].class);
        return Arrays.asList(competitions);
    }

    public static List<Horse> importHorsesFromFile(String filename) throws IOException {
        Horse[] horses = objectMapper.readValue(new File(filename), Horse[].class);
        return Arrays.asList(horses);
    }
}
