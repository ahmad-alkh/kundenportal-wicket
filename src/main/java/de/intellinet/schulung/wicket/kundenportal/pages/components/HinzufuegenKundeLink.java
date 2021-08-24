/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.schulung.wicket.kundenportal.pages.components;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.wicket.markup.html.link.Link;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;
import de.intellinet.ausbildung.kundenportal.service.KundenAktualisierenService;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 27.03.2020
 */
public class HinzufuegenKundeLink extends Link<Person> {

    private static final Logger logger = LoggerFactory.getLogger(HinzufuegenKundeLink.class);

    public HinzufuegenKundeLink(String id) {
        super(id);
    }

    @Override
    public void onClick() {
        logger.info("Hinzufuegen");
        Person person = new Person();

        person.setName("Tobi");
        person.setVorname("Martin");
        person.setGeburtsdatum(LocalDate.of(1959, 01, 8));
        person.setGeburtsname(null);
        person.setGeburtsort("");
        person.setStaatsangehoerigkeit("Leb");
        person.setAnlagedatum(LocalDateTime.of(2020, 06, 05, 12, 11, 11));
        person.setAenderungsdatum(LocalDateTime.of(2020, 07, 05, 12, 11, 11));

        KundenAktualisierenService kundenAktualisierenService = new KundenAktualisierenService();
        try {
            kundenAktualisierenService.hinzufuegen(person);
        } catch (Exception e) {
            logger.error("fehler passiert", e);

        }
        // getWarenkorb().getCheeses()d.add(selected);
    }

}
