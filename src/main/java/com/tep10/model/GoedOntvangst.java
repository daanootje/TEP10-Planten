package com.tep10.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by UG34QP on 18-9-2017.
 */
@Entity
@Table(name = "goed_ontvangst")
@Builder
@AllArgsConstructor
@Data
public class GoedOntvangst {
    @Id
    private Long bestelnr;
    @Id
    private Long artcode;
    @Id
    private Date ontv_datum;
    @Column
    private Long ontv_aantal;
    @Column
    private String status;
    @Column
    private Long boekstuk;
    @Column
    private Long vlgnr;

    @ManyToOne(optional = false)
    BestelRegel bestelRegel;

    public GoedOntvangst () {
    }
}
