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

import com.comunideport.rest.Controllers.dto.RegistrationDTO;
import com.comunideport.rest.Entities.Registration;
import com.comunideport.rest.Service.IRegistrationService;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    @Autowired
    private IRegistrationService registrationService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<Registration> registrationOptional = registrationService.findById(id);

        if (registrationOptional.isPresent()) {
            Registration registration = registrationOptional.get();

            RegistrationDTO registrationDTO = RegistrationDTO.builder()
                .id(registration.getId())
                .team(registration.getTeam())
                .fixture(registration.getFixture())
                .championship(registration.getChampionship())
                .build();

            return ResponseEntity.ok(registrationDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<RegistrationDTO> registrationDTOs = registrationService.findAll()
            .stream()
            .map(registration -> RegistrationDTO.builder()
                .id(registration.getId())
                .team(registration.getTeam())
                .fixture(registration.getFixture())
                .championship(registration.getChampionship())
                .build()
            )
            .toList();

        return ResponseEntity.ok(registrationDTOs);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody RegistrationDTO registrationDTO) throws URISyntaxException {
        if (registrationDTO.getTeam() == null || registrationDTO.getFixture() == null || registrationDTO.getChampionship() == null) {
            return ResponseEntity.badRequest().build();
        }

        Registration registration = Registration.builder()
            .id(registrationDTO.getId())
            .team(registrationDTO.getTeam())
            .fixture(registrationDTO.getFixture())
            .championship(registrationDTO.getChampionship())
            .build();

        registrationService.save(registration);

        return ResponseEntity.created(new URI("/api/registration/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRegistration(@RequestBody RegistrationDTO registrationDTO, @PathVariable Integer id) throws URISyntaxException {
        Optional<Registration> registrationOptional = registrationService.findById(id);

        if (registrationOptional.isPresent()) {
            Registration registration = registrationOptional.get();
            registration.setTeam(registrationDTO.getTeam());
            registration.setFixture(registrationDTO.getFixture());
            registration.setChampionship(registrationDTO.getChampionship());

            registrationService.save(registration);
            return ResponseEntity.ok("Exitoso!!");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRegistration(@PathVariable Integer id) {
        if (id != null) {
            registrationService.deleteById(id);
            return ResponseEntity.ok("Exitoso!!");
        }

        return ResponseEntity.badRequest().build();
    }
}
