package com.tep10.model;

import com.tep10.model.compositeKeys.BestelRegelCompositeKey;
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
@IdClass(BestelRegelCompositeKey.class)
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
    @Column(columnDefinition="Decimal(4,2) default '100.00'")
    private Float bestelprijs;

    @ManyToOne
    @JoinColumn(name = "BestelRegelCompositeKey")
    private Bestelling bestelling;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bestelRegel")
    private List<GoedOntvangst> goedOntvangsten = new ArrayList<>();

//    @ManyToOne
//    @JoinColumn(name = "BestelRegelCompositeKey.artcode")
//    private Plant plant;

    public BestelRegel () {
    }
}
