/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.api.dto;

import java.io.Serializable;

public class PlanetDto implements Serializable {

    private Long id;
    private String climate;
    private String diameter;
    private String gravity;
    private String name;
    private String population;
    private String residents;
    private String terrain;
    private String url;

    public PlanetDto() {
    }

    public PlanetDto(String climate, String diameter, String gravity, String name, String population, String residents, String terrain, String url) {
        this.climate = climate;
        this.diameter = diameter;
        this.gravity = gravity;
        this.name = name;
        this.population = population;
        this.residents = residents;
        this.terrain = terrain;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getResidents() {
        return residents;
    }

    public void setResidents(String residents) {
        this.residents = residents;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
