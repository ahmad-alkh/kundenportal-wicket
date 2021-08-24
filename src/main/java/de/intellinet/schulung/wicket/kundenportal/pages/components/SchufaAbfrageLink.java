/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.schulung.wicket.kundenportal.pages.components;

import java.sql.SQLException;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;
import de.intellinet.ausbildung.kundenportal.service.SchaufaService;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 18.03.2021
 */
public class SchufaAbfrageLink extends Link<Person> {

    private static final Logger logger = LoggerFactory.getLogger(SchufaAbfrageLink.class);

    public SchufaAbfrageLink(String id, IModel<Person> personModel) {
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
        logger.info("Schufa");
        Person personObjekt = getModelObject();
        SchaufaService schaufaService = new SchaufaService();
        // SchufaErgebnis SchufaErgibniss = schaufaService.getSchufaDaten(personObjekt);

    }

}
