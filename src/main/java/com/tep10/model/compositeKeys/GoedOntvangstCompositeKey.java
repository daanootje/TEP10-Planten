package com.tep10.model.compositeKeys;

import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by UG34QP on 19-9-2017.
 */
public class GoedOntvangstCompositeKey implements Serializable {
    private Long bestelnr;
    private Long artcode;
    private Date ontv_datum;
}
