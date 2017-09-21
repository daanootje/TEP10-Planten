package com.tep10.resource;

import com.tep10.model.Leverancier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by UG34QP on 21-9-2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LeveranciersTest {

    private static final Logger log = LoggerFactory.getLogger(LeveranciersTest.class);

    @Autowired
    private Leveranciers leveranciers;

    @Test
    public void getSingleLeverancier() throws Exception{
//        Leveranciers leveranciers = new Leveranciers();

        ResponseEntity<Leverancier> response = leveranciers.getLeverancier(19L);

        Leverancier leverancier = response.getBody();

//        assertEquals("Should return 200", 200, response.getStatusCode());
        assertTrue("Leverancier should not be null", response.getBody() != null);
        assertTrue(leverancier.getLevcode() == 19L);
        assertEquals(leverancier.getLevnaam(), "MOOIWEER FA.");
        assertEquals(leverancier.getAdres(), "VERLENGDE ZOMERSTR. 24");
        assertEquals(leverancier.getWoonplaats(), "AALSMEER");
        assertFalse(leverancier.getBestellingen().isEmpty());
        assertFalse(leverancier.getOffertes().isEmpty());
    }

//    @Test
//    public void getAllLeverancier() throws Exception{
//        Leveranciers leveranciers = new Leveranciers();
//
//        ResponseEntity<Page<Leverancier>> response = leveranciers.getAllLeverancier(0,5);
//        List<Leverancier> list = response.getBody().getContent();
//
//        assertEquals("Should return 200", 200, response.getStatusCode());
//        assertFalse("List should be filled", list.isEmpty());
//        assertEquals("There should be 11 leveranciers", list.size(),11);
//    }
//
//    @Test
//    public void setBestellingAtLeverancier() throws Exception {
//
//
//
//
//
//    }
}
