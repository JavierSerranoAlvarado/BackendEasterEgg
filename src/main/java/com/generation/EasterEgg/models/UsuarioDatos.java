package com.generation.EasterEgg.models;

import javax.persistence.*;

@Entity(name="usuarios_datos")
public class UsuarioDatos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuarios_datos")
    private Integer idUsuariosDatos;

    /*@Column(name = "id_usuarios")
    private String idUsuarios; */

    /*@OneToOne(mappedBy = "usuarioDatos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Usuario id_usuarios;*/

    private String nombre;

    private String apellido;

    private String sexo;

    @Column(name = "f_nacimiento")
    private String nacimiento;

    @Column(name = "gamer_tagg")
    private String gamerTag;

    @Column(name = "miembro_desde")
    private String miembroDesde;

    @Column(name = "img_perfil")
    private String imgPerfil;


    @OneToOne(mappedBy = "usuarioDatos", fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuarios")
    private Usuario usuario;

    public UsuarioDatos() {
    }

    public UsuarioDatos(String nombre, String apellido, String sexo, String nacimiento, String gamerTag, String miembroDesde, String imgPerfil, Usuario usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.nacimiento = nacimiento;
        this.gamerTag = gamerTag;
        this.miembroDesde = miembroDesde;
        this.imgPerfil = imgPerfil;
        this.usuario = usuario;
    }

    public UsuarioDatos(Integer idUsuariosDatos, String nombre, String apellido, String sexo, String nacimiento, String gamerTag, String miembroDesde, String imgPerfil, Usuario usuario) {
        this.idUsuariosDatos = idUsuariosDatos;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.nacimiento = nacimiento;
        this.gamerTag = gamerTag;
        this.miembroDesde = miembroDesde;
        this.imgPerfil = imgPerfil;
        this.usuario = usuario;
    }

    public String getMiembroDesde() {
        return miembroDesde;
    }

    public void setMiembroDesde(String miembroDesde) {
        this.miembroDesde = miembroDesde;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public String getGamerTag() {
        return gamerTag;
    }

    public void setGamerTag(String gamerTag) {
        this.gamerTag = gamerTag;
    }

    public Integer getIdUsuariosDatos() {
        return idUsuariosDatos;
    }

    public void setIdUsuariosDatos(Integer idUsuariosDatos) {
        this.idUsuariosDatos = idUsuariosDatos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }
}
