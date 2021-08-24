/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.schulung.wicket.kundenportal.panel;

import java.io.Serializable;
import java.sql.SQLException;

import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;
import de.intellinet.ausbildung.kundenportal.service.KundenAktualisierenService;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 01.04.2020
 */
public class KundenUpdatePanel extends KundenBearbeitenPanel implements Serializable {

    /**
     * Constructor.
     *
     * @param id
     * @param model
     */
    public KundenUpdatePanel(String id, IModel<Person> model) {
        super(id, model);
    }

    private static final Logger logger = LoggerFactory.getLogger(KundenUpdatePanel.class);

    @Override
    public void kundenSpeichern(Person person) throws ClassNotFoundException, SQLException {

        KundenAktualisierenService kundenAktualisierenService = new KundenAktualisierenService();

        kundenAktualisierenService.update(person);
    }
}
