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
import de.intellinet.ausbildung.kundenportal.service.KundenAktualisierenService;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 27.03.2020
 */
public class LoeschenKundeLink extends Link<Person> {

	private static final Logger logger = LoggerFactory.getLogger(LoeschenKundeLink.class);

	public LoeschenKundeLink(String id, IModel<Person> personModel) {
		super(id, personModel);
	}

	@Override
	public void onClick() {
		logger.info("delete");
		Person personObjekt = getModelObject();
		try {
			KundenAktualisierenService kundenAktualisierenService = new KundenAktualisierenService();
			kundenAktualisierenService.loeschePerson(personObjekt);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// getWarenkorb().getCheeses()d.add(selected);
	}

}
