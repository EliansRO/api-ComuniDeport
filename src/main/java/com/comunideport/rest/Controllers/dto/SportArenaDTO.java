package com.comunideport.rest.Controllers.dto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.comunideport.rest.Entities.Championship;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SportArenaDTO {

    private Integer id;

    private String name;

    private Integer capacity;

    private Float size;

    private Boolean state;

    private LocalTime hours;

    private List<Championship> championshipList = new ArrayList<>();
}
