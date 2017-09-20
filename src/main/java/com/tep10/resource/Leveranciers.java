package com.tep10.resource;

import com.tep10.doa.*;
import com.tep10.model.*;
import com.tep10.resource.interfaceApi.LeveranciersApi;
import com.tep10.util.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

import static com.tep10.resource.Validator.checkNotNull;

/**
 * Created by UG34QP on 18-9-2017.
 */
@RestController
public class Leveranciers implements LeveranciersApi{

    private static final Logger log = LoggerFactory.getLogger(Leveranciers.class);

    @Autowired
    private LeverancierJPA leverancierJPA;

    @Autowired
    private OfferteJPA offerteJPA;

    @Autowired
    private BestellingJPA bestellingJPA;

    @Autowired
    private BestelRegelJPA bestelRegelJPA;

    @Autowired
    private GoedOntvangstJPA goedOntvangstJPA;

    public ResponseEntity<Leverancier> getLeverancier(@PathVariable(required = false) Long levcode) throws NotFoundException {
        Leverancier leverancier = leverancierJPA.findLeverancierByLevcode(levcode);
        return checkNotNull(leverancier);
    }

    public ResponseEntity<Leverancier> setLeverancier(@PathVariable Long levcode, @RequestBody Leverancier lev) throws NotFoundException {
        leverancierJPA.modifyLeverancier(lev.getAdres(), lev.getLevnaam(), lev.getWoonplaats(), levcode);
        Leverancier leverancier = leverancierJPA.findLeverancierByLevcode(levcode);
        return checkNotNull(leverancier);
    }

    public ResponseEntity<Page<Leverancier>> getAllLeverancier(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                               @RequestParam(value = "size", defaultValue = "5") Integer size) throws NotFoundException {
        return new ResponseEntity<>(leverancierJPA.findAll(new PageRequest(page, size)), HttpStatus.OK);
    }

    public ResponseEntity<List<Offerte>> getOffertesFromLeverancier(@PathVariable Long levcode) throws NotFoundException {
        List<Offerte> offertes = offerteJPA.findOfferteByLevcode(levcode);
        return checkNotNull(offertes);
    }

    public ResponseEntity<List<Bestelling>> getBestellingenFromLeverancier(@PathVariable Long levcode) throws NotFoundException {
        List<Bestelling> bestellingen = bestellingJPA.findBestellingByLevcode(levcode);
        return checkNotNull(bestellingen);
    }

    public ResponseEntity<Bestelling> getBestellingFromLeverancier(@PathVariable Long levcode, @PathVariable Long bestelnr) throws NotFoundException {
        Bestelling bestelling = bestellingJPA.findBestellingByLevcodeAndBestelnr(levcode, bestelnr);
        return checkNotNull(bestelling);
    }

    public ResponseEntity<List<BestelRegel>> getBesteRegelsFromBestelling(@PathVariable Long levcode, @PathVariable Long bestelnr) throws NotFoundException {
            List<BestelRegel> bestelRegels = bestelRegelJPA.findBestelRegelByBestelling_LevcodeAndBestelnr(levcode, bestelnr);
//        List<BestelRegel> bestelRegels = leverancierJPA.findLeverancierByLevcode(levcode)
//                .getBestellingen().stream()
//                .filter(best -> best.getBestelnr().equals(bestelnr))
//                .findFirst().get()
//                .getBestelRegels();
        return checkNotNull(bestelRegels);
    }

    public ResponseEntity<BestelRegel> getBesteRegelFromBestelling(@PathVariable Long levcode, @PathVariable Long bestelnr,
                                                             @PathVariable Long artcode) throws NotFoundException {
        BestelRegel bestelRegel = bestelRegelJPA.findBestelRegelByBestelling_LevcodeAndBestelnrAndArtcode(levcode, bestelnr, artcode);
        return checkNotNull(bestelRegel);
    }

    public ResponseEntity<List<GoedOntvangst>> getGoederenOntvangstFromBestelRegel(@PathVariable Long levcode, @PathVariable Long bestelnr,
                                                                             @PathVariable Long artcode) throws NotFoundException {
        List<GoedOntvangst> goederenOntvangst = goedOntvangstJPA.findGoedOntvangstByBestelRegel_Bestelling_LevcodeAndBestelnrAndArtcode(levcode, bestelnr, artcode);
        return checkNotNull(goederenOntvangst);
    }

    public ResponseEntity<GoedOntvangst>  getGoedOntvangstFromBestelRegel(@PathVariable Long levcode, @PathVariable Long bestelnr,
                                                                        @PathVariable Long artcode, @PathVariable Date ontv_datum) throws NotFoundException {
        GoedOntvangst goedOntvangst = goedOntvangstJPA.findGoedOntvangstByBestelRegel_Bestelling_LevcodeAndBestelnrAndArtcodeAndOntvdatum(levcode, bestelnr, artcode, ontv_datum);
        return checkNotNull(goedOntvangst);
    }


}
