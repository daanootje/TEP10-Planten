package com.tep10.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by UG34QP on 18-9-2017.
 */
@Entity
@Table(name = "planten")
@Builder
@AllArgsConstructor
@Data
public class Plant {
    @Id
    private Long artcode;
    @Column
    private String plantennaam;
    @Column
    private String soort;
    @Column
    private String kleur;
    @Column
    private Long hoogte;
    @Column
    private Long bloeibeg;
    @Column
    private Long bloeieind;
    @Column(columnDefinition="Decimal(4,2) default '100.00'")
    private Float prijs;
    @Column
    private Float vrr_aantal;
    @Column
    private Float vrr_min;
    @Column
    private String BTWtype;

    @OneToMany(mappedBy = "plant")
    private List<BestelRegel> bestelRegels = new ArrayList<>();

    @OneToMany(mappedBy = "plant")
    private List<Offerte> offertes = new ArrayList<>();

    public Plant () {
    }
}
