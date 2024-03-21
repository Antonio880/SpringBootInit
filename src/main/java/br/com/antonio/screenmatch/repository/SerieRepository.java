package br.com.antonio.screenmatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.antonio.screenmatch.model.Serie;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}