package com.comunideport.rest.Controllers.dto;

import java.util.List;

import com.comunideport.rest.Entities.Fixture;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultDTO {

    private Integer id;

    private Integer team_local;

    private Integer team_visit;

    private Integer score_local;

    private Integer score_visit;

    private List<Fixture> fixtureList;
}
