package com.tep10.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by UG34QP on 18-9-2017.
 */

@Entity
@Table(name = "leveranciers")
@Builder
@AllArgsConstructor
@Data
public class Leverancier {
    @Id
    private Long levcode;
    @Column
    private String levnaam;
    @Column
    private String adres;
    @Column
    private String woonplaats;

    public Leverancier () {
    }
}
