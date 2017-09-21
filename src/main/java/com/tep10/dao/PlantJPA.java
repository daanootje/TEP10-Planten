package com.tep10.dao;

import com.tep10.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

/**
 * Created by UG34QP on 20-9-2017.
 */
@RepositoryRestController
public interface PlantJPA extends JpaRepository<Plant, Long> {

    Plant findPlantByArtcode(Long artcode);

}
