package com.comunideport.rest.Controllers.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.comunideport.rest.Entities.SportArena;
import com.comunideport.rest.Entities.Team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChampionshipDTO {

    private Integer id;

    private String name;

    private String description;

    private String phone;

    private String state;

    private Boolean open_enrollment;

    private Date start_date;

    private Date end_date;

    private String sport;

    private Integer id_sports_arena;

    private List<Team> teamList = new ArrayList<>();

    private SportArena sportArena;
}
