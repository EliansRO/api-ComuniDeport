package com.comunideport.rest.Entities;

import jakarta.persistence.Column;
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
@Table(name = "Registered")
public class Registered {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_rol")
    private String user_rol;

    // One-to-Many relationship with User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // One-to-Many relationship with Team
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}   
