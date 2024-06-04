package com.comunideport.rest.Controllers.dto;

import java.util.ArrayList;
import java.util.List;

import com.comunideport.rest.Entities.Championship;
import com.comunideport.rest.Entities.ChampionshipBoard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SportDTO {

    private Integer id;

    private String name;

    private String description;

    private List<Championship> championshipList = new ArrayList<>();

    private List<ChampionshipBoard> championshipBoardList = new ArrayList<>();
}
