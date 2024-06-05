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

import com.comunideport.rest.Controllers.dto.RegisteredDTO;
import com.comunideport.rest.Entities.Registered;
import com.comunideport.rest.Service.IRegisteredService;

@RestController
@RequestMapping("/api/registered")
public class RegisteredController {

    @Autowired
    private IRegisteredService registeredService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<Registered> registeredOptional = registeredService.findById(id);

        if (registeredOptional.isPresent()) {
            Registered registered = registeredOptional.get();

            RegisteredDTO registeredDTO = RegisteredDTO.builder()
                .id(registered.getId())
                .user_rol(registered.getUser_rol())
                .user(registered.getUser())
                .team(registered.getTeam())
                .build();

            return ResponseEntity.ok(registeredDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<RegisteredDTO> registeredDTOs = registeredService.findAll()
            .stream()
            .map(registered -> RegisteredDTO.builder()
                .id(registered.getId())
                .user_rol(registered.getUser_rol())
                .user(registered.getUser())
                .team(registered.getTeam())
                .build()
            )
            .toList();

        return ResponseEntity.ok(registeredDTOs);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody RegisteredDTO registeredDTO) throws URISyntaxException {
        if (registeredDTO.getUser() == null || registeredDTO.getTeam() == null || registeredDTO.getUser_rol().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        Registered registered = Registered.builder()
            .id(registeredDTO.getId())
            .user_rol(registeredDTO.getUser_rol())
            .user(registeredDTO.getUser())
            .team(registeredDTO.getTeam())
            .build();

        registeredService.save(registered);

        return ResponseEntity.created(new URI("/api/registered/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRegistered(@RequestBody RegisteredDTO registeredDTO, @PathVariable Integer id) throws URISyntaxException {
        Optional<Registered> registeredOptional = registeredService.findById(id);

        if (registeredOptional.isPresent()) {
            Registered registered = registeredOptional.get();
            registered.setUser_rol(registeredDTO.getUser_rol());
            registered.setUser(registeredDTO.getUser());
            registered.setTeam(registeredDTO.getTeam());

            registeredService.save(registered);
            return ResponseEntity.ok("Exitoso!!");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRegistered(@PathVariable Integer id) {
        if (id != null) {
            registeredService.deleteById(id);
            return ResponseEntity.ok("Exitoso!!");
        }

        return ResponseEntity.badRequest().build();
    }
}
