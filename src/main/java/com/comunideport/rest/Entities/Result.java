package com.comunideport.rest.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(name = "name")
    private String name;

    @Column(name = "id_card")
    private Integer id_card;

    @Column(name = "sex")
    private String sex;

    @Column(name = "date_birth")
    private Date date_birth;

    @Column(name = "health_status")
    private String health_status;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "team_local")
    private Integer team_local;

    @Column(name = "team_visit")
    private Integer team_visit;
}
