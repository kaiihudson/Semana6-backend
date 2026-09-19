package com.duoc.Semana6.repository;

import com.duoc.Semana6.model.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, Integer> {
    Optional<Videojuego> findById(int id);

    Optional<Videojuego> findByTitulo(String normalizedTitulo);

    ArrayList<Videojuego> findallByPlataforma(String normalizedPlataforma);
}
