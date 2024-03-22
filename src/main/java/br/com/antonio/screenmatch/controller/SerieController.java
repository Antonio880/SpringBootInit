package br.com.antonio.screenmatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.antonio.screenmatch.DTO.EpisodioDTO;
import br.com.antonio.screenmatch.DTO.SerieDTO;
import br.com.antonio.screenmatch.services.SerieService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/series")
public class SerieController {
    
    @Autowired
    private SerieService servico;

    @GetMapping
    public List<SerieDTO> obterSeries() {
       return servico.obterTodasAsSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> obterTop5Series() {
        return servico.obterTop5Series();
    }

    @GetMapping("/lancamentos")
    public List<SerieDTO> obterLancamentos() {
        return servico.obterLancamentos();
    }

    @GetMapping("/{id}")
    public SerieDTO obterPorId(@PathVariable Long id) {
        return servico.obterPorId(id);
    }

    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDTO> obterTodasTemporadas(@PathVariable Long id) {
        return servico.obterTodasTemporadas(id);
    }

    @GetMapping("/{id}/temporadas/{numeroTemporada}")
    public List<EpisodioDTO> getMethodName(@PathVariable Long id, @PathVariable Long numeroTemporada) {
        return servico.obterTemporadasPorNumero(id, numeroTemporada);
    }
    @GetMapping("/categoria/{nomeGenero}")
    public List<SerieDTO> obterSeriesPorCategoria(@PathVariable String nomeGenero){
        return servico.obterSeriesPorCategoria(nomeGenero);
    }
    
}