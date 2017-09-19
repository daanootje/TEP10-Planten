package com.tep10.model.compositeKeys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by UG34QP on 19-9-2017.
 */
@Builder
@AllArgsConstructor
@Data
public class BestelRegelCompositeKey implements Serializable {
    private Long bestelnr;
    private Long artcode;

    public BestelRegelCompositeKey () {
    }
}
