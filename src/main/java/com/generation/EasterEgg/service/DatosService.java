package com.generation.EasterEgg.service;

import com.generation.EasterEgg.models.Usuario;
import com.generation.EasterEgg.models.UsuarioDatos;

public interface DatosService {
    UsuarioDatos getDatos(Integer id );

    UsuarioDatos saveDatos(UsuarioDatos user );

    void deleteDatos( Integer id );


}
