package pt.com.visualnuts.interview.jsonlanguages;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pt.com.visualnuts.interview.jsonlanguages.model.CountryVO;
import pt.com.visualnuts.interview.jsonlanguages.util.FileResourceUtils;

import java.io.InputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CountryDataInfoTest {

    static List<CountryVO> countries = new ArrayList<>();
    static List<CountryVO> countriesNonDistinct = new ArrayList<>();

    @BeforeAll
    static void setUp() throws JsonProcessingException {
        String fileName = "countries.json";
        var app = new FileResourceUtils();
        InputStream is = app.getFileFromResourceAsStream(fileName);
        String jsonString = app.getJSONAsString(is);

        var mapper = new ObjectMapper();
        countries = mapper.readValue(jsonString, new TypeReference<>() {
        });

        fileName = "countries_non_distinct.json";
        is = app.getFileFromResourceAsStream(fileName);
        jsonString = app.getJSONAsString(is);

        mapper = new ObjectMapper();
        countriesNonDistinct = mapper.readValue(jsonString, new TypeReference<>() {
        });
    }

    @Test
    void shouldReturnZeroWhenEmptyList() {
        CountryDataInfo countryDataInfo = new CountryDataInfo();

        assertEquals(0L, countryDataInfo.countriesInTheWorld(Collections.emptyList()));
    }

    @Test
    void shouldReturnZeroWhenNull() {
        CountryDataInfo countryDataInfo = new CountryDataInfo();

        assertEquals(0L, countryDataInfo.countriesInTheWorld(null));
    }

    @Test
    void shouldReturnDistinctCountries() {
        CountryDataInfo countryDataInfo = new CountryDataInfo();

        assertEquals(5, countryDataInfo.countriesInTheWorld(countriesNonDistinct));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenListIsNull() {
        CountryDataInfo countryDataInfo = new CountryDataInfo();
        assertThrows(IllegalArgumentException.class, () -> countryDataInfo.countryWithMostOfficialLanguagesByLanguage("DE", null));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenListIsEmpty() {
        CountryDataInfo countryDataInfo = new CountryDataInfo();
        assertThrows(IllegalArgumentException.class, () -> countryDataInfo.countryWithMostOfficialLanguagesByLanguage("DE", Collections.emptyList()));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenLanguageIsEmpty() {
        CountryDataInfo countryDataInfo = new CountryDataInfo();
        assertThrows(IllegalArgumentException.class, () -> countryDataInfo.countryWithMostOfficialLanguagesByLanguage("", countries));
    }

    @Test
    void shouldThrowNoSuchElementExceptionWhenLanguageIsNotFound() {
        CountryDataInfo countryDataInfo = new CountryDataInfo();
        assertThrows(NoSuchElementException.class, () -> countryDataInfo.countryWithMostOfficialLanguagesByLanguage("BR", countries));
    }

    @Test
    void shouldReturnCountryEN() {
        CountryDataInfo countryDataInfo = new CountryDataInfo();
        assertEquals("US", countryDataInfo.countryWithMostOfficialLanguagesByLanguage("EN", countries));
        assertEquals("US", countryDataInfo.countryWithMostOfficialLanguagesByLanguage("en", countries));
    }

    @Test
    void shouldReturnCorrectValuesWhenCountingOfficialLanguages() {
        HashMap<String, Long> expected = new HashMap<>();
        expected.put("DE", 1L);
        expected.put("BE", 3L);
        expected.put("US", 1L);
        expected.put("NL", 2L);
        expected.put("ES", 1L);

        CountryDataInfo countryDataInfo = new CountryDataInfo();
        assertEquals(expected, countryDataInfo.countOfficialLanguagesByCountries(countries));
    }

    @Test
    void shouldReturnOnlyBENoCountingRepeatedLanguages() {
        CountryDataInfo countryDataInfo = new CountryDataInfo();
        assertEquals(List.of("BE"), countryDataInfo.countryWithHighestNumberOfficialLanguages(countries));
    }

    @Test
    void shouldNotCountRepeatedLanguagesOnCountry() {
        //Ignoring fy language repeated on NL Country
        CountryDataInfo countryDataInfo = new CountryDataInfo();
        assertEquals(List.of("DE", "NL"), countryDataInfo.mostCommonOfficialLanguages(countries));
    }
}