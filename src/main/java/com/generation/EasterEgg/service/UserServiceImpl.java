package com.generation.EasterEgg.service;

import com.generation.EasterEgg.models.Usuario;
import com.generation.EasterEgg.models.UsuarioDatos;
import com.generation.EasterEgg.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final Log LOGGER = LogFactory.getLog((UserServiceImpl.class));

    private UserRepository userRepository;
    private DatosService datosService;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Usuario getUsuario(Integer id) {
        Optional<Usuario> user = userRepository.findById( id );
        return user.orElse( null );
    }

    @Override
    public Usuario getIdByUser(String user) {
       Usuario usuario = userRepository.findByUsername(user);
       return usuario;
    }


    @Override
    public boolean save(Usuario user) {
        Usuario revisar = userRepository.findByUsername(user.getUsername());
        if(revisar != null){
            return false;
        }else {
            userRepository.save(user);
            return true;
        }
    }

    public Usuario update(Usuario user) {
            return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), emptyList());
    }

}
