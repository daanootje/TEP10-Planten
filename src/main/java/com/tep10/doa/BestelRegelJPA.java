package com.tep10.doa;

import com.tep10.model.BestelRegel;
import com.tep10.model.Bestelling;
import com.tep10.model.compositeKeys.BestelRegelCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by UG34QP on 19-9-2017.
 */
public interface BestelRegelJPA  extends JpaRepository<BestelRegel, BestelRegelCompositeKey> {

//    SELECT MAX(p.price) FROM PurchaseOrde o JOIN o.orderLineItems l JOIN l.product p JOIN p.supplier s WHERE s.sup_name = 'Tortuga Trading'"

    @Query("select br from BestelRegel br join br.bestelling b where b.levcode = ?1 and br.bestelnr = ?2")
    List<BestelRegel> findBestelRegelByBestelling_LevcodeAndBestelnr(Long levcode, Long bestelnr);

}
