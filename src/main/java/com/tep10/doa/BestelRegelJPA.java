package com.tep10.doa;

import com.tep10.model.BestelRegel;
import com.tep10.model.Bestelling;
import com.tep10.model.compositeKeys.BestelRegelCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.sql.Date;
import java.util.List;

/**
 * Created by UG34QP on 19-9-2017.
 */
@RepositoryRestController
public interface BestelRegelJPA  extends JpaRepository<BestelRegel, BestelRegelCompositeKey> {

    List<BestelRegel> findBestelRegelByBestelling_LevcodeAndBestelnr(Long levcode, Long bestelnr);

    BestelRegel findBestelRegelByBestelling_LevcodeAndBestelnrAndArtcode(Long levcode, Long bestelnr, Long artcode);

}
