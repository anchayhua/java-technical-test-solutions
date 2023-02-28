/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.api.util;

/**
 *
 * @author nanchayhua
 */
public class RestResponse {

    private String codigo;
    private String mensaje;
    private Object object;

    public RestResponse() {
    }

    public RestResponse(String codigo, String mensaje, Object object) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.object = object;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "RestResponse{" + "codigo=" + codigo + ", mensaje=" + mensaje + ", object=" + object + '}';
    }

}
