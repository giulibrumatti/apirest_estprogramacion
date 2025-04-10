package com.api_rest.estpro.service;

import com.api_rest.estpro.model.Tema;

import java.util.List;

public interface ITemaService {

    public void saveTema(Tema tema);

    public List<Tema> getTemas();

    public void deleteTema(Long id);

    public Tema findTema(Long id);

    public void editTema(Long id, String nombreNuevo, String nuevoDescrip);

    public void editTema(Tema tema);
}
