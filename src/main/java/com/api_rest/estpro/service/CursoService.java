package com.api_rest.estpro.service;

import com.api_rest.estpro.model.Curso;
import com.api_rest.estpro.repository.ICursoReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CursoService implements ICursoService{
    @Autowired
    private ICursoReposotory iCursoRep;

    @Override
    public void saveCurso(Curso curso) {
        iCursoRep.save(curso);
    }

    @Override
    public List<Curso> getCursos() {
        List<Curso> listaSalida = iCursoRep.findAll();
        return listaSalida;
    }

    @Override
    public void deleteCurso(Long id) {
        iCursoRep.deleteById(id);
    }

    @Override
    public Curso findCurso(Long id) {
        Curso cur = iCursoRep.findById(id).orElse(null);
        return cur;
    }


    @Override
    public void editCurso(Long id, String nuevoNombre, String nuevaMod, Date nuevaFecha) {
        Curso cur = this.findCurso(id);
        cur.setNombre(nuevoNombre);
        cur.setModalidad(nuevaMod);
        cur.setFecha_finalizacion(nuevaFecha);
        this.saveCurso(cur);
    }

    @Override
    public void editCurso(Curso curso) {
        this.saveCurso(curso);
    }
}
