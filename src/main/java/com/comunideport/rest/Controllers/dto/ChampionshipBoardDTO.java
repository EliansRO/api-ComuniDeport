package com.comunideport.rest.Controllers.dto;

import com.comunideport.rest.Entities.Sport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChampionshipBoardDTO {

    private Integer id;
    
    private String name;

    private String description;

    private String icon_url;

    private Float points;

    private Sport sport;
}
