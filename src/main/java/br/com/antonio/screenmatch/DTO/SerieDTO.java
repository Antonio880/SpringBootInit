package br.com.antonio.screenmatch.DTO;

import br.com.antonio.screenmatch.model.Categoria;

public record SerieDTO(
    Long id,
    String titulo,
    Integer totalTemporadas,
    Double avaliacao,
    Categoria genero,
    String atores,
    String poster,
    String sinopse
) {
}
