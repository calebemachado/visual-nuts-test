package pt.com.visualnuts.interview;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pt.com.visualnuts.interview.integerchecker.VisualNutsIntegerChecker;
import pt.com.visualnuts.interview.jsonlanguages.CountryDataInfo;
import pt.com.visualnuts.interview.jsonlanguages.util.FileResourceUtils;
import pt.com.visualnuts.interview.jsonlanguages.model.CountryVO;

import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Exercise 1 Resolution -----------\n");

        VisualNutsIntegerChecker checker = new VisualNutsIntegerChecker(100);
        List<String> checkerValues = checker.checkValues();
        System.out.println(checkerValues);
        System.out.println("\n\nExercise 2 Resolution -----------");

        String fileName = "countries.json";
        var app = new FileResourceUtils();
        InputStream is = app.getFileFromResourceAsStream(fileName);
        String jsonString = app.getJSONAsString(is);

        var mapper = new ObjectMapper();
        try {
            List<CountryVO> countries = mapper.readValue(jsonString, new TypeReference<>() {
            });
            CountryDataInfo countryDataInfo = new CountryDataInfo();

            System.out.println("Write a function in Java that: ");
            System.out.println("\n1. Returns the number of countries in the world");
            System.out.println(countryDataInfo.countriesInTheWorld(countries));

            System.out.println("\n2. Finds the country with the most official languages, where they officially speak German (de).");
            System.out.println(countryDataInfo.countryWithMostOfficialLanguagesByLanguage("de", countries));

            System.out.println("\n3. That counts all the official languages spoken in the listed countries");
            System.out.println(countryDataInfo.countOfficialLanguagesByCountries(countries));

            System.out.println("\n4. To find the country with the highest number of official languages");
            System.out.println(countryDataInfo.countryWithHighestNumberOfficialLanguages(countries));

            System.out.println("\n5. To find the most common official language(s), of all countries");
            System.out.println(countryDataInfo.mostCommonOfficialLanguages(countries));

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}