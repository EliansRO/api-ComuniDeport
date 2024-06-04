package com.comunideport.rest.Controllers.dto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.comunideport.rest.Entities.Registration;
import com.comunideport.rest.Entities.Result;
import com.comunideport.rest.Entities.SportArena;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FixtureDTO {

    private Integer id;

    private LocalTime match_date;

    private List<SportArena> sportArenaList;

    private List<Result> resultList;

    private List<Registration> registrationList = new ArrayList<>();
}
