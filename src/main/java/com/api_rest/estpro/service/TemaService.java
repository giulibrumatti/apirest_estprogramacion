package com.api_rest.estpro.service;

import com.api_rest.estpro.model.Tema;
import com.api_rest.estpro.repository.ITemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemaService implements ITemaService{

    @Autowired
    private ITemaRepository iTemaRep;

    @Override
    public void saveTema(Tema tema) {
        iTemaRep.save(tema);
    }

    @Override
    public List<Tema> getTemas() {
        List<Tema> listaSalida = iTemaRep.findAll();
        return listaSalida;
    }

    @Override
    public void deleteTema(Long id) {
        iTemaRep.deleteById(id);
    }

    @Override
    public Tema findTema(Long id) {
        Tema tema = iTemaRep.findById(id).orElse(null);
        return tema;
    }

    @Override
    public void editTema(Long id, String nombreNuevo, String nuevoDescrip) {
        Tema tema = this.findTema(id);
        tema.setNombre(nombreNuevo);
        tema.setDescripcion(nuevoDescrip);
        this.saveTema(tema);
    }

    @Override
    public void editTema(Tema tema) {
        this.saveTema(tema);
    }
}
