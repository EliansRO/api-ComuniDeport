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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Registration")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "championship_id")
    private Integer championship_id;

    @Column(name = "team_id")
    private Integer team_id;

    @Column(name = "id_fixture")
    private Integer id_fixture;

    // One-to-Many relationship with TeaM
    @JsonIgnore
    @OneToMany(mappedBy = "registrationTeamList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Team> teamList = new ArrayList<>();

    // One-to-Many relationship with Fixture
    @JsonIgnore
    @OneToMany(mappedBy = "registrationFixtureList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Fixture> fixtureList = new ArrayList<>();

    // One-to-Many relationship with Team
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "championship_id")
    private List<Championship> championshipRegistrationList = new ArrayList<>();
}
