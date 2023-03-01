/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.api.persist;

import com.quique.api.exception.DBException;
import com.quique.api.model.People;
import com.quique.api.model.Planet;

/**
 *
 * @author Quique
 */
public interface technicalDao {

    public Long insertPlanet(Planet oPlanet) throws DBException;

    public Long insertPeople(People oPeople) throws DBException;
}
