/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.api.util;

import java.util.Date;

/**
 *
 * @author nanchayhua
 */
public class AuditUtil {

    private static int idusuario;
//    private static Date fechaActual;

    public static int getIdusuario() {
        return idusuario;
    }

    public static void setIdusuario(int aIdusuario) {
        idusuario = aIdusuario;
    }

    public static Date getFechaActual() {
        return new Date();
    }

//    public static void setFechaActual(Date aFechaActual) {
//        fechaActual = aFechaActual;
//    }

}
