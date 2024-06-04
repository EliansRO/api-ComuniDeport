package com.comunideport.rest.Controllers.dto;

import java.util.ArrayList;
import java.util.List;

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

    private Integer user_id;

    private Integer team_id;

    private String user_rol;

    private List<User> userList = new ArrayList<>();

    private List<Team> teamList = new ArrayList<>();

}
