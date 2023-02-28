/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.api.persist;

import com.quique.api.exception.DBException;
import com.quique.api.model.Gestionmarcaciones;
import java.util.List;

/**
 *
 * @author Quique
 */
public interface technicalMarcacionesDao {

    public List<Gestionmarcaciones> listasrMarcacionesSQL() throws DBException;

    public void insert_marcacion_mysql() throws DBException;
}
