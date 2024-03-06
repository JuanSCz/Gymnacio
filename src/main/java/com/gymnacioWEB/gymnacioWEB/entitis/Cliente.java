package com.gymnacioWEB.gymnacioWEB.entitis;

import com.gymnacioWEB.gymnacioWEB.enums.GeneroClienteEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;



@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, name = "contraseña")
    private String contrasena;

    @Column(nullable = false, name = "contraseña_dos")
    private String contrasenaDos;

    @Column(nullable = false, name = "fecha_registro")
    private Date fechaRegistro = new Date();

    @Column(nullable = false, name = "genero")
    @Enumerated(EnumType.STRING)
    private GeneroClienteEnum sexoClientesEnum;

    @Column(nullable = false, name = "numero_telefonico")
    private String numeroTelefonico;

    public Cliente() {
    }

    public Cliente(Long id, String nombre, String apellido, String email, String contrasena, String contrasenaDos, GeneroClienteEnum sexoClientesEnum, String numeroTelefonico) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.contrasenaDos = contrasenaDos;
        this.sexoClientesEnum = sexoClientesEnum;
        this.numeroTelefonico = numeroTelefonico;
        this.fechaRegistro = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getContrasenaDos() {
        return contrasenaDos;
    }

    public void setContrasenaDos(String contrasenaDos) {
        this.contrasenaDos = contrasenaDos;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public GeneroClienteEnum getSexoClientesEnum() {
        return sexoClientesEnum;
    }

    public void setSexoClientesEnum(GeneroClienteEnum sexoClientesEnum) {
        this.sexoClientesEnum = sexoClientesEnum;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }
}
