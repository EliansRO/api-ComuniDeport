package com.comunideport.rest.Controllers.dto;

import com.comunideport.rest.Entities.Championship;
import com.comunideport.rest.Entities.Fixture;
import com.comunideport.rest.Entities.Team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationDTO {

    private Integer id;

    private Team team;

    private Fixture fixture;

    private Championship championship;

}
