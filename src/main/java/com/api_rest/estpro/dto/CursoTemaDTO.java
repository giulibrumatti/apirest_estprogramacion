package com.api_rest.estpro.dto;

import com.api_rest.estpro.model.Tema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CursoTemaDTO {

    private String nombreCurso;
    private List<Tema> listaTemas;

    public CursoTemaDTO(){

    }

    public CursoTemaDTO(String nombreCurso, List<Tema> listaTemas) {
        this.nombreCurso = nombreCurso;
        this.listaTemas = listaTemas;
    }
}
