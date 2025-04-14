package com.api_rest.estpro.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Tema {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idTema;
    private String nombre;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_curso", referencedColumnName="idCurso")
    @JsonBackReference
    private Curso curso;

    public Tema(){

    }

    public Tema(Long idTema, String nombre, String description, Curso nuevoCurso) {
        this.idTema = idTema;
        this.nombre = nombre;
        this.descripcion = description;
        this.curso = nuevoCurso;
    }
}
