package com.generation.EasterEgg.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuarios")
    private Integer idUsuarios;

    @Column(name = "correo")
    private String username;

    private String password;


    @OneToMany(mappedBy = "usuario")
    private List<Publicaciones> publicaciones;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario_datos", referencedColumnName = "id_usuarios_datos")
    private UsuarioDatos usuarioDatos;

    public Usuario() {
    }

    public Usuario(Integer idUsuarios, String username, String password, List<Publicaciones> publicaciones, UsuarioDatos usuarioDatos) {
        this.idUsuarios = idUsuarios;
        this.username = username;
        this.password = password;
        this.publicaciones = publicaciones;
        this.usuarioDatos = usuarioDatos;
    }



    public Integer getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Publicaciones> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicaciones> publicaciones) {
        this.publicaciones = publicaciones;
    }

    public UsuarioDatos getUsuarioDatos() {
        return usuarioDatos;
    }

    public void setUsuarioDatos(UsuarioDatos usuarioDatos) {
        this.usuarioDatos = usuarioDatos;
    }
}
