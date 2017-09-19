package com.tep10.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by UG34QP on 18-9-2017.
 */

@Entity
@Table(name = "bestellingen")
@Builder
@AllArgsConstructor
@Data
public class Bestelling {
    @Id
    private Long bestelnr;
    @Column
    private Long levcode;
    @Column
    private Date besteldat;
    @Column
    private Date leverdat;
    @Column
    private Float bedrag;
    @Column
    private String status;

//    @OneToMany
//    @JoinColumn(name = "bestelregel_bestelnr")
//    private List<BestelRegel> bestelRegels = new ArrayList<>();

    public Bestelling() {
    }
}
