package com.crud.democrud.ServicesTest;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static  org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioServiceTest {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Test
    public void testGuardarUsuario(){
        UsuarioModel usuarioModel=new UsuarioModel("aquaman","aqua@gmail.com",99);
        UsuarioModel usuarioModelRegistrado = usuarioRepository.save(usuarioModel);
        assertNotNull(usuarioModelRegistrado);
    }

    @Test
    public void testBuscarUsuarioPorId(){
        Long idBuscado=10L;
        Optional<UsuarioModel> usuarioModelBuscado=usuarioRepository.findById(idBuscado);
        assertThat(usuarioModelBuscado.get().getId()).isEqualTo(idBuscado);
    }

    @Test
    public void testBuscarUsuarioPorPrioridad(){
        UsuarioModel usuarioModel=new UsuarioModel("aquaman","aqua@gmail.com",99);
        UsuarioModel usuarioModelRegistrado = usuarioRepository.save(usuarioModel);
        Integer prioridad =99;
        ArrayList<UsuarioModel> usuarioModelBuscado= (ArrayList<UsuarioModel>) usuarioRepository.findByPrioridad(99);
        assertThat(usuarioModelBuscado.get(0).getPrioridad()).isEqualTo(prioridad);
    }

    @Test
    public void testListarUsuarios(){
        List<UsuarioModel> usuarioModelList=(List<UsuarioModel>) usuarioRepository.findAll();
        assertThat(usuarioModelList).size().isGreaterThan(0);
    }

}
