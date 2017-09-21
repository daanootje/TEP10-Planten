package com.tep10.resource;

import com.tep10.dao.PlantJPA;
import com.tep10.model.Plant;
import com.tep10.resource.interfaceApi.PlantenApi;
import com.tep10.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.tep10.resource.Validator.checkNotNull;

/**
 * Created by UG34QP on 20-9-2017.
 */
@RestController
public class Planten implements PlantenApi {

    private final PlantJPA plantJPA;

    @Autowired
    public Planten (PlantJPA plantJPA) {
        this.plantJPA = plantJPA;
    }

    public ResponseEntity<Plant> getPlant(@PathVariable Long artcode) throws NotFoundException {
        Plant plant = plantJPA.findPlantByArtcode(artcode);
        return checkNotNull(plant);
    }

}
