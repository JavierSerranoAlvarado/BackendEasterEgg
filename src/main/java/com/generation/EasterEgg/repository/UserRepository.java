package com.generation.EasterEgg.repository;

import com.generation.EasterEgg.models.Publicaciones;
import com.generation.EasterEgg.models.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<Usuario, Integer> {

    Usuario findByUsername(String correo);
}
