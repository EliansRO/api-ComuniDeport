package com.comunideport.rest.Controllers.dto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.comunideport.rest.Entities.Registered;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Integer id;

    private String name;

    private Integer id_card;

    private String sex;

    private Date date_birth;

    private String health_status;

    private String email;

    private String password;

    private String phone;

    private String address;

    private String city;

    private String country;

    private String profile_picture_url;

    private String role;

    private LocalTime date_joined;

    private LocalTime last_login;

    private List<Registered> registeredList = new ArrayList<>();
}
