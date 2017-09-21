package com.tep10.dao;

import com.tep10.model.Offerte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

/**
 * Created by UG34QP on 18-9-2017.
 */
@RepositoryRestController
public interface OfferteJPA extends JpaRepository<Offerte, Long> {

    List<Offerte> findOfferteByLevcode(Long levcode);

}
