package com.api_rest.estpro.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Curso {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long idCurso;
    private String nombre;
    private String modalidad;
    private Date fecha_finalizacion;
    @OneToMany(mappedBy="curso")
    @JsonManagedReference
    private List<Tema> listaTemas;

    public Curso(){

    }

    public Curso(Long id_curso, String nombre, String modalidad, Date fecha_finalizacion,
                 List<Tema> listaTemas) {
        this.idCurso = id_curso;
        this.nombre = nombre;
        this.modalidad = modalidad;
        this.fecha_finalizacion = fecha_finalizacion;
        this.listaTemas = listaTemas;
    }


}
