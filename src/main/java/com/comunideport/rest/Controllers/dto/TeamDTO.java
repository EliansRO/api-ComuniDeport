package com.comunideport.rest.Controllers.dto;

import java.util.ArrayList;
import java.util.List;

import com.comunideport.rest.Entities.Registered;
import com.comunideport.rest.Entities.Registration;

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

    private String description;

    private Integer foundation_year;

    private String home_ground;

    private String city;

    private String country;

    private String logo_url;

    private String contact_email;

    private String contact_phone;

    private String website_url;

    private List<Registered> registeredList = new ArrayList<>();

    private List<Registration> registrationList = new ArrayList<>();
}
