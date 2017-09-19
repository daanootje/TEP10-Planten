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
    @Column
    private Float bestelprijs;

    @ManyToOne(optional = false)
    private Bestelling bestelling;

//    @OneToMany
//    @JoinColumn(name = "goed__ontvangst_bestelnr")
//    private List<GoedOntvangst> goedOntvangsten = new ArrayList<>();

    @ManyToOne(optional = false)
    private Plant plant;

    public BestelRegel () {
    }
}
