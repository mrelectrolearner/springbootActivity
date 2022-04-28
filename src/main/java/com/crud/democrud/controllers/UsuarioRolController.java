package com.crud.democrud.controllers;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.services.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/usuarioRol")
public class UsuarioRolController {

    @Autowired
    UsuarioRolService usuarioRolService;

    @GetMapping()
    public ArrayList<UsuarioRolModel> obtenerRolesUsuarios() {
        return (ArrayList<UsuarioRolModel>) usuarioRolService.obtenerTodosLosRoles();
    }

    @PostMapping()
    public UsuarioRolModel guardarRolUsuario(@RequestBody UsuarioRolModel rol) {
        return this.usuarioRolService.crearRol(rol);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarRolPorId(@PathVariable("id") Long id) {
        boolean ok = this.usuarioRolService.eliminarRol(id);
        if (ok) {
            return "Se eliminó el rol con id " + id;
        } else {
            return "No pudo eliminar el rol con id" + id;
        }
    }

    @PutMapping(path = "/usuario/{idUsuario}/rol/{idRol}")
    public UsuarioRolModel asignarRolAUsuario(@PathVariable("idUsuario") Long idUsuario, @PathVariable("idRol") Long idRol) {
        return this.usuarioRolService.asigarRolAUsario(idRol,idUsuario);
    }
}
