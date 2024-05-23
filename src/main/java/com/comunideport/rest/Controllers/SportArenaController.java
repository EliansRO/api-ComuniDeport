package com.comunideport.rest.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comunideport.rest.Controllers.dto.SportArenaDTO;
import com.comunideport.rest.Entities.SportArena;
import com.comunideport.rest.Service.ISportArenaService;

@RestController
@RequestMapping("/api/sportarena")
public class SportArenaController {

    @Autowired
    private ISportArenaService sportArenaService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){

        Optional<SportArena> sportArenaOptional = sportArenaService.findById(id);

        if(sportArenaOptional.isPresent()){

            SportArena sportArena = sportArenaOptional.get();

            SportArenaDTO sportArenaDTO = SportArenaDTO.builder()
                .name(sportArena.getName())
                .capacity(sportArena.getCapacity())
                .size(sportArena.getSize())
                .state(sportArena.getState())
                .hours(sportArena.getHours())
                .build();
            
                return ResponseEntity.ok(sportArenaDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<SportArenaDTO> sportArenaDTOList = sportArenaService.findAll()
            .stream()
            .map(sportArena -> SportArenaDTO.builder()
                .id(sportArena.getId())
                .name(sportArena.getName())
                .capacity(sportArena.getCapacity())
                .size(sportArena.getSize())
                .state(sportArena.getState())
                .hours(sportArena.getHours())
                .build()
            )
            .toList();

        return ResponseEntity.ok(sportArenaDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody SportArenaDTO sportArenaDTO) throws URISyntaxException{
        
        if (sportArenaDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        sportArenaService.save(SportArena.builder()
            .name(sportArenaDTO.getName())
            .capacity(sportArenaDTO.getCapacity())
            .size(sportArenaDTO.getSize())
            .state(sportArenaDTO.getState())
            .hours(sportArenaDTO.getHours())
            .build());

        return ResponseEntity.created(new URI("/api/sportarena/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSportArena(@PathVariable Integer id,@RequestBody SportArenaDTO sportArenaDTO){

        Optional<SportArena> sportArenaOptional = sportArenaService.findById(id);

        if(sportArenaOptional.isPresent()){
            SportArena sportArena = sportArenaOptional.get();
            sportArena.setName(sportArenaDTO.getName());
            sportArenaService.save(sportArena);

            return ResponseEntity.ok("Existoso!!"/*Editar luego*/);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSportArena(@PathVariable Integer id){

        if(id != null){
            sportArenaService.deleteById(id);

            return ResponseEntity.ok("Existoso!!"/*Editar luego*/);
        }

        return ResponseEntity.badRequest().build();
    }
}
