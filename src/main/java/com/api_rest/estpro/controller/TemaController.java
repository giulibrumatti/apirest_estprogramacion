package com.api_rest.estpro.controller;

import com.api_rest.estpro.model.Curso;
import com.api_rest.estpro.model.Tema;
import com.api_rest.estpro.service.ITemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TemaController {
    @Autowired
    private ITemaService iTemaServ;

    @PostMapping("/temas/crear")
    public String crearTema(@RequestBody Tema tema){
        iTemaServ.saveTema(tema);
        return "El tema fue creado con éxito";
    }

    @GetMapping("/temas/traer")
    public List<Tema> getCursos(){
        return iTemaServ.getTemas();
    }


    @PutMapping("/temas/editar/{id}")
    public Tema editarCurso(@PathVariable("id") Long id,
                             @RequestParam(required = false, name = "nombre") String nuevoNombre,
                             @RequestParam(required = false, name = "descripcion") String nuevaDescrip){

        iTemaServ.editTema(id, nuevoNombre, nuevaDescrip);
        Tema temaSalida = iTemaServ.findTema(id);
        return temaSalida;

    }

    @PutMapping("/temas/editar")
    public Tema editarCurso(@RequestBody Tema tema){
        iTemaServ.editTema(tema);
        return iTemaServ.findTema(tema.getIdTema());
    }
}
