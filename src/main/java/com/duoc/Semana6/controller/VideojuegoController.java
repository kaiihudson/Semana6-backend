package com.duoc.Semana6.controller;

import com.duoc.Semana6.model.Videojuego;
import com.duoc.Semana6.service.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/videojuegos")
public class VideojuegoController {
    @Autowired
    private VideojuegoService videojuegoService;

    @GetMapping
    public @ResponseBody ArrayList<Videojuego> findall() {
        return videojuegoService.listarVideojuegos();
    }

    @GetMapping("/{id}")
    public @ResponseBody Videojuego findById(@PathVariable String reqId) {
        int id;
        try {
            id = Integer.parseInt(reqId);
        } catch (NumberFormatException e) {
            id = 0;
        }
        return videojuegoService.buscarVideojuegoId(id);
    }

    @GetMapping("titulo/{titulo}")
    public @ResponseBody Videojuego findByTitulo(@PathVariable String titulo){
        return videojuegoService.buscarVideojuegoTitulo(titulo);
    }

    @GetMapping("plataforma/{plataforma}")
    public @ResponseBody ArrayList<Videojuego> findByPlataforma(@PathVariable String plataforma){
        return videojuegoService.listarVideojuegoPlataforma(plataforma);
    }
}
