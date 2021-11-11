package com.generation.EasterEgg.repository;

import com.generation.EasterEgg.models.Publicaciones;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionesRepository extends PagingAndSortingRepository<Publicaciones, Integer> {
    @Query(value = "SELECT * FROM usuario_publicaciones u WHERE u.id_usuarios = ?1" , nativeQuery = true)
    List<Publicaciones> encontrarPorUsuario(Integer id);

    List<Publicaciones> findByUsuarioIdUsuarios(Integer id);

    /*List<Publicaciones> findByUsuario(Integer id); */
}
