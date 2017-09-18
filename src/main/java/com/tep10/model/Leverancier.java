package com.tep10.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by UG34QP on 18-9-2017.
 */

@Entity
@Builder
@AllArgsConstructor
@Data
public class Leverancier {
    @Id
    private Long levCode;
    @Column
    private String levNaam;
    @Column
    private String adres;
    @Column
    private String woonplaats;
}
