/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.api.persist;

import com.quique.api.dao.BaseDAO;
import com.quique.api.exception.DBException;
import com.quique.api.model.Gestionmarcaciones;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

/**
 *
 * @author QUIQUE
 */
@Repository
public class technicalPersist implements technicalMarcacionesDao {

    Logger logger = LoggerFactory.getLogger(technicalPersist.class);

    @Autowired
    BaseDAO<Integer, Gestionmarcaciones> gestionmarcacionesDAO;

    @Autowired
    BaseDAO<Integer, Object> objectDAO;

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Gestionmarcaciones> listasrMarcacionesSQL() throws DBException {
        logger.info(":::::::::::::::::::::::::: listasrMarcacionesSQL :::::::::::::::::::::::::");
        return gestionmarcacionesDAO.findByNamedQuery("Gestionmarcaciones.findAll");
    }

    @Override
    public void insert_marcacion_mysql() throws DBException {
        logger.info("::::::::::::::::::::::::: insert_marcacion_mysql :::::::::::::::::::::::::");
        StoredProcedureQuery query = em.createStoredProcedureQuery("db_intranet_pro.dbo.sp_insert_marcacion_mysql");
        query.execute();

    }

}
