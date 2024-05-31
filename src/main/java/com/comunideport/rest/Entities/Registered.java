package com.comunideport.rest.Entities;


import java.util.ArrayList;
import java.util.List;

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
@Table(name = "Registered")
public class Registered {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "team_id")
    private Integer team_id;

    @Column(name = "user_rol")
    private String user_rol;

    // One-to-Many relationship with User
    @OneToMany(mappedBy = "registered", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> userList = new ArrayList<>();

    // One-to-Many relationship with Team
    @OneToMany(mappedBy = "registered", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Team> teamList = new ArrayList<>();
}   
