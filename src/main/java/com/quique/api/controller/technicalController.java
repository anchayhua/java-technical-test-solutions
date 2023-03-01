package com.quique.api.controller;

import com.fasterxml.jackson.core.io.JsonEOFException;
import com.quique.api.dto.PeopleDto;
import com.quique.api.dto.PlanetDto;
import com.quique.api.proxy.SwapiWS;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.quique.api.service.technicalService;
import java.util.Optional;
import javax.validation.Valid;
import javax.xml.ws.http.HTTPException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api")
public class technicalController {

    Logger logger = LoggerFactory.getLogger(technicalController.class);

    @Autowired
    technicalService otechnicalService;

    @Autowired
    SwapiWS oSwapiWS;

    @RequestMapping(value = "/planets", method = RequestMethod.GET)
    public ResponseEntity<List<PlanetDto>> getplanets(
            @RequestParam(value = "param", required = false) String param,
            @RequestParam(value = "page", required = false) String page) {

        try {

            List<PlanetDto> data = oSwapiWS.getPlanets((Optional.ofNullable(param).orElse("")), (Optional.ofNullable(page).orElse("")));
            return new ResponseEntity<>(data, HttpStatus.OK);

        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                return new ResponseEntity("La URL es inválida: " + e.getMessage(), HttpStatus.BAD_REQUEST);
            } else if (e instanceof HTTPException) {
                return new ResponseEntity("La petición HTTP falló: " + e.getMessage(), HttpStatus.BAD_GATEWAY);
            } else if (e instanceof JsonEOFException) {
                return new ResponseEntity("La respuesta de la API no es válida: " + e.getMessage(), HttpStatus.FORBIDDEN);
            } else if (e instanceof HttpClientErrorException.NotFound) {
                return new ResponseEntity("La petición no encontró contenido: " + e.getMessage(), HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity("Error desconocido: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(value = "/peoples", method = RequestMethod.GET)
    public ResponseEntity<List<PeopleDto>> getPeoples(
            @RequestParam(value = "param", required = false) String param,
            @RequestParam(value = "page", required = false) String page) {

        try {

            List<PeopleDto> data = oSwapiWS.getPeoples((Optional.ofNullable(param).orElse("")), (Optional.ofNullable(page).orElse("")));
            return new ResponseEntity<>(data, HttpStatus.OK);

        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                return new ResponseEntity("La URL es inválida: " + e.getMessage(), HttpStatus.BAD_REQUEST);
            } else if (e instanceof HTTPException) {
                return new ResponseEntity("La petición HTTP falló: " + e.getMessage(), HttpStatus.BAD_GATEWAY);
            } else if (e instanceof JsonEOFException) {
                return new ResponseEntity("La respuesta de la API no es válida: " + e.getMessage(), HttpStatus.FORBIDDEN);
            } else if (e instanceof HttpClientErrorException.NotFound) {
                return new ResponseEntity("La petición no encontró contenido: " + e.getMessage(), HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity("Error desconocido: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(value = "/planet/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<PlanetDto>> getAndSavePlanet(@PathVariable String id) {

        try {

            List<PlanetDto> data = otechnicalService.getAndSavePlanet(Optional.ofNullable(id).orElse(""));
            return new ResponseEntity<>(data, HttpStatus.OK);

        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                return new ResponseEntity("La URL es inválida: " + e.getMessage(), HttpStatus.BAD_REQUEST);
            } else if (e instanceof HTTPException) {
                return new ResponseEntity("La petición HTTP falló: " + e.getMessage(), HttpStatus.BAD_GATEWAY);
            } else if (e instanceof JsonEOFException) {
                return new ResponseEntity("La respuesta de la API no es válida: " + e.getMessage(), HttpStatus.FORBIDDEN);
            } else if (e instanceof HttpClientErrorException.NotFound) {
                return new ResponseEntity("La petición no encontró contenido: " + e.getMessage(), HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity("Error desconocido: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<PeopleDto>> getAndSavePeople(@PathVariable String id) {

        try {

            List<PeopleDto> data = otechnicalService.getAndSavePeople(Optional.ofNullable(id).orElse(""));
            return new ResponseEntity<>(data, HttpStatus.OK);

        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                return new ResponseEntity("La URL es inválida: " + e.getMessage(), HttpStatus.BAD_REQUEST);
            } else if (e instanceof HTTPException) {
                return new ResponseEntity("La petición HTTP falló: " + e.getMessage(), HttpStatus.BAD_GATEWAY);
            } else if (e instanceof JsonEOFException) {
                return new ResponseEntity("La respuesta de la API no es válida: " + e.getMessage(), HttpStatus.FORBIDDEN);
            } else if (e instanceof HttpClientErrorException.NotFound) {
                return new ResponseEntity("La petición no encontró contenido: " + e.getMessage(), HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity("Error desconocido: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(value = "/planet", method = RequestMethod.POST)
    public ResponseEntity<PlanetDto> savePlanet(@Valid @RequestBody PlanetDto newRecord) {

        if (newRecord.getId().toString() != null) {
            return new ResponseEntity(newRecord, HttpStatus.BAD_REQUEST);
        }

        try {

            PlanetDto createRecord = otechnicalService.savePlanet(newRecord);
            return new ResponseEntity(createRecord, HttpStatus.CREATED);

        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                return new ResponseEntity("La URL es inválida: " + e.getMessage(), HttpStatus.BAD_REQUEST);
            } else if (e instanceof HTTPException) {
                return new ResponseEntity("La petición HTTP falló: " + e.getMessage(), HttpStatus.BAD_GATEWAY);
            } else if (e instanceof JsonEOFException) {
                return new ResponseEntity("La respuesta de la API no es válida: " + e.getMessage(), HttpStatus.FORBIDDEN);
            } else if (e instanceof HttpClientErrorException.NotFound) {
                return new ResponseEntity("La petición no encontró contenido: " + e.getMessage(), HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity("Error desconocido: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
    @RequestMapping(value = "/people", method = RequestMethod.POST)
    public ResponseEntity<PlanetDto> savePeople(@Valid @RequestBody PeopleDto newRecord) {

        if (newRecord.getId().toString() != null) {
            return new ResponseEntity(newRecord, HttpStatus.BAD_REQUEST);
        }

        try {

            PeopleDto createRecord = otechnicalService.savePeople(newRecord);
            return new ResponseEntity(createRecord, HttpStatus.CREATED);

        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                return new ResponseEntity("La URL es inválida: " + e.getMessage(), HttpStatus.BAD_REQUEST);
            } else if (e instanceof HTTPException) {
                return new ResponseEntity("La petición HTTP falló: " + e.getMessage(), HttpStatus.BAD_GATEWAY);
            } else if (e instanceof JsonEOFException) {
                return new ResponseEntity("La respuesta de la API no es válida: " + e.getMessage(), HttpStatus.FORBIDDEN);
            } else if (e instanceof HttpClientErrorException.NotFound) {
                return new ResponseEntity("La petición no encontró contenido: " + e.getMessage(), HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity("Error desconocido: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
