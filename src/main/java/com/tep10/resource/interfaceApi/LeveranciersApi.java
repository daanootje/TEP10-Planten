package com.tep10.resource.interfaceApi;

import com.tep10.model.Bestelling;
import com.tep10.model.Leverancier;
import com.tep10.model.Offerte;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by UG34QP on 18-9-2017.
 */
@RequestMapping("leveranciers")
@CrossOrigin("https://localhost:8081")
public interface LeveranciersApi {

    @RequestMapping(path = "{levcode}", method = RequestMethod.GET)
    ResponseEntity<Leverancier> getLeverancier(@PathVariable Long levcode); // throws ChangeSetPersister.NotFoundException;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<Page<Leverancier>> getAllLeverancier(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(value = "size", defaultValue = "5") Integer size); // throws ChangeSetPersister.NotFoundException;

    @RequestMapping(path = "{levcode}/offertes", method = RequestMethod.GET)
    ResponseEntity<List<Offerte>> getOffertesFromLeverancier(@PathVariable Long levcode); // throws ChangeSetPersister.NotFoundException;

    @RequestMapping(path = "{levcode}/bestellingen", method = RequestMethod.GET)
    ResponseEntity<List<Bestelling>>  getBestellingenFromLeverancier(@PathVariable Long levcode); // throws ChangeSetPersister.NotFoundException;

}
