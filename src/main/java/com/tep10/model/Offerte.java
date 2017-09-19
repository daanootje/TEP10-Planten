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
    @Column(columnDefinition="Decimal(4,2) default '100.00'")
    private Float offprijs;

    @ManyToOne
    @JoinColumn(name = "OfferteCompositeKey.artcode")
    private Plant plant;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "OfferteCompositeKey.levcode")
    private Leverancier leverancier;

    public Offerte () {
    }
}
