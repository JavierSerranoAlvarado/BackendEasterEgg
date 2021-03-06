package com.generation.EasterEgg.controllers;

import com.generation.EasterEgg.models.UsuarioDatos;
import com.generation.EasterEgg.service.DatosService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioDatosController {
    private DatosService datosService;

    public UsuarioDatosController(DatosService datosService) {
        this.datosService = datosService;
    }

    @GetMapping("/datos/{id}")
    public UsuarioDatos getDatos(@PathVariable Integer id){
        return datosService.getDatos(id);
    }

    @PostMapping("/datos/")
    public UsuarioDatos postDatos(@RequestBody UsuarioDatos newDatos){
        return datosService.saveDatos(newDatos);
    }

}
