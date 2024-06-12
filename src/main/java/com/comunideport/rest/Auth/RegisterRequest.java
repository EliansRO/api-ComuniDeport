package com.comunideport.rest.Auth;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.comunideport.rest.Entities.Registered;
import com.comunideport.rest.Entities.Enum.RoleUser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    Integer id;

    String name;

    Integer id_card;

    String sex;

    Date date_birth;

    String health_status;

    String email;

    String password;

    String phone;

    String address;

    String city;

    String country;

    String profile_picture_url;

    RoleUser role;

    LocalTime date_joined;

    LocalTime last_login;

    List<Registered> registeredList = new ArrayList<>();
}
