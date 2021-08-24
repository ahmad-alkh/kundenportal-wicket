/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.schulung.wicket.kundenportal.pages.components;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;
import de.intellinet.ausbildung.kundenportal.service.CSVService;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 30.06.2020
 */
public class SpeicherAlsCsvLink extends Link<Person> {

	private static final Logger logger = LoggerFactory.getLogger(SpeicherAlsCsvLink.class);

	/**
	 * Constructor.
	 *
	 */
	public SpeicherAlsCsvLink(String id, IModel<Person> personModel) {
		super(id, personModel);

	}

	@Override
	public void onClick() {
		logger.info(".CSV");
		Person personObjekt = getModelObject();

//		personObjekt.setName("Jomaa");
//		personObjekt.setVorname("Jamal");

		try {
			CSVService cSVService = new CSVService();
			cSVService.exportPersonen(personObjekt);
		} catch (Exception e) {
			logger.error("fehler bei .csv export");
			e.printStackTrace();
		}
	}

}
