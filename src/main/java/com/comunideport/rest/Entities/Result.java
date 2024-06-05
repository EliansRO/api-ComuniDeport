package com.comunideport.rest.Entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "Result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "team_local")
    private Integer team_local;

    @Column(name = "team_visit")
    private Integer team_visit;

    @Column(name = "score_local")
    private Integer score_local;

    @Column(name = "score_visit")
    private Integer score_visit;

    @JsonIgnore
    @OneToMany(mappedBy = "result", cascade = CascadeType.ALL)
    private List<Fixture> fixtureList = new ArrayList<>();
}
