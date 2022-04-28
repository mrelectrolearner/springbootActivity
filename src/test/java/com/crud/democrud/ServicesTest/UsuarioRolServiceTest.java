package com.crud.democrud.ServicesTest;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.repositories.UsuarioRolRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioRolServiceTest {
    @Autowired
    UsuarioRolRepository usuarioRolRepository;

    @Test
    public void testGuardarRol(){
        UsuarioRolModel usuarioRolModel=new UsuarioRolModel("jardinero");
        usuarioRolRepository.save(usuarioRolModel);
        assertNotNull(usuarioRolModel);
    }

    @Test
    public void testEncontrarRolPorId(){
        UsuarioRolModel usuarioRolModel=new UsuarioRolModel("jardinero");
        usuarioRolRepository.save(usuarioRolModel);
        Long id=1L;
        Optional<UsuarioRolModel> usuarioRolModelBuscado=usuarioRolRepository.findById(id);
        assertThat(usuarioRolModelBuscado.get().getId()).isEqualTo(id);
    }

    @Test
    public void testListarRoles(){
        List<UsuarioRolModel> usuarioRolModelList= (List<UsuarioRolModel>) usuarioRolRepository.findAll();
        assertThat(usuarioRolModelList).size().isGreaterThan(0);
    }


}
