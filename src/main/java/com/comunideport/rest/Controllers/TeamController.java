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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comunideport.rest.Controllers.dto.TeamDTO;
import com.comunideport.rest.Entities.Team;
import com.comunideport.rest.Service.ITeamService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private ITeamService teamService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){

        Optional<Team> teamOptional = teamService.findById(id);

        if(teamOptional.isPresent()){
            Team team = teamOptional.get();

            TeamDTO teamDTO = TeamDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .foundation_year(team.getFoundation_year())
                .home_ground(team.getHome_ground())
                .city(team.getCity())
                .country(team.getCountry())
                .logo_url(team.getLogo_url())
                .contact_email(team.getContact_email())
                .website_url(team.getWebsite_url())
                .build();
            
            return ResponseEntity.ok(teamDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<TeamDTO> teamDTOList = teamService.findAll()
            .stream()
            .map(team -> TeamDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .foundation_year(team.getFoundation_year())
                .home_ground(team.getHome_ground())
                .city(team.getCity())
                .country(team.getCountry())
                .logo_url(team.getLogo_url())
                .contact_email(team.getContact_email())
                .website_url(team.getWebsite_url())
                .build()
            )
            .toList();

        return ResponseEntity.ok(teamDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody TeamDTO teamDTO) throws URISyntaxException{

        if(teamDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        teamService.save(Team.builder()
            .id(teamDTO.getId())
            .name(teamDTO.getName())
            .foundation_year(teamDTO.getFoundation_year())
            .home_ground(teamDTO.getHome_ground())
            .city(teamDTO.getCity())
            .country(teamDTO.getCountry())
            .logo_url(teamDTO.getLogo_url())
            .contact_email(teamDTO.getContact_email())
            .website_url(teamDTO.getWebsite_url())
            .build()
        );

        return ResponseEntity.created(new URI("/api/team/save")).build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateTeam(@PathVariable Integer id, @RequestBody TeamDTO teamDTO) {

        Optional<Team> teamOptional = teamService.findById(id);

        if(teamOptional.isPresent()){
            Team team = teamOptional.get();
            team.setName(teamDTO.getName());
            team.setDescription(teamDTO.getDescription());
            team.setFoundation_year(teamDTO.getFoundation_year());
            team.setHome_ground(teamDTO.getHome_ground());
            team.setCity(teamDTO.getCity());
            team.setCountry(teamDTO.getCountry());
            team.setLogo_url(teamDTO.getLogo_url());
            team.setContact_email(teamDTO.getContact_email());
            team.setContact_phone(teamDTO.getContact_phone());
            team.setWebsite_url(teamDTO.getWebsite_url());
            teamService.save(team);

            return ResponseEntity.ok("Existoso!!"/*Editar luego*/);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable Integer id){
        
        if (id != null) {
            teamService.deleteById(id);

            return ResponseEntity.ok("Exitoso!!" /* EDITAR LUEGO */);
        }

        return ResponseEntity.badRequest().build();
    }

}
