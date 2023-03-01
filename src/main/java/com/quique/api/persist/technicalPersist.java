/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.api.persist;

import com.quique.api.dao.BaseDAO;
import com.quique.api.exception.DBException;
import com.quique.api.model.People;
import com.quique.api.model.Planet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

/**
 *
 * @author QUIQUE
 */
@Repository
public class technicalPersist implements technicalDao {

    Logger logger = LoggerFactory.getLogger(technicalPersist.class);

    @Autowired
    BaseDAO<Long, Planet> planetDAO;

    @Autowired
    BaseDAO<Long, People> peopleDAO;

    @Override
    public Long insertPlanet(Planet oPlanet) throws DBException {
        logger.info(":::::::::::::::::::::: insertPlanet ::::::::::::::::::::::");
        planetDAO.insert(oPlanet);
        return oPlanet.getId();
    }

    @Override
    public Long insertPeople(People oPeople) throws DBException {
        logger.info(":::::::::::::::::::::: insertPeople ::::::::::::::::::::::");
        peopleDAO.insert(oPeople);
        return oPeople.getId();
    }

}
