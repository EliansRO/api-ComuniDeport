package com.comunideport.rest.Controllers.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.comunideport.rest.Entities.Team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Integer id;

    private String name;

    private Integer id_card;

    private String sex;

    private Date date_birth;

    private String health_status;

    private String email;

    private String password;

    private List<Team> teamList = new ArrayList<>();
}
