package com.comunideport.rest.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    // Many-to-Many relationship with Fixture
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fixture_id")
    private Fixture fixture;

    // One-to-Many relationship with Team
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "championship_id")
    private Championship championship;
}
