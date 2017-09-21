package com.tep10.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.tep10.model.compositeKeys.BestelRegelCompositeKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by UG34QP on 18-9-2017.
 */
@Entity
@IdClass(BestelRegelCompositeKey.class)
@Table(name = "bestelregels")
@Builder
@AllArgsConstructor
@Data
public class BestelRegel {
    @Id
    @GeneratedValue
    private Long bestelnr;
    @Id
    @GeneratedValue
    private Long artcode;
    @Column
    private Long aantal;
    @Column(columnDefinition="Decimal(4,2) default '100.00'")
    private Float bestelprijs;

    @ManyToOne
    @MapsId("bestelnr")
    @JoinColumn(name = "bestelnr")
    private Bestelling bestelling;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bestelRegel")
    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<GoedOntvangst> goedOntvangsten = new ArrayList<>();

//    @ManyToOne
//    @JoinColumn(name = "BestelRegelCompositeKey.artcode")
//    private Plant plant;

    public BestelRegel () {
    }
}
