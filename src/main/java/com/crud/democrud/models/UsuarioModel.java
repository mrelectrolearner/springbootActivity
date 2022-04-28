package com.crud.democrud.models;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioModel implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", unique = true, nullable = false)
    private Long id;

    private String nombre;
    private String email;
    private Integer prioridad;

    @JsonIgnore
    @ManyToMany(mappedBy = "usuarios")
    private List<UsuarioRolModel> roles=new ArrayList<>();


    public UsuarioModel(String nombre, String email, Integer prioridad) {
        this.nombre = nombre;
        this.email = email;
        this.prioridad = prioridad;
    }

    public UsuarioModel() {

    }
    public void agregarRol(UsuarioRolModel rol){
        this.roles.add(rol);
    }

}