package com.tep10.resource;

import com.tep10.doa.BestellingJPA;
import com.tep10.doa.LeverancierJPA;
import com.tep10.doa.OfferteJPA;
import com.tep10.model.Bestelling;
import com.tep10.model.Leverancier;
import com.tep10.model.Offerte;
import com.tep10.resource.interfaceApi.LeveranciersApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.xml.ws.Response;
import java.util.List;

/**
 * Created by UG34QP on 18-9-2017.
 */
@RestController
@CrossOrigin("http://localhost:8081")
public class Leveranciers implements LeveranciersApi{

    private static final Logger log = LoggerFactory.getLogger(Leveranciers.class);

    @Autowired
    private LeverancierJPA leverancierJPA;

    @Autowired
    private OfferteJPA offerteJPA;

    @Autowired
    private BestellingJPA bestellingJPA;

    public ResponseEntity<Leverancier> getLeverancier(@PathVariable(required = false) Long levcode) {
        Leverancier leverancier = leverancierJPA.findLeverancierByLevcode(levcode);
        return checkNotNull(leverancier);
    }

    public ResponseEntity<Page<Leverancier>> getAllLeverancier(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                               @RequestParam(value = "size", defaultValue = "5") Integer size){
        return new ResponseEntity<>(leverancierJPA.findAll(new PageRequest(page, size)), HttpStatus.OK);
    }

    public ResponseEntity<List<Offerte>> getOffertesFromLeverancier(@PathVariable Long levcode){
        List<Offerte> offertes = offerteJPA.findOfferteByLevcode(levcode);
        return checkNotNull(offertes);
    }

    public ResponseEntity<List<Bestelling>> getBestellingenFromLeverancier(@PathVariable Long levcode) {
        List<Bestelling> bestellingen = bestellingJPA.findBestellingByLevcode(levcode);
        return checkNotNull(bestellingen);
    }

    private <T> ResponseEntity<T> checkNotNull (T object) {
        if (object == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(object, HttpStatus.OK);
        }
    }

}
