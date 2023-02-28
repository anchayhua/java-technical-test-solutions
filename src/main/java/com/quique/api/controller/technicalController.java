package com.quique.api.controller;

import com.fasterxml.jackson.core.io.JsonEOFException;
import com.quique.api.dto.PlanetDto;
import com.quique.api.model.Gestionmarcaciones;
import com.quique.api.proxy.SwapiWS;
import com.quique.api.util.Constantes;
import com.quique.api.util.RestResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.quique.api.service.technicalService;
import java.util.Optional;
import javax.xml.ws.http.HTTPException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api")
public class technicalController {

    Logger logger = LoggerFactory.getLogger(technicalController.class);

    @Autowired
    technicalService oMarcacionesService;

    @Autowired
    SwapiWS oSwapiWS;

    @RequestMapping(value = "/planets", method = RequestMethod.GET)
    public ResponseEntity<List<PlanetDto>> getplanets(@RequestParam(value = "param", required = false) String param) {
        List<PlanetDto> data = oSwapiWS.getPlanets(Optional.ofNullable(param).isPresent() ? param : "");
        try {
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                return new ResponseEntity("La URL es inválida: " + e.getMessage(), HttpStatus.OK);
            } else if (e instanceof HTTPException) {
                return new ResponseEntity("La petición HTTP falló: " + e.getMessage(), HttpStatus.OK);
            } else if (e instanceof JsonEOFException) {
                return new ResponseEntity("La respuesta de la API no es válida: " + e.getMessage(), HttpStatus.OK);
            } else {
                return new ResponseEntity("Error desconocido: " + e.getMessage(), HttpStatus.OK);
            }
        }
    }

    @RequestMapping(value = "/planetss", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> listasrMarcacionesSQL() {

        logger.info("--------------------------------------------------------------------------");
        logger.info("===================== INICIAR LISTAR MARCACIONES SQL =====================");

        Map<String, Object> map = new HashMap<>();

        List<Gestionmarcaciones> list = oMarcacionesService.listasrMarcacionesSQL();

        if (!list.isEmpty()) {
            map.put(Constantes.STATUS, Constantes.CODIGO_RPSTA_OK);
            map.put(Constantes.RESULT, list);
        } else {
            map.put(Constantes.STATUS, Constantes.CODIGO_RPSTA_NO_CONTENT);
            map.put(Constantes.MESSAGE, Constantes.RPSTA_NO_CONTENT);
        }

        logger.info("======================= FIN LISTAR MARCACIONES SQL =======================");
        logger.info("--------------------------------------------------------------------------");

        return map;
    }

    @RequestMapping(value = "/importmarcacionmysql", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Map<String, Object> insert_marcacion_mysql(@RequestBody String key) {

        logger.info("--------------------------------------------------------------------------");
        logger.info("=================== INICIAR IMPORTAR MARCACION A MYSQL ===================");

        Map<String, Object> map = new HashMap<>();

        if (key.equals(Constantes.KEY_QUIQUE)) {

            RestResponse rpta = oMarcacionesService.insert_marcacion_mysql();

            if (rpta.getCodigo().equals(Constantes.CODIGO_RPSTA_OK)) {

                map.put(Constantes.STATUS, Constantes.CODIGO_RPSTA_OK);
                map.put(Constantes.MESSAGE, Constantes.RPSTA_OK);

            } else {
                map.put(Constantes.STATUS, rpta.getCodigo());
                map.put(Constantes.MESSAGE, rpta.getMensaje());
            }

        } else {
            map.put(Constantes.STATUS, Constantes.CODIGO_RPSTA_FORBIDDEN);
            map.put(Constantes.MESSAGE, Constantes.RPSTA_FORBIDDEN);
        }

        logger.info("===================== FIN IMPORTAR MARCACION A MYSQL =====================");
        logger.info("--------------------------------------------------------------------------");

        return map;
    }

}
