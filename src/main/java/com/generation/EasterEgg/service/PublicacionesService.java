package com.generation.EasterEgg.service;

import com.generation.EasterEgg.models.Publicaciones;
import com.generation.EasterEgg.models.Usuario;

import java.util.List;

public interface PublicacionesService {
    Publicaciones getPost(Integer id );

    List<Publicaciones> getAllPost(Integer id );

    Publicaciones save(Publicaciones post );

    void delete( Integer id );

    Publicaciones updatePost(Publicaciones post, Integer id);
}
