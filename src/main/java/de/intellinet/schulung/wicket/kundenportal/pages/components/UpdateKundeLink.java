/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.schulung.wicket.kundenportal.pages.components;

import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Adresse;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Kontakt;
import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;
import de.intellinet.ausbildung.kundenportal.service.KundenAktualisierenService;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 02.04.2020
 */
public class UpdateKundeLink extends Link<Person> {

    private static final Logger logger = LoggerFactory.getLogger(UpdateKundeLink.class);

    public UpdateKundeLink(String id, IModel<Person> personModel) {
        super(id, personModel);
    }

    /**
     * Constructor.
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     *
     */
    @Override
    public void onClick() {
        System.out.println("update");

        Person person = this.getModelObject();
        // person.setKontakt(new Kontakt());
        Kontakt kontakt = person.getKontakt();
        // person.setAdresse(new Adresse());
        Adresse adresse = person.getAdresse();

        KundenAktualisierenService kundenAktualisierenService = new KundenAktualisierenService();

        person.setName("Hannes");
        person.setVorname("Majed");
        person.setGeburtsdatum(LocalDate.of(2002, 03, 10));
        person.setGeburtsname("");
        person.setGeburtsort("Hassen");
        person.setStaatsangehoerigkeit("De");

        kontakt.setEmail("asdjsadas@ffo.d");
        kontakt.setMobil("01445555");
        kontakt.setTelefon("00011444555");
        adresse.setStrasse("QramsStr.");
        adresse.setPlz("56465");
        adresse.setOrt("Fschinsch");
        adresse.setLand("DE");
        adresse.setPerson_id(person.getId());
        try {
            kundenAktualisierenService.update(person);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("fehler bei update");
            e.printStackTrace();
        }

    }

}
