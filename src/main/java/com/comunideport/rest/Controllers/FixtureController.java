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

import com.comunideport.rest.Controllers.dto.FixtureDTO;
import com.comunideport.rest.Entities.Fixture;
import com.comunideport.rest.Service.IFixtureService;

@RestController
@RequestMapping("/api/fixture")
public class FixtureController {

    @Autowired
    private IFixtureService fixtureService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<Fixture> fixtureOptional = fixtureService.findById(id);

        if (fixtureOptional.isPresent()) {
            Fixture fixture = fixtureOptional.get();

            FixtureDTO fixtureDTO = FixtureDTO.builder()
                .id(fixture.getId())
                .match_date(fixture.getMatch_date())
                .sportArena(fixture.getSportArena())
                .result(fixture.getResult())
                .build();

            return ResponseEntity.ok(fixtureDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<FixtureDTO> fixtureDTOs = fixtureService.findAll()
            .stream()
            .map(fixture -> FixtureDTO.builder()
                .id(fixture.getId())
                .match_date(fixture.getMatch_date())
                .sportArena(fixture.getSportArena())
                .result(fixture.getResult())
                .build()
            )
            .toList();

        return ResponseEntity.ok(fixtureDTOs);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody FixtureDTO fixtureDTO) throws URISyntaxException {
        if (fixtureDTO.getSportArena() == null || fixtureDTO.getResult() == null) {
            return ResponseEntity.badRequest().build();
        }

        Fixture fixture = Fixture.builder()
            .id(fixtureDTO.getId())
            .match_date(fixtureDTO.getMatch_date())
            .sportArena(fixtureDTO.getSportArena())
            .result(fixtureDTO.getResult())
            .build();

        fixtureService.save(fixture);

        return ResponseEntity.created(new URI("/api/fixture/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFixture(@RequestBody FixtureDTO fixtureDTO, @PathVariable Integer id) throws URISyntaxException {
        Optional<Fixture> fixtureOptional = fixtureService.findById(id);

        if (fixtureOptional.isPresent()) {
            Fixture fixture = fixtureOptional.get();
            fixture.setMatch_date(fixtureDTO.getMatch_date());
            fixture.setSportArena(fixtureDTO.getSportArena());
            fixture.setResult(fixtureDTO.getResult());

            fixtureService.save(fixture);
            return ResponseEntity.ok("Exitoso!!");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFixture(@PathVariable Integer id) {
        if (id != null) {
            fixtureService.deleteById(id);
            return ResponseEntity.ok("Exitoso!!");
        }

        return ResponseEntity.badRequest().build();
    }
}