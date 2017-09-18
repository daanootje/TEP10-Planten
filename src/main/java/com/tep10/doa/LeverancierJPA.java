package com.tep10.doa;

import com.tep10.model.Leverancier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

/**
 * Created by UG34QP on 18-9-2017.
 */
@RepositoryRestController
public interface LeverancierJPA extends JpaRepository<Leverancier, Long> {

    Leverancier findLeverancierByLevcode(Long levcode);

    Page<Leverancier> findAll(Pageable pageable);
}
