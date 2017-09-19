package com.tep10.doa;

import com.tep10.model.Leverancier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.RepositoryRestController;

/**
 * Created by UG34QP on 18-9-2017.
 */
@RepositoryRestController
public interface LeverancierJPA extends JpaRepository<Leverancier, Long> {

    Leverancier findLeverancierByLevcode(Long levcode);

    Page<Leverancier> findAll(Pageable pageable);

    @Modifying(clearAutomatically = true)
    @Query("update Leverancier l set l.adres = ?1, l.levnaam = ?2, l.woonplaats = ?3 where l.levcode = ?4")
    void modifyLeverancier(String adres, String levnaam, String woonplaats, Long levcode);
}
