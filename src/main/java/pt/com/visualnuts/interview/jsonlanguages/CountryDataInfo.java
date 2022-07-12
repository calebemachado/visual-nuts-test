package pt.com.visualnuts.interview.jsonlanguages;

import pt.com.visualnuts.interview.jsonlanguages.interfaces.ICountryDataInfo;
import pt.com.visualnuts.interview.jsonlanguages.model.CountryVO;

import java.util.*;

public class CountryDataInfo implements ICountryDataInfo {

    @Override
    public Long countriesInTheWorld(List<CountryVO> countries) {
        if (countries == null || countries.isEmpty()) {
            return 0L;
        }

        return countries.stream().distinct().count();
    }

    @Override
    public String countryWithMostOfficialLanguagesByLanguage(String language, List<CountryVO> countries) {
        validateEmptyOrNullList(countries);

        if (language.isEmpty()) {
            throw new IllegalArgumentException("Country language is empty");
        }

        Map<String, Integer> filtered = new HashMap<>();
        for (CountryVO country : countries) {

            if (country.languages.contains(language.toLowerCase())) {
                filtered.put(country.country.toUpperCase(), country.languages.size());
            }
        }

        if (filtered.isEmpty()) {
            throw new NoSuchElementException("Language not found on list provided");
        }

        return Collections.max(filtered.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    @Override
    public Map<String, Long> countOfficialLanguagesByCountries(List<CountryVO> countries) {
        validateEmptyOrNullList(countries);

        var count = new HashMap<String, Long>();
        countries.forEach(c -> count.put(c.country, c.languages.stream().distinct().count()));

        return count;
    }

    @Override
    public List<String> countryWithHighestNumberOfficialLanguages(List<CountryVO> countries) {
        validateEmptyOrNullList(countries);

        Map<String, Long> countriesWithLanguages = new HashMap<>();
        countries.forEach(c -> countriesWithLanguages.put(c.country, c.languages.stream().distinct().count()));

        var maxOccurrences = new ArrayList<String>();

        long maxValueInMap = (Collections.max(countriesWithLanguages.values()));
        for (Map.Entry<String, Long> entry : countriesWithLanguages.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                maxOccurrences.add(entry.getKey());
            }
        }

        return maxOccurrences;
    }

    @Override
    public List<String> mostCommonOfficialLanguages(List<CountryVO> countries) {
        validateEmptyOrNullList(countries);

        // Language, Count
        Map<String, Integer> languagesAndOccurrences = new HashMap<>();
        for (CountryVO country : countries) {

            country.languages.stream().distinct().forEach(language -> {

                Integer value = languagesAndOccurrences.get(language.toUpperCase());
                if (value != null) {
                    languagesAndOccurrences.put(language.toUpperCase(), ++value);
                } else {
                    languagesAndOccurrences.put(language.toUpperCase(), 1);
                }
            });
        }

        var maxOccurrences = new ArrayList<String>();

        int maxValueInMap = (Collections.max(languagesAndOccurrences.values()));
        for (Map.Entry<String, Integer> entry : languagesAndOccurrences.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                maxOccurrences.add(entry.getKey());
            }
        }

        return maxOccurrences;
    }

    private void validateEmptyOrNullList(List<CountryVO> countries) {
        if (countries == null || countries.isEmpty()) {
            throw new IllegalArgumentException("Country list is empty or null");
        }
    }

}
