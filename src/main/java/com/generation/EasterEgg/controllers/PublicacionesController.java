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


    @PostMapping("/post/all")
    public List<Publicaciones> getAllPost(@RequestParam Integer id){
        return publicacionesService.getPostsFromOneUser(id);
    }

    @GetMapping("/posts/all")
    public List<Publicaciones> getAllPosts(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "5") int size) {
        return publicacionesService.getAllPosts(page, size);
    }

    @PostMapping("/post")
    public Publicaciones putPost(@RequestBody Publicaciones post){
        return publicacionesService.save(post);
    }


    @PostMapping( "/post/edit" )
    public Publicaciones updatePost( @RequestBody Publicaciones post, @RequestParam Integer id )
    {
        return publicacionesService.updatePost( post, id );
    }

    @DeleteMapping( "/post/{id}" )
    public void deletePost( @PathVariable Integer id )
    {
        publicacionesService.delete( id );
    }


}
