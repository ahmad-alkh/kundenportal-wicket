/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.schulung.wicket.kundenportal.pages;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;

import de.intellinet.ausbildung.kundenportal.persistence.entity.Person;
import de.intellinet.schulung.wicket.kundenportal.panel.KundenUpdatePanel;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 03.04.2020
 */
public class KundenUpdate extends KundenportalPage {

    private static final long serialVersionUID = 1L;

    KundenUpdatePanel kundenUpdatePanel;
    Link<Void> link;

    public KundenUpdate(IModel<Person> model) {
        super();

        kundenUpdatePanel = new KundenUpdatePanel("kundenpanel", model);

        link = new Link<Void>("zurueck") {

            @Override
            public void onClick() {
                setResponsePage(Index.class);
            }

        };
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(kundenUpdatePanel);

        add(link);

    }

}
