package com.quique.api.proxy;

import com.quique.api.dto.PeopleDto;
import com.quique.api.dto.PlanetDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author QUIQUE
 */
@Component
public class SwapiWSImpl implements SwapiWS {

    Logger logger = LoggerFactory.getLogger(SwapiWSImpl.class);

    @Override
    public List<PlanetDto> getPlanets(String params, String page) throws Exception {

        logger.info("::::::::::::::::::: START getPlanets :::::::::::::::::::::");

        List<PlanetDto> listFinal = new ArrayList<>();

        for (int i = 1; i <= (Optional.ofNullable(page).isPresent() && !page.equals("") ? Integer.parseInt(page) : 1); i++) {

            String baseUrl = "https://swapi.dev/api/planets/" + (Optional.ofNullable(params).orElse(""));

            UriComponentsBuilder builderUrl = UriComponentsBuilder.fromUriString(baseUrl)
                    .queryParam("format", "json")
                    .queryParam("page", (Optional.ofNullable(page).isPresent() ? i : ""));

            RestTemplate restTemplate = new RestTemplate();
            Map<String, Object> getRest = restTemplate.getForObject(builderUrl.toUriString(), Map.class);

            if (Optional.ofNullable(getRest).isPresent()) {

                List<?> list = new ArrayList<>();

                Object obj = Optional.ofNullable(getRest.get("results")).isPresent() ? getRest.get("results") : getRest;

                if (obj.getClass().isArray()) {
                    list = Arrays.asList((LinkedHashMap[]) obj);
                } else if (obj instanceof Collection) {
                    list = new ArrayList<>((Collection<?>) obj);
                } else {
                    logger.info("Unexpected object type: " + obj.getClass());

                    PlanetDto temp = new PlanetDto();
                    temp.setClimate((String) getRest.get("climate"));
                    temp.setDiameter((String) getRest.get("diameter"));
                    temp.setGravity((String) getRest.get("gravity"));
                    temp.setName((String) getRest.get("name"));
                    temp.setPopulation((String) getRest.get("population"));
                    //temp.setResidents((String) lhm.get("population"));
                    temp.setTerrain((String) getRest.get("terrain"));
                    temp.setUrl((String) getRest.get("url"));
                    listFinal.add(temp);
                }

                list.stream().map((item) -> (LinkedHashMap<?, ?>) item).map((lhm) -> {
                    PlanetDto temp = new PlanetDto();
                    temp.setClimate((String) lhm.get("climate"));
                    temp.setDiameter((String) lhm.get("diameter"));
                    temp.setGravity((String) lhm.get("gravity"));
                    temp.setName((String) lhm.get("name"));
                    temp.setPopulation((String) lhm.get("population"));
                    //temp.setResidents((String) lhm.get("population"));
                    temp.setTerrain((String) lhm.get("terrain"));
                    temp.setUrl((String) lhm.get("url"));
                    return temp;
                }).forEachOrdered((temp) -> {
                    listFinal.add(temp);
                });

            } else {
                throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
            }
        }

        logger.info("::::::::::::::::::::: END getPlanets :::::::::::::::::::::::");

        return listFinal;

    }

    @Override
    public List<PeopleDto> getPeoples(String params, String page) throws Exception {

        logger.info("::::::::::::::::::: START getPeoples :::::::::::::::::::::");

        List<PeopleDto> listFinal = new ArrayList<>();

        for (int i = 1; i <= (Optional.ofNullable(page).isPresent() && !page.equals("") ? Integer.parseInt(page) : 1); i++) {

            String baseUrl = "https://swapi.dev/api/people/" + (Optional.ofNullable(params).orElse(""));

            UriComponentsBuilder builderUrl = UriComponentsBuilder.fromUriString(baseUrl)
                    .queryParam("format", "json")
                    .queryParam("page", (Optional.ofNullable(page).isPresent() ? i : ""));

            RestTemplate restTemplate = new RestTemplate();
            Map<String, Object> getRest = restTemplate.getForObject(builderUrl.toUriString(), Map.class);

            if (Optional.ofNullable(getRest).isPresent()) {

                List<?> list = new ArrayList<>();

                Object obj = Optional.ofNullable(getRest.get("results")).isPresent() ? getRest.get("results") : getRest;

                if (obj.getClass().isArray()) {
                    list = Arrays.asList((LinkedHashMap[]) obj);
                } else if (obj instanceof Collection) {
                    list = new ArrayList<>((Collection<?>) obj);
                } else {
                    logger.info("Unexpected object type: " + obj.getClass());

                    PeopleDto temp = new PeopleDto();
                    temp.setName((String) getRest.get("name"));
                    temp.setBirthYear((String) getRest.get("birth_year"));
                    temp.setEyeColor((String) getRest.get("eye_color"));
                    temp.setGender((String) getRest.get("gender"));
                    temp.setHairColor((String) getRest.get("hair_color"));
                    temp.setHeight((String) getRest.get("height"));
                    temp.setHomeworld((String) getRest.get("homeworld"));
                    temp.setMass((String) getRest.get("mass"));
                    temp.setSkinColor((String) getRest.get("skin_color"));
                    temp.setCreated((String) getRest.get("created"));
                    temp.setEdited((String) getRest.get("edited"));
                    temp.setUrl((String) getRest.get("url"));

                    listFinal.add(temp);
                }

                list.stream().map((item) -> (LinkedHashMap<?, ?>) item).map((lhm) -> {
                    PeopleDto temp = new PeopleDto();
                    temp.setName((String) lhm.get("name"));
                    temp.setBirthYear((String) lhm.get("birth_year"));
                    temp.setEyeColor((String) lhm.get("eye_color"));
                    temp.setGender((String) lhm.get("gender"));
                    temp.setHairColor((String) lhm.get("hair_color"));
                    temp.setHeight((String) lhm.get("height"));
                    temp.setHomeworld((String) lhm.get("homeworld"));
                    temp.setMass((String) lhm.get("mass"));
                    temp.setSkinColor((String) lhm.get("skin_color"));
                    temp.setCreated((String) lhm.get("created"));
                    temp.setEdited((String) lhm.get("edited"));
                    temp.setUrl((String) lhm.get("url"));
                    return temp;
                }).forEachOrdered((temp) -> {
                    listFinal.add(temp);
                });

            } else {
                throw new HttpClientErrorException(HttpStatus.NO_CONTENT);
            }
        }

        logger.info("::::::::::::::::::::: END getPeoples :::::::::::::::::::::::");

        return listFinal;
    }
}
