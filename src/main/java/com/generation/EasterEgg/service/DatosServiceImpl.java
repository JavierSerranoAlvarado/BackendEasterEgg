package com.generation.EasterEgg.service;

import com.generation.EasterEgg.models.Usuario;
import com.generation.EasterEgg.models.UsuarioDatos;
import com.generation.EasterEgg.repository.DatosRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DatosServiceImpl implements DatosService{

    private DatosRepository datosRepository;

    public DatosServiceImpl(DatosRepository datosRepository) {
        this.datosRepository = datosRepository;
    }

    @Override
    public UsuarioDatos getDatos(Integer id) {
        Optional<UsuarioDatos> uDatos = datosRepository.findById(id);
        return uDatos.orElse(null);
    }

    @Override
    public UsuarioDatos saveDatos(UsuarioDatos user) {
        return datosRepository.save(user);
    }

    @Override
    public void deleteDatos(Integer id) {

    }

}
