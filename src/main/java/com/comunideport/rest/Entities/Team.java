package com.comunideport.rest.Entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "foundation_year")
    private Integer foundation_year;

    @Column(name = "home_ground")
    private String home_ground;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "logo_url")
    private String logo_url;

    @Column(name = "contact_email")
    private String contact_email;

    @Column(name = "contact_phone")
    private String contact_phone;

    @Column(name = "website_url")
    private String website_url;

    @JsonIgnore
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Registered> registeredList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Registration> registrationList = new ArrayList<>();
}   
