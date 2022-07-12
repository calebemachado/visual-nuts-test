package pt.com.visualnuts.interview.jsonlanguages.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Objects;

public class CountryVO {
    @JsonProperty("country")
    public String country;

    @JsonProperty("languages")
    public ArrayList<String> languages;

    @Override
    public String toString() {
        return "JSONRoot{" +
                "country='" + country + '\'' +
                ", languages=" + languages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryVO countryVO = (CountryVO) o;

        return Objects.equals(country, countryVO.country);
    }

    @Override
    public int hashCode() {
        return country != null ? country.hashCode() : 0;
    }
}
