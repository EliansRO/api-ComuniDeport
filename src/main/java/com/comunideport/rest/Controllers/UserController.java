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

import com.comunideport.rest.Controllers.dto.UserDTO;
import com.comunideport.rest.Entities.User;
import com.comunideport.rest.Service.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){

        Optional<User> userOptional = userService.findById(id);

        if(userOptional.isPresent()){
            User user = userOptional.get();

            UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .id_card(user.getId_card())
                .sex(user.getSex())
                .date_birth(user.getDate_birth())
                .health_status(user.getHealth_status())
                .email(user.getEmail())
                .password(user.getPassword())
                .teamList(user.getTeamList())
                .build();

                return ResponseEntity.ok(userDTO);
        }
        
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<UserDTO> userDTOList = userService.findAll()
            .stream()
            .map(user -> UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .id_card(user.getId_card())
                .sex(user.getSex())
                .date_birth(user.getDate_birth())
                .health_status(user.getHealth_status())
                .email(user.getEmail())
                .password(user.getPassword())
                .teamList(user.getTeamList())
                .build()
            )
            .toList();

        return ResponseEntity.ok(userDTOList);
    }

    @PostMapping("/save/{id}")
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO, @PathVariable Integer id) throws URISyntaxException{

        if(userDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        userService.save(User.builder()
            .id(userDTO.getId())
            .name(userDTO.getName())
            .id_card(userDTO.getId_card())
            .sex(userDTO.getSex())
            .date_birth(userDTO.getDate_birth())
            .health_status(userDTO.getHealth_status())
            .email(userDTO.getEmail())
            .password(userDTO.getPassword())
            .build()
        );

        return ResponseEntity.created(new URI("/api/user/save")).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){

        if (id != null) {
            userService.deleteById(id);
            return ResponseEntity.ok("Exitoso!!" /* EDITAR LUEGO */);
        }

        return ResponseEntity.badRequest().build();
    }
}
