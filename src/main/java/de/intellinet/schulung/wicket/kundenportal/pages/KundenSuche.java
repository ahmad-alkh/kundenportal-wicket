/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.schulung.wicket.kundenportal.pages;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;
import de.intellinet.schulung.wicket.kundenportal.panel.KundenSuchePanel;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 15.04.2020
 */
public class KundenSuche extends KundenportalPage {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 *
	 */
	public KundenSuche() {
		super();
	}

	@Override
	public void onInitialize() {
		super.onInitialize();
		add(new KundenSuchePanel("kundenpanel", Model.of(new Person())));

		add(new Link<Void>("zurueck") {

			@Override
			public void onClick() {
				setResponsePage(Index.class);

			}

		});
	}

}
