package com.api_rest.estpro.service;

import com.api_rest.estpro.dto.CursoTemaDTO;
import com.api_rest.estpro.model.Curso;
import com.api_rest.estpro.repository.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CursoService implements ICursoService{
    @Autowired
    private ICursoRepository iCursoRep;

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

    @Override
    public CursoTemaDTO temasPorCurso(Long idCurso) {
        CursoTemaDTO cursoTemDto = new CursoTemaDTO();
        Curso curso = this.findCurso(idCurso);
        cursoTemDto.setNombreCurso(curso.getNombre());
        cursoTemDto.setListaTemas(curso.getListaTemas());
        return cursoTemDto;
    }

    @Override
    public List<Curso> getCursosJava(){
        List<Curso> cursosJava = new ArrayList<Curso>();
        List<Curso> cursos = this.getCursos();

        String palabra = "Java";
        String textoComparar;

        for (Curso cur : cursos){
            textoComparar = cur.getNombre();
            boolean contieneJava = textoComparar.contains(palabra);
            if (contieneJava){
               cursosJava.add(cur);
            }
        }
        return cursosJava;
    }
}
