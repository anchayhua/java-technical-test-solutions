/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quique.api.util;

import java.text.SimpleDateFormat;

/**
 *
 * @author nanchayhua
 */
//@Component
public class EAIUtil {

    public static SimpleDateFormat formatoFechaIn = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    public static SimpleDateFormat formatoFechaOut = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat formatoHoraOut = new SimpleDateFormat("HH:mm:ss");
    public static SimpleDateFormat formatoHoraIn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS'Z'");

}
