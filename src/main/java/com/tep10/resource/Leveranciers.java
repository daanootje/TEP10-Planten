package com.tep10.resource;

import com.tep10.doa.*;
import com.tep10.model.*;
import com.tep10.model.compositeKeys.BestelRegelCompositeKey;
import com.tep10.resource.interfaceApi.LeveranciersApi;
import com.tep10.util.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

import static com.tep10.util.Validator.checkNotNull;

/**
 * Created by UG34QP on 18-9-2017.
 */
@RestController
public class Leveranciers implements LeveranciersApi{

    private static final Logger log = LoggerFactory.getLogger(Leveranciers.class);

    private final LeverancierJPA leverancierJPA;
    private final OfferteJPA offerteJPA;
    private final BestellingJPA bestellingJPA;
    private final BestelRegelJPA bestelRegelJPA;
    private final GoedOntvangstJPA goedOntvangstJPA;
    private final PlantJPA plantJPA;

    public Leveranciers (LeverancierJPA leverancierJPA, OfferteJPA offerteJPA, BestellingJPA bestellingJPA,
                         BestelRegelJPA bestelRegelJPA, GoedOntvangstJPA goedOntvangstJPA, PlantJPA plantJPA) {
        this.leverancierJPA = leverancierJPA;
        this.offerteJPA = offerteJPA;
        this.bestellingJPA = bestellingJPA;
        this.bestelRegelJPA = bestelRegelJPA;
        this.goedOntvangstJPA = goedOntvangstJPA;
        this.plantJPA = plantJPA;
    }

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

    public ResponseEntity<Bestelling> setBestellingAtLeverancier(@PathVariable Long levcode, @PathVariable Long bestelnr,
                                                           @RequestBody Bestelling bestelling) throws NotFoundException {
        if (leverancierJPA.findLeverancierByLevcode(levcode) == null || bestellingJPA.findBestellingByLevcodeAndBestelnr(levcode, bestelnr) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            bestellingJPA.save(bestelling);
            return new ResponseEntity<>(bestellingJPA.findBestellingByLevcodeAndBestelnr(levcode, bestelnr), HttpStatus.OK);
        }
    }

    public ResponseEntity<Bestelling> getBestellingFromLeverancier(@PathVariable Long levcode, @PathVariable Long bestelnr) throws NotFoundException {
        Bestelling bestelling = bestellingJPA.findBestellingByLevcodeAndBestelnr(levcode, bestelnr);
        return checkNotNull(bestelling);
    }

    public ResponseEntity<List<BestelRegel>> getBesteRegelsFromBestelling(@PathVariable Long levcode, @PathVariable Long bestelnr) throws NotFoundException {
            List<BestelRegel> bestelRegels = bestelRegelJPA.findBestelRegelByBestelling_LevcodeAndBestelnr(levcode, bestelnr);
        return checkNotNull(bestelRegels);
    }

    public ResponseEntity<BestelRegel> getBesteRegelFromBestelling(@PathVariable Long levcode, @PathVariable Long bestelnr,
                                                             @PathVariable Long artcode) throws NotFoundException {
        BestelRegel bestelRegel = bestelRegelJPA.findBestelRegelByBestelling_LevcodeAndBestelnrAndArtcode(levcode, bestelnr, artcode);
        return checkNotNull(bestelRegel);
    }

    public ResponseEntity<BestelRegel>  setBesteRegelAtBestelling(@PathVariable Long levcode, @PathVariable Long bestelnr,
                                                           @PathVariable Long artcode, @RequestBody BestelRegel bestelRegel) throws NotFoundException {
        if (bestellingJPA.findBestellingByBestelnr(bestelnr) == null || plantJPA.findPlantByArtcode(artcode) == null ||
                bestelRegelJPA.findBestelRegelByBestelling_LevcodeAndBestelnrAndArtcode(levcode, bestelnr, artcode) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            bestelRegelJPA.save(bestelRegel);
            return new ResponseEntity<>(bestelRegelJPA.findBestelRegelByBestelling_LevcodeAndBestelnrAndArtcode(levcode, bestelnr, artcode), HttpStatus.OK);
        }
    }

    public ResponseEntity<List<GoedOntvangst>> getGoederenOntvangstFromBestelRegel(@PathVariable Long levcode, @PathVariable Long bestelnr,
                                                                             @PathVariable Long artcode) throws NotFoundException {
        List<GoedOntvangst> goederenOntvangst = goedOntvangstJPA.findGoedOntvangstByBestelRegel_Bestelling_LevcodeAndBestelnrAndArtcode(levcode, bestelnr, artcode);
        return checkNotNull(goederenOntvangst);
    }

    public ResponseEntity<GoedOntvangst> getGoedOntvangstFromBestelRegel(@PathVariable Long levcode, @PathVariable Long bestelnr,
                                                                        @PathVariable Long artcode, @PathVariable Date ontv_datum) throws NotFoundException {
        GoedOntvangst goedOntvangst = goedOntvangstJPA.findGoedOntvangstByBestelRegel_Bestelling_LevcodeAndBestelnrAndArtcodeAndOntvdatum(levcode, bestelnr,artcode, ontv_datum);
        return checkNotNull(goedOntvangst);
    }

    public ResponseEntity<GoedOntvangst> setGoedOntvangstAtBestelRegel(@PathVariable Long levcode, @PathVariable Long bestelnr,
                                                                 @PathVariable Long artcode, @PathVariable Date ontv_datum,
                                                                 @RequestBody GoedOntvangst goedOntvangst) throws NotFoundException {

        if (bestelRegelJPA.findBestelRegelByBestelling_LevcodeAndBestelnrAndArtcode(levcode, bestelnr, artcode) == null ||
                goedOntvangstJPA.findGoedOntvangstByBestelRegel_Bestelling_LevcodeAndBestelnrAndArtcodeAndOntvdatum(levcode, bestelnr, artcode, ontv_datum) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            goedOntvangstJPA.save(goedOntvangst);
            return new ResponseEntity<>(goedOntvangstJPA.findGoedOntvangstByBestelRegel_Bestelling_LevcodeAndBestelnrAndArtcodeAndOntvdatum(levcode, bestelnr, artcode, ontv_datum), HttpStatus.OK);
        }
    }
}
