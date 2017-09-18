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
@Table(name = "bestelregels")
@Builder
@AllArgsConstructor
@Data
public class BestelRegel {
    @Id
    private Long bestelnr;
    @Id
    private Long artcode;
    @Column
    private Long aantal;
    @Column
    private Float bestelprijs;

    @ManyToOne(optional = false)
    private Bestelling bestelling;

    @OneToMany
    @JoinColumn(name = "goed_ontvangst_bestelnr")
    private List<GoedOntvangst> goedOntvangsten = new ArrayList<>();

    @ManyToOne(optional = false)
    private Plant plant;

    public BestelRegel () {
    }
}
