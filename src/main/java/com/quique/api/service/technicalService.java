package com.quique.api.service;

import com.quique.api.dto.PeopleDto;
import com.quique.api.dto.PlanetDto;
import java.util.List;

public interface technicalService {

    public List<PlanetDto> getAndSavePlanet(String param) throws Exception;

    public List<PeopleDto> getAndSavePeople(String param) throws Exception;

    public PlanetDto savePlanet(PlanetDto oPlanetDto) throws Exception;

    public PeopleDto savePeople(PeopleDto oPeopleDto) throws Exception;

}
