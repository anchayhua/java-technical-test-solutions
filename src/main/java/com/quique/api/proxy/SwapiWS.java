package com.quique.api.proxy;

import com.quique.api.dto.PlanetDto;
import java.util.List;

public interface SwapiWS {

    public List<PlanetDto> getPlanets(String params);
}
