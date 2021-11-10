package com.generation.EasterEgg.service;

import com.generation.EasterEgg.models.Usuario;

public interface UserService {

    Usuario getUsuario( Integer id );

    Usuario getIdByUser( String user );

    boolean save(Usuario user );

    Usuario update(Usuario user);

    void delete( Integer id );

}
