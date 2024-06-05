package com.comunideport.rest.Controllers.dto;

import com.comunideport.rest.Entities.Team;
import com.comunideport.rest.Entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisteredDTO {

    private Integer id;

    private String user_rol;

    private User user;

    private Team team;

}
