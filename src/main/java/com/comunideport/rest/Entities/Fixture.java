package com.comunideport.rest.Entities;

import java.time.LocalTime;
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
@Table(name = "Fixture")

public class Fixture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "match_date")
    private LocalTime match_date;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sportArena_id")
    private SportArena sportArena;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "result_id")
    private Result result;

    @JsonIgnore
    @OneToMany(mappedBy = "fixture", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Registration> registrationList = new ArrayList<>();
}
