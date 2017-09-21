package com.tep10.resource.interfaceApi;

import com.tep10.model.Plant;
import com.tep10.util.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by UG34QP on 20-9-2017.
 */
@RequestMapping("planten")
public interface PlantenApi {

    @RequestMapping(path = "{artcode}", method = RequestMethod.GET)
    ResponseEntity<Plant> getPlant(@PathVariable Long artcode) throws NotFoundException;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<Plant>> getPlants() throws NotFoundException;

}
