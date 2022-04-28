package com.crud.democrud.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="usuario_rol")
public class UsuarioRolModel implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "id_usuario_rol ", unique = true, nullable = false)
    private Long id;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name="usuario_con_usuario_rol",
            joinColumns = {@JoinColumn(name="id_usuario_rol")},
            inverseJoinColumns = {@JoinColumn(name="id")})
    private List<UsuarioModel> usuarios=new ArrayList<>();



    private String rol;

    public void agregarusuario(UsuarioModel usuario){
        this.usuarios.add(usuario);
    }

    public UsuarioRolModel(String rol) {
        this.rol = rol;
    }

    public UsuarioRolModel() {

    }
}
