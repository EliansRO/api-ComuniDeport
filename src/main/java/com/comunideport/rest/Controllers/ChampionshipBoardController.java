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

import com.comunideport.rest.Controllers.dto.ChampionshipBoardDTO;
import com.comunideport.rest.Entities.ChampionshipBoard;
import com.comunideport.rest.Service.IChampionshipBoardService;

@RestController
@RequestMapping("/api/championshipBoard")
public class ChampionshipBoardController {

    @Autowired
    private IChampionshipBoardService championshipBoardService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<ChampionshipBoard> championshipBoardOptional = championshipBoardService.findById(id);

        if (championshipBoardOptional.isPresent()) {
            ChampionshipBoard championshipBoard = championshipBoardOptional.get();

            ChampionshipBoardDTO championshipBoardDTO = ChampionshipBoardDTO.builder()
                .id(championshipBoard.getId())
                .name(championshipBoard.getName())
                .description(championshipBoard.getDescription())
                .icon_url(championshipBoard.getIcon_url())
                .points(championshipBoard.getPoints())
                .sport(championshipBoard.getSport())
                .build();

            return ResponseEntity.ok(championshipBoardDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<ChampionshipBoardDTO> championshipBoardDTOs = championshipBoardService.findAll()
            .stream()
            .map(championshipBoard -> ChampionshipBoardDTO.builder()
                .id(championshipBoard.getId())
                .name(championshipBoard.getName())
                .description(championshipBoard.getDescription())
                .icon_url(championshipBoard.getIcon_url())
                .points(championshipBoard.getPoints())
                .sport(championshipBoard.getSport())
                .build()
            )
            .toList();

        return ResponseEntity.ok(championshipBoardDTOs);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ChampionshipBoardDTO championshipBoardDTO) throws URISyntaxException {
        if (championshipBoardDTO.getName().isBlank() || championshipBoardDTO.getSport() == null) {
            return ResponseEntity.badRequest().build();
        }

        ChampionshipBoard championshipBoard = ChampionshipBoard.builder()
            .id(championshipBoardDTO.getId())
            .name(championshipBoardDTO.getName())
            .description(championshipBoardDTO.getDescription())
            .icon_url(championshipBoardDTO.getIcon_url())
            .points(championshipBoardDTO.getPoints())
            .sport(championshipBoardDTO.getSport())
            .build();

        championshipBoardService.save(championshipBoard);

        return ResponseEntity.created(new URI("/api/championshipBoard/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateChampionshipBoard(@RequestBody ChampionshipBoardDTO championshipBoardDTO, @PathVariable Integer id) throws URISyntaxException {
        Optional<ChampionshipBoard> championshipBoardOptional = championshipBoardService.findById(id);

        if (championshipBoardOptional.isPresent()) {
            ChampionshipBoard championshipBoard = championshipBoardOptional.get();
            championshipBoard.setName(championshipBoardDTO.getName());
            championshipBoard.setDescription(championshipBoardDTO.getDescription());
            championshipBoard.setIcon_url(championshipBoardDTO.getIcon_url());
            championshipBoard.setPoints(championshipBoardDTO.getPoints());
            championshipBoard.setSport(championshipBoardDTO.getSport());

            championshipBoardService.save(championshipBoard);
            return ResponseEntity.ok("Exitoso!!");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteChampionshipBoard(@PathVariable Integer id) {
        if (id != null) {
            championshipBoardService.deleteById(id);
            return ResponseEntity.ok("Exitoso!!");
        }

        return ResponseEntity.badRequest().build();
    }
}