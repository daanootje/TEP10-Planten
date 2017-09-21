package com.tep10.resource.interfaceApi;

import com.tep10.model.*;
import com.tep10.util.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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
    ResponseEntity<Bestelling>  getBestellingFromLeverancier(@PathVariable Long levcode, @PathVariable Long bestelnr) throws NotFoundException;

    @RequestMapping(path = "{levcode}/bestellingen/{bestelnr}", method = RequestMethod.POST)
    ResponseEntity<Bestelling>  setBestellingAtLeverancier(@PathVariable Long levcode, @PathVariable Long bestelnr,
                                                           @RequestBody Bestelling bestelling) throws NotFoundException;

    @RequestMapping(path = "{levcode}/bestellingen/{bestelnr}/bestelregels", method = RequestMethod.GET)
    ResponseEntity<List<BestelRegel>>  getBesteRegelsFromBestelling(@PathVariable Long levcode, @PathVariable Long bestelnr) throws NotFoundException;

    @RequestMapping(path = "{levcode}/bestellingen/{bestelnr}/bestelregels/{artcode}", method = RequestMethod.GET)
    ResponseEntity<BestelRegel>  getBesteRegelFromBestelling(@PathVariable Long levcode, @PathVariable Long bestelnr,
                                                                   @PathVariable Long artcode) throws NotFoundException;

    @RequestMapping(path = "{levcode}/bestellingen/{bestelnr}/bestelregels/{artcode}", method = RequestMethod.POST)
    ResponseEntity<BestelRegel>  setBesteRegelAtBestelling(@PathVariable Long levcode, @PathVariable Long bestelnr,
                                                             @PathVariable Long artcode, @RequestBody BestelRegel bestelRegel) throws NotFoundException;

    @RequestMapping(path = "{levcode}/bestellingen/{bestelnr}/bestelregels/{artcode}/goederenontvangst", method = RequestMethod.GET)
    ResponseEntity<List<GoedOntvangst>>  getGoederenOntvangstFromBestelRegel(@PathVariable Long levcode, @PathVariable Long bestelnr,
                                                                             @PathVariable Long artcode) throws NotFoundException;

    @RequestMapping(path = "{levcode}/bestellingen/{bestelnr}/bestelregels/{artcode}/goederenontvangst/{ontv_datum}", method = RequestMethod.GET)
    ResponseEntity<GoedOntvangst>  getGoedOntvangstFromBestelRegel(@PathVariable Long levcode, @PathVariable Long bestelnr,
                                                                         @PathVariable Long artcode, @PathVariable Date ontv_datum) throws NotFoundException;

    @RequestMapping(path = "{levcode}/bestellingen/{bestelnr}/bestelregels/{artcode}/goederenontvangst/{ontv_datum}", method = RequestMethod.POST)
    ResponseEntity<GoedOntvangst>  setGoedOntvangstAtBestelRegel(@PathVariable Long levcode, @PathVariable Long bestelnr,
                                                                   @PathVariable Long artcode, @PathVariable Date ontv_datum,
                                                                 @RequestBody GoedOntvangst goedOntvangst) throws NotFoundException;


}
