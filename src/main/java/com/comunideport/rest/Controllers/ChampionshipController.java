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

import com.comunideport.rest.Controllers.dto.ChampionshipDTO;
import com.comunideport.rest.Entities.Championship;
import com.comunideport.rest.Service.IChampionshipService;

@RestController
@RequestMapping("/api/championship")
public class ChampionshipController {

    @Autowired
    private IChampionshipService championshipService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){

        Optional<Championship> championshipOptional = championshipService.findById(id);

        if(championshipOptional.isPresent()){
            Championship championship = championshipOptional.get();

            ChampionshipDTO championshipDTO = ChampionshipDTO.builder()
                .id(championship.getId())
                .name(championship.getName())
                .description(championship.getDescription())
                .phone(championship.getPhone())
                .state(championship.getState())
                .open_enrollment(championship.getOpen_enrollment())
                .start_date(championship.getStart_date())
                .end_date(championship.getEnd_date())
                .sport(championship.getSport())
                .build();
            
            return ResponseEntity.ok(championshipDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<ChampionshipDTO> championshipDTOList = championshipService.findAll()
            .stream()
            .map(championship -> ChampionshipDTO.builder()
                .id(championship.getId())
                .name(championship.getName())
                .description(championship.getDescription())
                .phone(championship.getPhone())
                .state(championship.getState())
                .open_enrollment(championship.getOpen_enrollment())
                .start_date(championship.getStart_date())
                .end_date(championship.getEnd_date())
                .sport(championship.getSport())
                .build()
            )
            .toList();

        return ResponseEntity.ok(championshipDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ChampionshipDTO championshipDTO) throws URISyntaxException{
        
        if(championshipDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        championshipService.save(Championship.builder()
            //COMPLETAR!!
            .name(championshipDTO.getName())
            .build()
        );

        return ResponseEntity.created(new URI("/api/championship/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateChampionship(@PathVariable Integer id, @RequestBody ChampionshipDTO championshipDTO){
        
        Optional<Championship> championshipOptional = championshipService.findById(id);

        if(championshipOptional.isPresent()){
            Championship championship = championshipOptional.get();
            championship.setName(championshipDTO.getName());
            championshipService.save(championship);

            return ResponseEntity.ok("Existoso!!"/*Editar luego*/);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteChampionship(@PathVariable Integer id){
        
        if(id != null){
            championshipService.deleteById(id);

            return ResponseEntity.ok("Exitoso!!" /* EDITAR LUEGO */);
        }

        return ResponseEntity.badRequest().build();
    }

}
