/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.schulung.wicket.kundenportal.pages.components;

import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.wicket.markup.html.link.Link;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;
import de.intellinet.ausbildung.kundenportal.service.KundenSuchService;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 09.04.2020
 */
public class SuchKundeLink extends Link<Person> {

    private static final Logger logger = LoggerFactory.getLogger(SuchKundeLink.class);

    /**
     * Constructor.
     *
     */
    public SuchKundeLink(String id) {
        super(id);
    }

    @Override
    public void onClick() {
        logger.info("suche");
        Person personObjekt = new Person();
        KundenSuchService kundenSuchService = new KundenSuchService();
        personObjekt.setName("Hannes");
        personObjekt.setVorname("Majed");
        personObjekt.setGeburtsdatum(LocalDate.of(2002, 03, 10));
        personObjekt.setGeburtsname("");
        personObjekt.setGeburtsort("Hassen");
        personObjekt.setStaatsangehoerigkeit("De");

        try {
            kundenSuchService.sucheNachVorOderNachNameOderGeburtsdatum(personObjekt.getName(),
                    personObjekt.getVorname(), personObjekt.getGeburtsdatum());
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
