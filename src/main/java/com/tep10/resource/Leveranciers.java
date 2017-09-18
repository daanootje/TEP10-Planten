package com.tep10.resource;

import com.tep10.doa.LeverancierJPA;
import com.tep10.model.Leverancier;
import com.tep10.resource.interfaceApi.LeveranciersApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by UG34QP on 18-9-2017.
 */
@RestController
public class Leveranciers implements LeveranciersApi{

    @Autowired
    private LeverancierJPA leverancierJPA;

    public String getLeverancier(@PathVariable String levcode) {
        //TODO: Insert Could not find method
//        return new ResponseEntity<>(leverancierJPA.findLeverancierByLevCode(levcode), HttpStatus.OK);
        return "GET: " + levcode;
    }
}
