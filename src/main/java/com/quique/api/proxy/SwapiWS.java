package com.quique.api.proxy;

import com.quique.api.dto.PeopleDto;
import com.quique.api.dto.PlanetDto;
import java.util.List;

public interface SwapiWS {

    public List<PlanetDto> getPlanets(String params, String page) throws Exception;

    public List<PeopleDto> getPeoples(String params, String page) throws Exception;
}
