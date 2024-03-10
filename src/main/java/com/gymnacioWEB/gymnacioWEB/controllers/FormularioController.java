package com.gymnacioWEB.gymnacioWEB.controllers;

import com.gymnacioWEB.gymnacioWEB.enums.GeneroClienteEnum;
import com.gymnacioWEB.gymnacioWEB.exceptions.ClienteExceptions;
import com.gymnacioWEB.gymnacioWEB.services.ClienteServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class FormularioController {

    @Autowired
    private ClienteServicios clienteServicios;

    @GetMapping("/registrar")
    public String registrar() {
        return "indexFormulario.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, String apellido, String email, String contrasena, String contrasenaDos, GeneroClienteEnum sexoClientesEnum, String numeroTelefonico, ModelMap modelo) {
        try {
            clienteServicios.crearCliente(nombre, apellido, email, contrasena, contrasenaDos, sexoClientesEnum, numeroTelefonico);
            modelo.put("exito", "Gracias " + nombre + ", te has registrado con éxito!");
            return "indexFormulario.html";
        } catch (ClienteExceptions ex) {
            modelo.put("error", ex.getMessage());
            return "indexFormulario.html";
        }
    }
}
