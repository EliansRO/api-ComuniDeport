package com.comunideport.rest.Entities;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "Championship")
public class Championship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "phone")
    private String phone;

    @Column(name = "state")
    private String state;

    @Column(name = "open_enrollment")
    private Boolean open_enrollment;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "sport")
    private String sport;

    @JsonIgnore
    @OneToMany(
        mappedBy = "championshipList",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private List<Registration> registrationList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "championshipSportList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sport> sportList = new ArrayList<>();
}
