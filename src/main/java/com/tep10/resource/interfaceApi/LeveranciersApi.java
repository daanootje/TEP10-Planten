package com.tep10.resource.interfaceApi;

import com.tep10.model.BestelRegel;
import com.tep10.model.Bestelling;
import com.tep10.model.Leverancier;
import com.tep10.model.Offerte;
import com.tep10.util.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by UG34QP on 18-9-2017.
 */
@RequestMapping("leveranciers")
public interface LeveranciersApi {

    @RequestMapping(path = "{levcode}", method = RequestMethod.GET)
    ResponseEntity<Leverancier> getLeverancier(@PathVariable Long levcode) throws NotFoundException;

    @RequestMapping(path = "{levcode}", method = RequestMethod.POST)
    ResponseEntity<Leverancier> setLeverancier(@PathVariable Long levcode, @RequestBody Leverancier lev) throws NotFoundException;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<Page<Leverancier>> getAllLeverancier(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(value = "size", defaultValue = "5") Integer size) throws NotFoundException;

    @RequestMapping(path = "{levcode}/offertes", method = RequestMethod.GET)
    ResponseEntity<List<Offerte>> getOffertesFromLeverancier(@PathVariable Long levcode) throws NotFoundException;

    @RequestMapping(path = "{levcode}/bestellingen", method = RequestMethod.GET)
    ResponseEntity<List<Bestelling>>  getBestellingenFromLeverancier(@PathVariable Long levcode) throws NotFoundException;

    @RequestMapping(path = "{levcode}/bestellingen/{bestelnr}", method = RequestMethod.GET)
    ResponseEntity<List<BestelRegel>>  getBesteRegelsFromBestelling(@PathVariable Long levcode, @PathVariable Long bestelnr) throws NotFoundException;

}
