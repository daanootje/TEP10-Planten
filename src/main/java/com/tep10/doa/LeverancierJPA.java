package com.tep10.doa;

import com.tep10.model.Leverancier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

/**
 * Created by UG34QP on 18-9-2017.
 */
@RepositoryRestController
public interface LeverancierJPA extends JpaRepository<Leverancier, Long> {

//    @Query("SELECT l from Leverancier l where l.levcode > 0")
    Leverancier findLeverancierByLevcode(Long levcode);

    @Query("SELECT l from Leverancier l where l.levcode > 0")
    List<Leverancier> findByLevcode();

}
