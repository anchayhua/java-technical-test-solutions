package com.quique.api.proxy;

import com.quique.api.dto.PlanetDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author QUIQUE
 */
@Component
public class SwapiWSImpl implements SwapiWS {

    Logger logger = LoggerFactory.getLogger(SwapiWSImpl.class);

    @Override
    public List<PlanetDto> getPlanets(String params) {

        logger.info("::::::::::::::::::: INICIAR getPlanets :::::::::::::::::::::");

        List<PlanetDto> listFinal = new ArrayList<>();

        String url = "https://swapi.dev/api/planets/" + (Optional.ofNullable(params).orElse("")) + "?format=json";

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> getRest = restTemplate.getForObject(url, Map.class);

        Object obj = getRest.get("results");

        List<?> list = new ArrayList<>();
        if (obj.getClass().isArray()) {
            list = Arrays.asList((LinkedHashMap[]) obj);
        } else if (obj instanceof Collection) {
            list = new ArrayList<>((Collection<?>) obj);
        } else {
            throw new RuntimeException("Unexpected object type: " + obj.getClass());
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

        logger.info("::::::::::::::::::::: FIN getPlanets :::::::::::::::::::::::");

        return listFinal;

//        logger.info("::::::::::::::::::: INICIAR getPlanets :::::::::::::::::::::");
//
//        List<PlanetDto> listFinal = new ArrayList<>();
//
//        String url = "https://swapi.dev/api/planets/" + (Optional.ofNullable(params).orElse("")) + "?format=json";
//
//        RestTemplate restTemplate = new RestTemplate();
//        Map<String, Object> getRest = restTemplate.getForObject(url, Map.class);
//
//        List<?> list;
//
//        Object obj = getRest.get("results");
//
//        if (obj.getClass().isArray()) {
//            list = Arrays.asList((LinkedHashMap[]) obj);
//        } else if (obj instanceof Collection) {
//            list = new ArrayList<>((Collection<?>) obj);
//        } else {
//            throw new RuntimeException("Unexpected object type: " + obj.getClass());
//        }
//
//        list.stream().map((item) -> (LinkedHashMap<?, ?>) item).map((lhm) -> {
//            PlanetDto temp = new PlanetDto();
//            temp.setClimate((String) lhm.get("climate"));
//            temp.setDiameter((String) lhm.get("diameter"));
//            temp.setGravity((String) lhm.get("gravity"));
//            temp.setName((String) lhm.get("name"));
//            temp.setPopulation((String) lhm.get("population"));
//            //temp.setResidents((String) lhm.get("population"));
//            temp.setTerrain((String) lhm.get("terrain"));
//            temp.setUrl((String) lhm.get("url"));
//            return temp;
//        }).forEachOrdered((temp) -> {
//            listFinal.add(temp);
//        });
//
//        logger.info("::::::::::::::::::::: FIN getPlanets :::::::::::::::::::::::");
//
//        return listFinal;
    }

}
