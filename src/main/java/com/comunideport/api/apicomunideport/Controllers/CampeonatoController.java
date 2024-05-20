package com.comunideport.api.apicomunideport.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.comunideport.api.apicomunideport.Repositories.CampeonatoRepository;
import com.comunideport.api.apicomunideport.Entities.Campeonato;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping
public class CampeonatoController {

    @Autowired
    private CampeonatoRepository campeonatoRepository;

    @GetMapping
    public List<Campeonato> getAllCampeonatos(){
        return campeonatoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Campeonato getCampeonatoById(@PathVariable Long id){
        return campeonatoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("404"));

    }
    
    @PostMapping
    public Campeonato createCampeonato(@RequestBody Campeonato campeonato){
        return campeonatoRepository.save(campeonato);
    }
    
    @PutMapping("/{id}")
    public Campeonato updateCampeonato(@PathVariable Long id, @RequestBody Campeonato detailsCampeonato){
        Campeonato campeonato = campeonatoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("404"));

        campeonato.setNombre(detailsCampeonato.getNombre());

        return campeonatoRepository.save(campeonato);
    }

    @DeleteMapping("/{id}")
    public String deleteCampeonato(@PathVariable Long id){
        Campeonato campeonato = campeonatoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("404"));

        campeonatoRepository.delete(campeonato);

        return "200 OK";
    }
}
