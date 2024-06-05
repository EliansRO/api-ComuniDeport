package com.comunideport.rest.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comunideport.rest.Controllers.dto.SportDTO;
import com.comunideport.rest.Entities.Sport;
import com.comunideport.rest.Service.ISportService;

@RestController
@RequestMapping("/api/sport")
public class SportController {

    @Autowired
    private ISportService sportService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){

        Optional<Sport> sportOptional = sportService.findById(id);

        if (sportOptional.isPresent()) {
            Sport sport = sportOptional.get();

            SportDTO sportDTO = SportDTO.builder()
                .id(sport.getId())
                .name(sport.getName())
                .description(sport.getDescription())
                .build();

            return ResponseEntity.ok(sportDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<SportDTO> sportDTOs = sportService.findAll()
            .stream()
            .map(sport -> SportDTO.builder()
                .id(sport.getId())
                .name(sport.getName())
                .description(sport.getDescription())
                .build()
            )
            .toList();

        return ResponseEntity.ok(sportDTOs);
    }
}
