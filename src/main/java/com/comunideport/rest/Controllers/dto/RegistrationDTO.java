package com.comunideport.rest.Controllers.dto;

import java.util.ArrayList;
import java.util.List;

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

    private List<Team> teamList = new ArrayList<>();

    private List<Fixture> fixtureList = new ArrayList<>();

    private List<Championship> championshipList = new ArrayList<>();

}
