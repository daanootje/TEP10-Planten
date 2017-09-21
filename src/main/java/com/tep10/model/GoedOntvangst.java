package com.tep10.model;

import com.tep10.model.compositeKeys.GoedOntvangstCompositeKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by UG34QP on 18-9-2017.
 */
@Entity
@IdClass(GoedOntvangstCompositeKey.class)
@Table(name = "goedontvangst")
@Builder
@AllArgsConstructor
@Data
public class GoedOntvangst {
    @Id
    @GeneratedValue
    private Long bestelnr;
    @Id
    @GeneratedValue
    private Long artcode;
    @Id
    @GeneratedValue
    @Column(name="ontv_datum", unique = true, nullable = false)
    private Date ontvdatum;
    @Column
    private Long ontv_aantal;
    @Column
    private String status;
    @Column
    private Long boekstuk;
    @Column
    private Long vlgnr;

    @ManyToOne
    @MapsId("artcode")
//    @MapsId("bestelnr")
    @JoinColumns( {
        @JoinColumn(name = "artcode"),
        @JoinColumn(name = "bestelnr")
    })
    private BestelRegel bestelRegel;

    public GoedOntvangst () {
    }
}
