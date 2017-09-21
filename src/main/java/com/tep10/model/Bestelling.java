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
    @Column(columnDefinition="Decimal(6,2) default '100.00'")
    private Double bedrag;
    @Column
    private String status;

//    @ManyToOne
//    @MapsId("levcode")
//    @JoinColumn(name = "levcode")
//    private Leverancier leverancier;

    @OneToMany(mappedBy = "bestelnr")
    @JsonIgnore
    private List<BestelRegel> bestelRegels = new ArrayList<>();

    public Bestelling(){
    }
}
