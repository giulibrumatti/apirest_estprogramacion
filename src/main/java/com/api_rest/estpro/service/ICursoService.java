package com.api_rest.estpro.service;

import com.api_rest.estpro.model.Curso;

import java.util.Date;
import java.util.List;

public interface ICursoService {

    public void saveCurso(Curso curso);

    public List<Curso> getCursos();

    public void deleteCurso(Long id);

    public Curso findCurso(Long id);

    public void editCurso(Long id, String nuevoNombre, String nuevaMod, Date nuevaFecha);

    public void editCurso(Curso curso);

}
