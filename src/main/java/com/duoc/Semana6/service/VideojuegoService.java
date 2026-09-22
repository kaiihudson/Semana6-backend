package com.duoc.Semana6.service;

import com.duoc.Semana6.model.Videojuego;
import com.duoc.Semana6.repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class VideojuegoService {
    @Autowired
    private VideojuegoRepository videojuegoRepository;


    public ArrayList<Videojuego> listarVideojuegos() {
        return (ArrayList<Videojuego>) videojuegoRepository.findAll();
    }

    public Videojuego buscarVideojuegoId(int id){
        Optional<Videojuego> videojuego = videojuegoRepository.findById(id);
        if(videojuego.isPresent()){
            return videojuego.orElse(null);
        } else {
            return null;
        }
    }

    public Videojuego buscarVideojuegoTitulo(String titulo){
        String normalizedTitulo = titulo.toLowerCase();
        Optional<Videojuego> videojuego = videojuegoRepository.findByTitulo(normalizedTitulo);
        if(videojuego.isPresent()){
            return videojuego.orElse(null);
        } else  {
            return null;
        }
    }

    public ArrayList<Videojuego> listarVideojuegoPlataforma(String plataforma){
        String normalizedPlataforma = plataforma.toLowerCase();
        return videojuegoRepository.findAllByPlataforma(normalizedPlataforma);
    }
}
