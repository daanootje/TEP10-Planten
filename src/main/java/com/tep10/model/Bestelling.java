package com.tep10.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
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
    @GeneratedValue
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
//    @JoinColumn(name = "bestelling_levcode", referencedColumnName = "levcode")
//    private Leverancier leverancier;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bestelnr")
    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<BestelRegel> bestelRegels = new ArrayList<>();

    public Bestelling(){
    }
}
