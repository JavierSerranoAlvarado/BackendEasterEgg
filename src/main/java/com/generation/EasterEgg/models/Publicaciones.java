package com.generation.EasterEgg.models;

import javax.persistence.*;
import java.sql.Blob;

@Entity(name = "usuario_publicaciones")
public class Publicaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publicaciones")
    private Integer idPublicaciones;

    /*@Column(name = "id_usuarios")
    private Integer idUsuarios; */


    private String imagen;

    private String titulo;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_usuarios", referencedColumnName = "id_usuarios")
    private Usuario usuario;

   /*public Usuario getUsuario() {
        return usuario;
    }*/
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Publicaciones(Integer idPublicaciones, String imagen, String titulo, String descripcion) {
        this.idPublicaciones = idPublicaciones;
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Publicaciones() {
    }


    public Integer getIdPublicaciones() {
        return idPublicaciones;
    }

    public void setIdPublicaciones(Integer idPublicaciones) {
        this.idPublicaciones = idPublicaciones;
    }


    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
