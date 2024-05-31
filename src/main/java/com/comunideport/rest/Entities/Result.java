package com.comunideport.rest.Entities;

import java.util.Date;
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

    @OneToMany(
        mappedBy = "resultList",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    ) 
    private List<Fixture> fixtureList;
}
