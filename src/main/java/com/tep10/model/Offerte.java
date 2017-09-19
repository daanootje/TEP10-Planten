package com.tep10.model;

import com.tep10.model.compositeKeys.OfferteCompositeKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by UG34QP on 18-9-2017.
 */
@Entity
@IdClass(OfferteCompositeKey.class)
@Table(name = "offertes")
@Builder
@AllArgsConstructor
@Data
public class Offerte {
    @Id
    private Long levcode;
    @Id
    private Long artcode;
    @Column
    private String artcodelev;
    @Column
    private Long levtijd;
    @Column
    private Float offprijs;

    @ManyToOne(optional = false)
    private Plant plant;

    @ManyToOne(optional = false)
    private Leverancier leverancier;

    public Offerte () {
    }
}
