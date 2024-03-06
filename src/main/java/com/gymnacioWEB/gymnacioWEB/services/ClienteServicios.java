package com.gymnacioWEB.gymnacioWEB.services;

import com.gymnacioWEB.gymnacioWEB.entitis.Cliente;
import com.gymnacioWEB.gymnacioWEB.enums.GeneroClienteEnum;
import com.gymnacioWEB.gymnacioWEB.exceptions.ClienteExceptions;
import com.gymnacioWEB.gymnacioWEB.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
public class ClienteServicios {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public void crearCliente(String nombre, String apellido, String email, String contrasena, String contrasenaDos, GeneroClienteEnum sexoClientesEnum, String numeroTelefonico) throws ClienteExceptions {
        validarCliente(nombre, apellido, email, contrasena, contrasenaDos, sexoClientesEnum, numeroTelefonico);
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setEmail(email);
        cliente.setContrasena(contrasena);
        cliente.setContrasenaDos(contrasenaDos);
        cliente.setSexoClientesEnum(sexoClientesEnum);
        cliente.setNumeroTelefonico(numeroTelefonico);
        clienteRepository.save(cliente);
    }

    private void validarCliente(String nombre, String apellido, String email, String contrasena, String contrasenaDos, GeneroClienteEnum sexo, String numeroTelefonico)
            throws ClienteExceptions {

        if (nombre == null || nombre.isEmpty()) {
            throw new ClienteExceptions("El nombre no puede ser nulo o estar vacio");
        }

        if (apellido == null || apellido.isEmpty()) {
            throw new ClienteExceptions("El apellido no puede ser nulo o estar vacio");

        }

        if (email == null || email.isEmpty()) {
            throw new ClienteExceptions("El email no puede ser nulo o estar vacio");

        }

        if (contrasena == null || contrasena.isEmpty() || contrasena.length() <= 5) {
            throw new ClienteExceptions("La contraseña no puede estar vacia, y debe tener mas de 5 digitos");
        }

        if (contrasenaDos == null || contrasenaDos.isEmpty() || contrasenaDos.length() <= 5) {
            throw new ClienteExceptions("La contraseña no puede estar vacia, y debe tener mas de 5 digitos");
        }

        if (sexo == null) {
            throw new ClienteExceptions("El genero no puede ser nulo o estar vacio.");
        }

        if (!contrasena.equals(contrasenaDos)) {
            throw new ClienteExceptions("Las contraseñas ingresadas no coinciden");
        }
    }
}
