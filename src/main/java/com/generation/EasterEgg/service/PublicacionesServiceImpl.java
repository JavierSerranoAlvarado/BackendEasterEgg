package com.generation.EasterEgg.service;

import com.generation.EasterEgg.models.Publicaciones;
import com.generation.EasterEgg.repository.PublicacionesRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PublicacionesServiceImpl implements PublicacionesService{

    private PublicacionesRepository publicacionesRepository;

    public PublicacionesServiceImpl(PublicacionesRepository publicacionesRepository) {
        this.publicacionesRepository = publicacionesRepository;
    }

    @Override
    public Publicaciones getPost(Integer id) {
        Optional<Publicaciones> post =  publicacionesRepository.findById(id);
        return post.orElse(null);
    }


    @Override
    public List<Publicaciones> getPostsFromOneUser(Integer id) {
        return publicacionesRepository.findByUsuarioIdUsuarios(id);
    }

    @Override
    public Publicaciones save(Publicaciones post) {


        return publicacionesRepository.save(post);
    }

    @Override
    public void delete(Integer id) {
        publicacionesRepository.deleteById(id);
    }

    @Override
    public Publicaciones updatePost(Publicaciones post, Integer id) {
        return publicacionesRepository.findById(id).map(oldPost -> {
            oldPost.setDescripcion(post.getDescripcion());
            oldPost.setTitulo(post.getTitulo());
            oldPost.setImagen(post.getImagen());
            return publicacionesRepository.save(oldPost);
        }).orElse(null);
    };


}
