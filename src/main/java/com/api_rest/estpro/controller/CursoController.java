package com.api_rest.estpro.controller;

import com.api_rest.estpro.dto.CursoTemaDTO;
import com.api_rest.estpro.model.Curso;
import com.api_rest.estpro.model.Tema;
import com.api_rest.estpro.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CursoController {

    @Autowired
    private ICursoService iCursoServ;

    @PostMapping("/cursos/crear")
    public String crearCurso(@RequestBody Curso curso){
        iCursoServ.saveCurso(curso);
        return "El curso se creo con exito";
    }

    @PutMapping("/cursos/agregarTema/{id}")
    public void agregarTema(@PathVariable("id") Long id,
                              @RequestBody Tema tema){
        Curso curso = iCursoServ.findCurso(id);
    }

    @GetMapping("/cursos/traer")
    public List<Curso> getCursos(){
        return iCursoServ.getCursos();
    }

    @GetMapping("/cursos/temas/{id}")
    public CursoTemaDTO getTemasDeCurso(@PathVariable Long id){
        return iCursoServ.temasPorCurso(id);
    }

    @GetMapping("/cursos/buscarJava")
    public List<Curso> getCursosJava(){
        return iCursoServ.getCursosJava();
     }

    @PutMapping("/cursos/editar/{id}")
    public Curso editarCurso(@PathVariable("id") Long id,
        @RequestParam(required = false, name = "nombre") String nuevoNombre,
        @RequestParam(required = false, name = "modalidad") String nuevaModalidad,
        @RequestParam(required = false, name = "fecha_finalizacion") Date nuevaFecha){

        iCursoServ.editCurso(id, nuevoNombre, nuevaModalidad, nuevaFecha);
        Curso cursoSalida = iCursoServ.findCurso(id);
        return cursoSalida;

    }

}
