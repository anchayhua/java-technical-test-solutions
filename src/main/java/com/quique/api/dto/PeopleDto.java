/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.api.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

public class PeopleDto implements Serializable {

    private Long id;
    @NotNull(message = "Insert name")
    private String name;
    @NotNull(message = "Insert birthYear")
    private String birthYear;
    @NotNull(message = "Insert eyeColor")
    private String eyeColor;
    @NotNull(message = "Insert gender")
    private String gender;
    @NotNull(message = "Insert hairColor")
    private String hairColor;
    @NotNull(message = "Insert height")
    private String height;
    @NotNull(message = "Insert homeworld")
    private String homeworld;
    @NotNull(message = "Insert mass")
    private String mass;
    @NotNull(message = "Insert skinColor")
    private String skinColor;
    @NotNull(message = "Insert created")
    private String created;
    private String edited;
    private String url;

    public PeopleDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
