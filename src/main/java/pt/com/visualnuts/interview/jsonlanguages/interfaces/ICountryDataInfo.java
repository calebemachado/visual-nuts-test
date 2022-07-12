package pt.com.visualnuts.interview.jsonlanguages.interfaces;

import pt.com.visualnuts.interview.jsonlanguages.model.CountryVO;

import java.util.List;
import java.util.Map;

public interface ICountryDataInfo {

    Long countriesInTheWorld(List<CountryVO> countries);

    String countryWithMostOfficialLanguagesByLanguage(String language, List<CountryVO> countries);

    Map<String, Long> countOfficialLanguagesByCountries(List<CountryVO> countries);

    List<String> countryWithHighestNumberOfficialLanguages(List<CountryVO> countries);

    List<String> mostCommonOfficialLanguages(List<CountryVO> countries);
}
