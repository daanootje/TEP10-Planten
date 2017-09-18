package com.tep10.resource.interfaceApi;

import com.tep10.model.Leverancier;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by UG34QP on 18-9-2017.
 */
@RequestMapping("leveranciers")
public interface LeveranciersApi {

    @RequestMapping(path = "{levcode}", method = RequestMethod.GET)
//    ResponseEntity<Leverancier> getLeverancier(@PathVariable(required = false) String levcode); // throws ChangeSetPersister.NotFoundException;
    String getLeverancier(@PathVariable String levcode); // throws ChangeSetPersister.NotFoundException;

}
