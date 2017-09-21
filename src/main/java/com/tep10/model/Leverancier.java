package com.tep10.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by UG34QP on 18-9-2017.
 */

@Entity
@Table(name = "leveranciers")
@Builder
@AllArgsConstructor
@Data
public class Leverancier {
    @Id
    private Long levcode;
    @Column
    private String levnaam;
    @Column
    private String adres;
    @Column
    private String woonplaats;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "levcode")
    @Cascade(CascadeType.ALL)
    private List<Bestelling> bestellingen = new ArrayList<>();

    @OneToMany(mappedBy = "levcode")
    private List<Offerte> offertes = new ArrayList<>();

    public Leverancier () {}
}
