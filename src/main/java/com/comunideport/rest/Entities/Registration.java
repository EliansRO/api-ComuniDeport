package com.comunideport.rest.Entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    // Many-to-Many relationship with TeaM
    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "registration_team",
        joinColumns = @JoinColumn(name = "registration_id"),
        inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private List<Team> teamList = new ArrayList<>();

    // Many-to-Many relationship with Fixture
    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "registration_fixture",
        joinColumns = @JoinColumn(name = "registration_id"),
        inverseJoinColumns = @JoinColumn(name = "fixture_id")
    )
    private List<Fixture> fixtureList = new ArrayList<>();

    // One-to-Many relationship with Team
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "championship_id", referencedColumnName = "id", insertable = false, updatable = false)
    private List<Championship> championshipList = new ArrayList<>();
}
