package com.comunideport.rest.Controllers.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.comunideport.rest.Entities.Registration;
import com.comunideport.rest.Entities.Sport;

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

    private List<Registration> registrationList = new ArrayList<>();

    private Sport sport;
}
