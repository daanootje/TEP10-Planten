package com.tep10.doa;

import com.tep10.model.Bestelling;
import com.tep10.model.Offerte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by UG34QP on 18-9-2017.
 */
public interface BestellingJPA extends JpaRepository<Bestelling, Long> {

    List<Bestelling> findBestellingByLevcode(Long levcode);

}
