package com.tep10.dao;

import com.tep10.model.Bestelling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

/**
 * Created by UG34QP on 18-9-2017.
 */
@RepositoryRestController
public interface BestellingJPA extends JpaRepository<Bestelling, Long> {

    List<Bestelling> findBestellingByLevcode(Long levcode);

    Bestelling findBestellingByLevcodeAndBestelnr(Long levcode, Long bestelnr);

}
