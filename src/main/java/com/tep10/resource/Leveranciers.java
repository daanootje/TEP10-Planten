package com.tep10.resource;

import com.tep10.doa.LeverancierJPA;
import com.tep10.model.Leverancier;
import com.tep10.resource.interfaceApi.LeveranciersApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by UG34QP on 18-9-2017.
 */
@RestController
public class Leveranciers implements LeveranciersApi{

    private static final Logger log = LoggerFactory.getLogger(Leveranciers.class);

    @Autowired
    private LeverancierJPA leverancierJPA;

    public ResponseEntity<Leverancier> getLeverancier(@PathVariable Long levcode) {
        Leverancier leverancier = leverancierJPA.findLeverancierByLevcode(levcode);
        if (leverancier == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(leverancier, HttpStatus.OK);
        }
    }
}
