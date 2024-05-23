package com.comunideport.rest.Controllers.dto;

import java.util.ArrayList;
import java.util.List;

import com.comunideport.rest.Entities.Championship;
import com.comunideport.rest.Entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamDTO {

    private Integer id;

    private String name;

    private Integer id_card;

    private List<User> userList = new ArrayList<>();

    private List<Championship> championshipList = new ArrayList<>();
}
