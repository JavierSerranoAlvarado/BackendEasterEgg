package com.generation.EasterEgg.controllers;

import com.generation.EasterEgg.models.Usuario;
import com.generation.EasterEgg.models.UsuarioDatos;
import com.generation.EasterEgg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
public class UsuarioController {

    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsuarioController(@Autowired UserService userService, @Autowired BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping( "/user/{id}" )
    public Usuario getUser(@PathVariable Integer id) {
        return userService.getUsuario(id);
    }


    @PostMapping("/user/getId")
    public Usuario getIdLogin(@RequestBody Usuario usuario){
        Usuario user = userService.getIdByUser(usuario.getUsername());
        if(user != null){
            return user;
        } else{
            return null;
        }
    }

    @PostMapping("/user/postImgPerfil")
    public boolean postImgPerfil(@RequestBody Usuario usuario){
        Usuario user = userService.getUsuario(usuario.getIdUsuarios());
        if(user != null && usuario.getUsuarioDatos().getImgPerfil() != null){
            user.getUsuarioDatos().setImgPerfil(usuario.getUsuarioDatos().getImgPerfil());
             userService.update(user);
             return true;
        }else{
            return false;
        }

    }


    @PostMapping( "/user" )
    public String newUser( @RequestBody Usuario user )
    {
        user.setPassword( bCryptPasswordEncoder.encode( user.getPassword() ) );
        if (userService.save( user )){
            return "REGISTRADO";
        } else{
            return "ERROR";
        }
    }

    /* @PutMapping( "/user" )
    public Usuario updateUser( @RequestBody Usuario user )
    {
        return userService.save( user );
    } */

    @DeleteMapping( "/user/{id}" )
    public void deleteUser( @PathVariable Integer id )
    {
        userService.delete( id );
    }

    /* @GetMapping("user/loging")
    public boolean iniciaSesion(@PathVariable String correo, @PathVariable String password){
        return userService.logear(correo, password);
    } */

}
