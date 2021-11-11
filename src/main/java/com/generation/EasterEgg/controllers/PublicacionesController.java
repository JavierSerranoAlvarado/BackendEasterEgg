package com.generation.EasterEgg.controllers;

import com.generation.EasterEgg.models.Publicaciones;
import com.generation.EasterEgg.models.Usuario;
import com.generation.EasterEgg.service.PublicacionesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublicacionesController {

    private PublicacionesService publicacionesService;

    public PublicacionesController(PublicacionesService publicacionesService) {
        this.publicacionesService = publicacionesService;
    }


    @GetMapping("/post/{id}")
    public Publicaciones getPost(@PathVariable Integer id){
        return publicacionesService.getPost(id);
    }


    @PostMapping("/post/all/{id}")
    public List<Publicaciones> getAllPost(@PathVariable Integer id){
        return publicacionesService.getPostsFromOneUser(id);
    }

    @PostMapping("/post")
    public Publicaciones putPost(@RequestBody Publicaciones post){
        return publicacionesService.save(post);
    }


    @PutMapping( "/post/{id}" )
    public Publicaciones updatePost( @RequestBody Publicaciones post, @PathVariable Integer id )
    {
        return publicacionesService.updatePost( post, id );
    }

    @DeleteMapping( "/post/{id}" )
    public void deletePost( @PathVariable Integer id )
    {
        publicacionesService.delete( id );
    }


}
