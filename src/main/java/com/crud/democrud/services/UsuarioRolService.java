package com.crud.democrud.services;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.repositories.UsuarioRepository;
import com.crud.democrud.repositories.UsuarioRolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class UsuarioRolService {
    @Autowired
    UsuarioRolRepository usuarioRolRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioRolModel> obtenerTodosLosRoles(){
        return (List<UsuarioRolModel>) usuarioRolRepository.findAll();
    }

    public UsuarioRolModel crearRol(UsuarioRolModel role){
        return usuarioRolRepository.save(role);
    }

    public boolean eliminarRol(Long id) {
        try{
            usuarioRolRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public UsuarioRolModel asigarRolAUsario(Long idRole, Long idUsuario){
        UsuarioModel usuario=usuarioRepository.findById(idUsuario).get();
        UsuarioRolModel rol=usuarioRolRepository.findById(idRole).get();
        rol.agregarusuario(usuario);

        return usuarioRolRepository.save(rol);
    }

}
