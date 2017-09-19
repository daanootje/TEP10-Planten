package com.tep10.model.compositeKeys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by UG34QP on 19-9-2017.
 */
@Builder
@AllArgsConstructor
@Data
public class OfferteCompositeKey implements Serializable {
    private Long levcode;
    private Long artcode;

    public OfferteCompositeKey () {
    }
}
