package com.quique.api.service;

import com.quique.api.model.Gestionmarcaciones;
import com.quique.api.util.RestResponse;
import java.util.List;

public interface technicalService {

    public List<Gestionmarcaciones> listasrMarcacionesSQL();

    public RestResponse insert_marcacion_mysql();

}
