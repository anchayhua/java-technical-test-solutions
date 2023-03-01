/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.api.service;

import com.quique.api.dto.PeopleDto;
import com.quique.api.dto.PlanetDto;
import com.quique.api.exception.DBException;
import com.quique.api.model.People;
import com.quique.api.model.Planet;
import java.util.List;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.quique.api.proxy.SwapiWS;
import java.util.Collections;
import java.util.Optional;
import com.quique.api.persist.technicalDao;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author QUIQUE
 */
@Service
public class technicalServiceImpl implements technicalService {

    Logger logger = LoggerFactory.getLogger(technicalServiceImpl.class);

    @Autowired
    technicalDao otechnicalDao;

    @Autowired
    SwapiWS oSwapiWS;

    @Override
    public List<PlanetDto> getAndSavePlanet(String param) throws Exception {

        logger.info("::::::::::::::::::::: START getAndSavePlanet ::::::::::::::::::::::");

        List<PlanetDto> listDto = oSwapiWS.getPlanets((Optional.ofNullable(param).orElse("")), "");

        Optional.ofNullable(listDto)
                .orElse(Collections.emptyList())
                .forEach((PlanetDto oPlanetDto) -> {

                    try {
                        Planet oPlanet = new Planet();
                        BeanUtils.copyProperties(oPlanetDto, oPlanet);
                        otechnicalDao.insertPlanet(oPlanet);

                    } catch (DBException ex) {
                        java.util.logging.Logger.getLogger(technicalService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });

        logger.info("::::::::::::::::::::::: END getAndSavePlanet :::::::::::::::::::::::::");

        return listDto;
    }

    @Override
    public List<PeopleDto> getAndSavePeople(String param) throws Exception {

        logger.info("::::::::::::::::::::: START getAndSavePeople ::::::::::::::::::::::");

        List<PeopleDto> listDto = oSwapiWS.getPeoples((Optional.ofNullable(param).orElse("")), "");

        Optional.ofNullable(listDto)
                .orElse(Collections.emptyList())
                .forEach((PeopleDto oPeopleDto) -> {

                    try {
                        People oPeople = new People();
                        BeanUtils.copyProperties(oPeopleDto, oPeople);
                        otechnicalDao.insertPeople(oPeople);

                    } catch (DBException ex) {
                        java.util.logging.Logger.getLogger(technicalService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });

        logger.info("::::::::::::::::::::::: END getAndSavePeople :::::::::::::::::::::::::");

        return listDto;
    }

    @Override
    public PlanetDto savePlanet(PlanetDto oPlanetDto) throws Exception {

        logger.info("::::::::::::::::::::: START savePlanet ::::::::::::::::::::::");

        try {
            Planet oPlanet = new Planet();
            BeanUtils.copyProperties(oPlanetDto, oPlanet);

            oPlanetDto.setId(otechnicalDao.insertPlanet(oPlanet));

        } catch (DBException ex) {
            java.util.logging.Logger.getLogger(technicalService.class.getName()).log(Level.SEVERE, null, ex);
        }

        logger.info("::::::::::::::::::::::: END savePlanet :::::::::::::::::::::::::");

        return oPlanetDto;
    }

    @Override
    public PeopleDto savePeople(PeopleDto oPeopleDto) throws Exception {

        logger.info("::::::::::::::::::::: START savePeople ::::::::::::::::::::::");

        try {
            People oPeople = new People();
            BeanUtils.copyProperties(oPeopleDto, oPeople);

            oPeopleDto.setId(otechnicalDao.insertPeople(oPeople));

        } catch (DBException ex) {
            java.util.logging.Logger.getLogger(technicalService.class.getName()).log(Level.SEVERE, null, ex);
        }

        logger.info("::::::::::::::::::::::: END savePeople :::::::::::::::::::::::::");

        return oPeopleDto;
    }

}
