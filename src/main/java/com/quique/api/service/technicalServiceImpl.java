/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.api.service;

import com.quique.api.exception.DBException;
import com.quique.api.model.Gestionmarcaciones;
import com.quique.api.util.Constantes;
import com.quique.api.util.RestResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.quique.api.persist.technicalMarcacionesDao;

/**
 *
 * @author QUIQUE
 */
@Service
public class technicalServiceImpl implements technicalService {

    Logger logger = LoggerFactory.getLogger(technicalServiceImpl.class);

    @Autowired
    technicalMarcacionesDao oImportarMarcacionesDao;

    @Override
    public List<Gestionmarcaciones> listasrMarcacionesSQL() {

        logger.info("::::::::::::::::::::: INICIAR listasrMarcacionesSQL ::::::::::::::::::::::");

        List<Gestionmarcaciones> listDto = new ArrayList<>();
        try {
            listDto = oImportarMarcacionesDao.listasrMarcacionesSQL();
            logger.info("Cantidad de datos {}", listDto.size());

        } catch (DBException ex) {
            java.util.logging.Logger.getLogger(technicalServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            logger.error("Error: {}", ex);
        }

        logger.info("::::::::::::::::::::::: FIN listasrMarcacionesSQL :::::::::::::::::::::::::");

        return listDto;
    }

    @Override
    public RestResponse insert_marcacion_mysql() {

        logger.info(":::::::::::::::::::: INICIAR insert_marcacion_mysql ::::::::::::::::::::::");

        RestResponse response = new RestResponse();

        try {

            oImportarMarcacionesDao.insert_marcacion_mysql();

            response.setCodigo(Constantes.CODIGO_RPSTA_OK);
            response.setMensaje(Constantes.RPSTA_OK);
            logger.info(response.toString());

        } catch (DBException ex) {
            java.util.logging.Logger.getLogger(technicalServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            response.setCodigo(Constantes.CODIGO_RPSTA_INTERNAL_SERVER_ERROR);
            response.setMensaje(Constantes.CODIGO_RPSTA_INTERNAL_SERVER_ERROR);
            logger.error("Error: {}", ex);
        }

        logger.info(":::::::::::::::::::::: FIN insert_marcacion_mysql ::::::::::::::::::::::::");

        return response;
    }

}
