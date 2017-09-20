package com.tep10.doa;

import com.tep10.model.GoedOntvangst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.sql.Date;
import java.util.List;

/**
 * Created by UG34QP on 20-9-2017.
 */
@RepositoryRestController
public interface GoedOntvangstJPA extends JpaRepository<GoedOntvangst, Long> {

    List<GoedOntvangst> findGoedOntvangstByBestelRegel_Bestelling_LevcodeAndBestelnrAndArtcode(Long levcode, Long bestelnr, Long artcode);

    GoedOntvangst findGoedOntvangstByBestelRegel_Bestelling_LevcodeAndBestelnrAndArtcodeAndOntvdatum(Long levcode, Long bestelnr, Long artcode, Date ontv_datum);

}
